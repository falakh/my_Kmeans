/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengenalan.ploa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author dbss092
 */
public class DataModel {
    
    int kelompok;
    public double minimum;
    public double[] dataSinggle;

    public DataModel(double[] dataSinggle) {
        this.dataSinggle = dataSinggle;
    }

    public static double jarak(DataModel data1,DataModel data2){
       
        double total=0;
        for(int i=0;i<data1.dataSinggle.length;i++){
            total+= Math.pow((data1.dataSinggle[i]-data2.dataSinggle[i]),2);
           
        }
//         System.out.println("Total :"+total);
       return  Math.sqrt(total);
    }
    
 
    
    
}
