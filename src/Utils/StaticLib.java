/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author YangC
 */
public class StaticLib {
    
    public static Set<String> tagSet = null;
    
    public static String extractorRulesPath = "extractorRulesCpy_1.xml";
    
    public static void initialTagSet(){
        tagSet = new HashSet<String>();
        tagSet.add("li");
        tagSet.add("ol");
        tagSet.add("dl");
        tagSet.add("dt");
        tagSet.add("dd");
        tagSet.add("tr");
        tagSet.add("td");
        tagSet.add("th");
    }
    
    public static String getBaseUrl(String url){
        if(url.startsWith("http://")){
            int slashIndex = url.indexOf("/", 7);
            if(slashIndex == -1){
                return url + "/";
            }else{
                return url.substring(0, slashIndex+1);
            }
        }else{
            return null;
        }
    }
    
    public static boolean changeFile(String sourceFilePath, String destFilePath){
    	String source = new Storage().readFile(sourceFilePath);
    	StringBuffer destContent = new StringBuffer();
    	String[] sourceUnit = source.split("\n");
    	int flagNum1 = 0;
    	int flagNum2 = 0;
    	for(int i=0; i<sourceUnit.length; i++){
    		if(sourceUnit[i].equals("")){
    			destContent.append("\r\n");
    			flagNum1 = 0;
    			flagNum2 = 0;
    			continue;
    		}
    		String[] features = sourceUnit[i].split("\\s+");
//    		boolean flag = false;
    		for(int j=0; j<features.length-2; j++){
    			
//    			if(j == 2){
//    				if(Integer.valueOf(features[j]) >= 30){
//    					destContent.append(features[j] + " " + 
//    							features[j+1] + " " +
//    							features[j+2] + " true ");
//    				}else{
//    					destContent.append(features[j] + " " + 
//    							features[j+1] + " " +
//    							features[j+2] + " false ");
//    				}
//    			}
//    			if(j >= 2 && j <= 4){
//    				continue;
//    			}
    			destContent.append(features[j] + " ");
//    			if(j == 7){
//    				if(features[j].equals("true") || features[j+1].equals("true")
//    						|| features[j+2].equals("true") || features[j+3].equals("true")){
////    					flag = true;
//    					++flagNum1;
//    					destContent.append(flagNum1 + " ");
//    				}else{
//    					destContent.append(0 + " ");
//    				}
//    				 
//    			}
//    			if(j == 14){
//    				if(features[j].equals("true") || features[j+2].equals("true")
//    						|| features[j+4].equals("true")){
//    					++flagNum2;
//    					destContent.append(flagNum2 + " ");
//    				}else{
//    					destContent.append(0 + " ");
//    				}
//    				destContent.append(features[j+1] + " ");
//    				destContent.append(features[j+3] + " ");
//    			}
//    			if(j>=7 && j<=18){
//    				continue;
//    			}
    			
//    			destContent.append(features[j] + " ");
//    			if(j == 11){
//    				if(features[j].equals("true") || features[j+1].equals("true")
//    						|| features[j+2].equals("true")){
//    					flag = true;
//    					++flagNum;
//    				}
//    			}
    		}
    		destContent.append(features[features.length-2] + "\r\n");
    	}
    	return new Storage().saveFile(destFilePath, destContent.toString(), false);
    }
    
    public static boolean convertCRFPPFileToGRMMFile(String sourceFilePath, String sourceTemplateFilePath, int labelNum, String destFilePath){
    	String template = new Storage().readFile(sourceTemplateFilePath);
    	String source = new Storage().readFile(sourceFilePath);
    	if(template == null || source == null){
    		return false;
    	}
    	String[] templateUnit = template.split("\n");
    	String[] sourceUnit = source.split("\n");
    	StringBuffer destContent = new StringBuffer();
    	for(int i=0; i<sourceUnit.length; i++){
//    		System.out.println("***********  i=" + i + "************");
    		if(sourceUnit[i].equals("")){
    			destContent.append("\r\n");
    			continue;
    		}
//    		String[] features = sourceUnit[i].split("\\s+");
    		int size = sourceUnit[i].split("\\s+").length;
    		for(int k=0; k<labelNum; k++){
    			destContent.append(sourceUnit[i].split("\\s+")[size-labelNum+k] + " ");
    		}
    		destContent.append("---- ");
    		for(int j=0; j<templateUnit.length; j++){
//    			System.out.println("***********  j=" + j + "************");
    			if(templateUnit[j].startsWith("#") || templateUnit[j].equals("")
    					|| templateUnit[j].startsWith("B")){
    				continue;
    			}
    			Pattern pattern = Pattern.compile("%x\\[(.*?),(.*?)\\]");
    			Matcher matcher = pattern.matcher(templateUnit[j]);
    			String prefix = "";
    			String endfix = "#";
    			while(matcher.find()){
    				int rowIndex = Integer.valueOf(matcher.group(1));
    				int columnIndex = Integer.valueOf(matcher.group(2));
    				if(i+rowIndex < 0 || i+rowIndex >= sourceUnit.length || sourceUnit[i+rowIndex].equals("")){
    					prefix += columnIndex + ":nil/";
    				}else{
    					prefix += columnIndex + ":" + sourceUnit[i+rowIndex].split("\\s+")[columnIndex] + "/";
    				}
    				endfix += "/" + rowIndex;
    			}
    			destContent.append(prefix + endfix + " ");
    		}
    		destContent.append("\r\n");
    	}
    	return new Storage().saveFile(destFilePath, destContent.toString(), false);
    }
}
