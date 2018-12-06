/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengenalan.ploa;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Mac;

/**
 *
 * @author dbss092
 */
public class PengenalanPloa {

    static ArrayList<DataModel> model = new ArrayList<>();
    static ArrayList<Cluster> kelompok = new ArrayList<>();
    private static int jumlahKelompok;
    private static Boolean isComplete = false;
    private static double FOld=0;
    private static double delta = Double.MAX_VALUE;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String data = null;

        K_Means k_means = new K_Means();
        try {
            // TODO code application logic here
            data = FileSplitter.Read("CC GENERAL.csv");
        } catch (IOException ex) {
            Logger.getLogger(PengenalanPloa.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] split = data.split("\n");

        String[] listColumn = split[0].split(",");
        double[][] newDataSet = new double[split.length][listColumn.length];
        for (int i = 1; i < split.length; i++) {
            String[] row = split[i].split(",");
            for (int j = 1; j < row.length; j++) {
                double isi = 0;
                try {
                    newDataSet[i - 1][j - 1] = Double.parseDouble(row[j]);
                } catch (NumberFormatException num) {
                    newDataSet[i][j] = 0;
                }
            }
            model.add(new DataModel(newDataSet[i]));
        }
//        F = setF();
        setKelompok();
        setKelompokRandom(jumlahKelompok);
        setCluster();
        tampilkan();
        setF();
        FOld = setF();
        int loop = 0;
        while ((delta)> 0) {
            FOld = setF();
            resetCluster();
            setCluster();
            delta = Math.abs((setF()-FOld))  ;
            FOld = setF();
        }
        tampilkan();
    }
    
    public static double setF(){
        double total=0;
        for(int i=0;i<model.size();i++){
            total+=model.get(i).minimum;
        }
        return total;
    }

    public static void resetCluster() {
        for (Cluster c : kelompok) {
            c.reset();
        }
    }

    public static void setKelompok() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan k : ");
        jumlahKelompok = scan.nextInt();
    }

    public static void setKelompokRandom(int i) {
        for (int j = 0; j < i; j++) {

            Cluster cluster = new Cluster(model.get(j));
            kelompok.add(cluster);
        }
    }

    public static void setCluster() {
        isComplete = true;
        for (int i = 0; i < model.size(); i++) {
            double jarak = Integer.MAX_VALUE;
            int currentIndex = 0;
            for (int j = 0; j < kelompok.size(); j++) {

                double jarakModel = DataModel.jarak(model.get(i), kelompok.get(j).center);
                if (jarak > jarakModel) {
                    jarak = jarakModel;
                    model.get(i).minimum=jarak;
                    currentIndex = j;
                }
            }
//            if (model.get(i).kelompok != currentIndex) {
//                isComplete = false;
//            }
            model.get(i).kelompok = currentIndex;
            kelompok.get(currentIndex).member.add(model.get(i));
        }
    }

    static void tampilkan() {
        System.out.println("--------------------------");
        System.out.println("Nomor\t\tKelompok  ");
        for (int i = 0; i < model.size(); i++) {
            System.out.print(i +"\t\t");
            System.out.print( model.get(i).kelompok);
            System.out.println("");
        }
        System.out.println("--------------------------");
        System.out.println("");
    }

}
