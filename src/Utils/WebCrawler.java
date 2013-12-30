/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author YangC
 */
public class WebCrawler {
    
    private HttpClient httpClient = null;
    public static String CHARSET_ENCODING = "UTF-8";
    public static String USER_AGENT = "Mozilla/4.0 (compatible; MSIE 7.0; Win32)";
    byte[] contentBytes = null;
    
//    private HttpResponse response;
    
    private HttpRequestRetryHandler requestRetryHandler = new HttpRequestRetryHandler() {

        @Override
        public boolean retryRequest(IOException ioe, int executionCount, HttpContext hc) {
//            throw new UnsupportedOperationException("Not supported yet.");
            if (executionCount >= 3) {  
                // 如果连接次数超过了最大值则停止重试  
                System.err.println("Exceed the maximum connection count");
                return false;  
            }
            if(ioe instanceof NoHttpResponseException){
                // 如果服务器连接失败重试
                System.err.println("Failed to connect to the server");
                return true;
            }
            HttpRequest request = (HttpRequest) hc.getAttribute(ExecutionContext.HTTP_REQUEST);
            boolean idempotent = (request instanceof HttpEntityEnclosingRequest);
            if(!idempotent){
                return true;
            }
            return false;
        }
    };
    
    private void getDefaultClient(){
        if(httpClient == null){
            httpClient = new DefaultHttpClient();
            httpClient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, USER_AGENT); 
            httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
            ((AbstractHttpClient) httpClient).setHttpRequestRetryHandler(requestRetryHandler);
        }
    }
    
    public String getContentMethod2(String url){
        String content = null;
        getDefaultClient();
        try {
            HttpGet httpGet = new HttpGet(url);
//            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.2)");
            HttpResponse response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = response.getEntity();
                if(entity != null){
                    InputStream instream = entity.getContent();
                    byte[] contentBytes = IOUtils.toByteArray(instream);
//                    byte[] contentBytes = EntityUtils.toByteArray(entity);
                    String encode = ContentType.getOrDefault(entity).getCharset().toString();
                    System.out.append("*******");
                    if(encode == null){
                        encode = getEncode(contentBytes);
                    }
                    if(encode == null){
                        content = new String(contentBytes, CHARSET_ENCODING);
                    }else{
                        content = new String(contentBytes, encode);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            httpClient.getConnectionManager().shutdown();
            return content;
        }
    }
    
    public String[] getContent(String url){
        getDefaultClient();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.2)");
        ResponseHandler<String[]> handler = new ResponseHandler<String[]>() {

            @Override
            public String[] handleResponse(HttpResponse hr) throws ClientProtocolException, IOException {
//                    throw new UnsupportedOperationException("Not supported yet.");
                HttpEntity entity = hr.getEntity();
                String[] retVal = new String[2];
                String content = null;
                if(entity != null){
                    InputStream instream = entity.getContent();
                    contentBytes = IOUtils.toByteArray(instream);
                    String encode = ContentType.getOrDefault(entity).getCharset().toString();
                    if(encode == null){
                        encode = getEncode(contentBytes);
                    }
                    if(encode == null){
                        content = new String(contentBytes, CHARSET_ENCODING);
                    }else{
                        content = new String(contentBytes, encode);
                    }
                    retVal[0] = encode;
                    retVal[1] = content;
                    return retVal;
                }else{
                    return null;
                }
            }
        };
        String[] retVal = null;; 
        String content = null;
        try {
            retVal = httpClient.execute(httpGet, handler);
        } catch (IOException ex) {
            Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
//            httpClient.getConnectionManager().shutdown();
            if(retVal == null && contentBytes != null){
                retVal = new String[2]; 
                String encode = getEncode(contentBytes);
                if(encode == null){
                    encode = CHARSET_ENCODING;
                }
                try {
                    retVal[1] = new String(contentBytes, encode);
                    retVal[0] = encode;
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return retVal;
        }
    }
    
    private String getEncode(byte[] contentBytes){
        String regEx="(?=<meta).*?(?<=charset=[\\'|\\\"]?)([[a-z]|[A-Z]|[0-9]|-]*)";
        Pattern p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(new String(contentBytes));
        if(m.find() && m.groupCount() == 1){
            return m.group(1);
        }else{
            return null;
        }
    }
    
}
