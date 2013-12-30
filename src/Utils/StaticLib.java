/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author YangC
 */
public class StaticLib {
    
    public static Set<String> tagSet = null;
    
    public static String extractorRulesPath = "extractorRulesCpy.xml";
    
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
    
}
