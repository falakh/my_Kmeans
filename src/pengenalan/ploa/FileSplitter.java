/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengenalan.ploa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dbss092
 */
public class FileSplitter {
    
    public static String Read(String fileName) throws IOException{
        String path = System.getProperty("user.dir");
        String filepath  = (path+"\\"+fileName);
        String result="";
        try {
            FileReader fr = new java.io.FileReader(fileName);
           int i; 
    while ((i=fr.read()) != -1) {
         result+=((char) i); 
    }
     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSplitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
