/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topicmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


/**
 *
 * @author YangC
 */
public class TopicModel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://bbs.tianya.cn/list-develop-1.shtml");
//        ResponseHandler<String> responseHandler = new BasicResponseHandler();
//        String body = httpClient.execute(httpGet, responseHandler);
//        System.out.println(body);
//        httpClient.getConnectionManager().shutdown();
        HttpResponse response = httpClient.execute(httpGet);
        
        System.out.println(response.getStatusLine());
//        System.out.println(response.toString());
        HttpEntity entity = response.getEntity();
        if(entity != null){
//            String encoding = null;
//            if(entity.getContentEncoding() != null){
//                encoding = entity.getContentEncoding().getValue();
//            }
////            String encoding = entity.getContentEncoding().getValue();
//            System.out.println("内容编码是：" + entity.getContentEncoding()); 
////            System.out.println("编码是：" + EntityUtils.getContentCharSet(entity));
//            
            System.out.println(entity.getContentType().getValue());
            System.out.println(ContentType.getOrDefault(entity).getCharset().toString());
            EntityUtils.consume(entity);
//            if(encoding == null){
//                String contentType = entity.getContentType().toString();
//                if(contentType.indexOf("charset=") != -1){
//                    encoding = contentType.substring(contentType.indexOf("charset=")+8);
//                    System.out.println(encoding);
//                }
//            }
//            System.out.println("内容类型是：" + entity.getContentType()); 
//            System.out.println("内容长度是：" + entity.getContentLength());
            /*读内容方法一
            System.out.println(EntityUtils.toString(entity));
            *
            */
            
            //读内容方法二 recommended
//            InputStream instream = entity.getContent();
//            BufferedReader reader;
//            if(encoding != null){
//                reader = new BufferedReader(new InputStreamReader(instream, encoding));
//            }else{
//                reader = new BufferedReader(new InputStreamReader(instream));
//            }
////            reader.mark(1000);
//            String line;
//            StringBuffer sb = new StringBuffer();
//            while((line = reader.readLine()) != null){
//                System.out.println(line);
//                sb.append(line).append("\n");
//            }
//              sb.toString();
//            System.out.println(reader.readLine());
//            System.out.println(reader.readLine());
//            reader.reset();
//            System.out.println(reader.readLine());
//            System.out.println(reader.readLine());
//            instream.close();
            
        }
//        httpGet.releaseConnection();
        httpClient.getConnectionManager().shutdown();
    }
}
