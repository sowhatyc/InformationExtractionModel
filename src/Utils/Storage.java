/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YangC
 */
public class Storage {
    
    public boolean saveFile(String filePath, String content, boolean isAppend){
        boolean success = true;
        try {
            FileWriter writer = new FileWriter(filePath, isAppend);
            writer.write(content);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
            success = false;
        }
        return success;
    }
    
    public String readFile(String filePath){
    	StringBuffer sb = new StringBuffer();
    	BufferedReader br = null;
    	try {
			br = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = br.readLine()) != null){
				sb.append(line);
				sb.append("\n");
			}
			br.close();
			return sb.toString();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
}
