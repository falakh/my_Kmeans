package kmeans;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pengenalan.ploa.FileSplitter;

public class kmeans {

    static ArrayList<data> data = new ArrayList<>();
    static ArrayList<kelompok> kelompok = new ArrayList<>();
    static ArrayList<Double> f = new ArrayList<>();
    static double treshold, delta;
    static boolean ulang = true;
    static int jumlahKelompok, iterasi = 0;
    static double fLama, fBaru;

    public static void main(String[] args)  {
        String[] result = null;
        try {
            String dataSet = FileSplitter.Read("CC GENERAL.csv");
            result = dataSet.split("//n");
        } catch (IOException ex) {
            Logger.getLogger(kmeans.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=1;i<result.length;i++){
            String[] split = result[i].split(",");
            double[] pisah = new double[split.length];
            for(int j =1;j<pisah.length;j++){
                pisah[j] = Double.parseDouble(split[j]);
            }
            data.add(new data(pisah[1], pisah[2], pisah[3], pisah[4], pisah[4], pisah[5], pisah[6], pisah[7], pisah[8], pisah[9], pisah[10],pisah[11], pisah[12], pisah[13], pisah[14], pisah[15], pisah[16]));
        }
        
        System.out.println("Data"+data.size());
       
      
        setJumlahKelompok();
        setKelompokRandom(jumlahKelompok);
//        treshold = 0.1;
//        while (ulang) {
//            hitungJumlahTiapKelompok();
//            hitungTotalTiapSifatPadaTiapKelompok();
//            hitungCentroidTiapKelompok();
//            hitungJarakSifatKeCentroidTiapKelompok();
//            hitungJarakMinimumTiapData();
//            tentukanKelompokBaruTiapData();
//            tentukanJumlahNilaiMinimumSetiapSifat();
//            menghitungTreshold();
//            cetak();
        }
    

    private static void setJumlahKelompok() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan k : ");
        jumlahKelompok = scan.nextInt();
    }

    private static void setKelompokRandom(int i) {
        for (int j = 0; j < data.size(); j++) {
            data.get(j).setKelompok((int) (Math.random() * i));
        }
        for (int j = 0; j < i; j++) {
            kelompok.add(new kelompok());
        }
    }

    private static void hitungJumlahTiapKelompok() {
        int total = 1;
        for (int i = 0; i < jumlahKelompok; i++) {
            for (int j = 0; j < data.size(); j++) {
                if (data.get(j).getKelompok() == i) {
                    kelompok.get(i).setPanjang(total++);
                }
            }
            total = 1;
        }
    }

    private static void hitungTotalTiapSifatPadaTiapKelompok() {
        for (int i = 0; i < jumlahKelompok; i++) {
            double totalLatitude = 0,
                    totalLongitude = 0,
                    totalBrightness = 0,
                    totalConfidence = 0;
            for (int j = 0; j < data.size(); j++) {
                if (data.get(j).getKelompok() == i) {
                    totalLatitude += data.get(j).latitude;
                    totalLongitude += data.get(j).longitude;
                    totalBrightness += data.get(j).brightness;
                    totalConfidence += data.get(j).confidence;
                }
            }
            kelompok.get(i).setTotalLatitude(totalLatitude);
            kelompok.get(i).setTotalLongitude(totalLongitude);
            kelompok.get(i).setTotalBrightness(totalBrightness);
            kelompok.get(i).setTotalConfidence(totalConfidence);

        }
    }

    private static void hitungCentroidTiapKelompok() {
        for (int i = 0; i < jumlahKelompok; i++) {
            kelompok.get(i).setCentroidLatitude(kelompok.get(i).getTotalLatitude() / kelompok.get(i).getPanjang());
            kelompok.get(i).setCentroidLongitude(kelompok.get(i).getTotalLongitude() / kelompok.get(i).getPanjang());
            kelompok.get(i).setCentroidBrightness(kelompok.get(i).getTotalBrightness() / kelompok.get(i).getPanjang());
            kelompok.get(i).setCentroidConfidence(kelompok.get(i).getTotalConfidence() / kelompok.get(i).getPanjang());
        }
    }

    private static void hitungJarakSifatKeCentroidTiapKelompok() {
        for (int i = 0; i < data.size(); i++) {
            data.get(i).jarak.clear();
        }
        double jarak;
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < jumlahKelompok; j++) {
                jarak = Math.sqrt(Math.pow(data.get(i).latitude - kelompok.get(j).getCentroidLatitude(), 2)
                        + Math.pow(data.get(i).longitude - kelompok.get(j).getCentroidLongitude(), 2)
                        + Math.pow(data.get(i).brightness - kelompok.get(j).getCentroidBrightness(), 2)
                        + Math.pow(data.get(i).confidence - kelompok.get(j).getCentroidConfidence(), 2));
                data.get(i).jarak.add(jarak);
            }
        }
    }

    private static void hitungJarakMinimumTiapData() {
        for (int i = 0; i < data.size(); i++) {
            double min = data.get(i).jarak.get(0);
            for (int j = 0; j < jumlahKelompok; j++) {
                if (data.get(i).jarak.get(j) <= min) {
                    min = data.get(i).jarak.get(j);
                }
            }
            data.get(i).setMinimum(min);
        }
    }

    private static void tentukanKelompokBaruTiapData() {
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < jumlahKelompok; j++) {
                if (data.get(i).jarak.get(j) == data.get(i).getMinimum()) {
                    data.get(i).setKelompok(j);
                }
            }
        }
    }

    private static void tentukanJumlahNilaiMinimumSetiapSifat() {
        for (int i = 0; i < jumlahKelompok; i++) {
            double totalMin = 0;
            for (int j = 0; j < data.size(); j++) {
                if (data.get(j).getKelompok() == i) {
                    totalMin += data.get(j).getMinimum();
                }
            }
            kelompok.get(i).setTotalMinimum(totalMin);
        }
    }

    private static void menghitungF() {
        double totalMinimum = 0;
        for (int i = 0; i < jumlahKelompok; i++) {
            totalMinimum += kelompok.get(i).getTotalMinimum();
        }
        f.add(totalMinimum);
    }

    private static void menghitungTreshold() {
        menghitungF();
        fBaru = f.get(iterasi);
        if(iterasi ==0){
            fLama = 0;
        } else {
            fLama = f.get(iterasi - 1);
        }
        delta = Math.abs(fBaru - fLama);
        if (delta < treshold) {
            ulang = false;
        }
        iterasi++;
    }

    private static void cetak() {
        System.out.printf("%s\t%s\t%s\t%s\t%s\t", "No", "Lat", "Long", "Brig", "Con");
        for (int i = 0; i < jumlahKelompok; i++) {
            System.out.printf("%s%d\t", "K ",
                    i + 1);
        }
        for (int i = 0; i < jumlahKelompok; i++) {
            System.out.printf("%s%d%s\t%s%d%s\t%s%d%s\t%s%d%s\t", "K ", i + 1,
                    " Lat", "K ", i + 1, " Lon", "K ",
                    i + 1, " Bri", "K ", i + 1, " Con");
        }

        System.out.println("");

        for (int i = 0; i < data.size(); i++) {
            System.out.printf("%d\t%.3f\t%.3f\t%.1f\t%.0f\t", i + 1,
                    data.get(i).latitude, data.get(i).longitude,
                    data.get(i).brightness, data.get(i).confidence);
            for (int j = 0; j < jumlahKelompok; j++) {
                if (data.get(i).getKelompok() == j) {
                    System.out.print("X\t");
                } else {
                    System.out.print("-\t");
                }
            }
            for (int j = 0; j < jumlahKelompok; j++) {
                for (int k = 0; k < 4; k++) {
                    if (data.get(i).getKelompok() == j) {
                        System.out.printf("%.3f\t", data.get(i).latitude);
                        System.out.printf("%.3f\t", data.get(i).longitude);
                        System.out.printf("%.1f\t", data.get(i).brightness);
                        System.out.printf("%.0f\t", data.get(i).confidence);
                        break;
                    } else {
                        System.out.print(".....\t");
                    }
                }
            }
            System.out.println("");
        }
        //total
        System.out.print("Total\t\t\t\t\t");
        for (int i = 0; i < jumlahKelompok; i++) {
            System.out.printf("%d\t", kelompok.get(i).getPanjang());
        }
        for (int i = 0; i < jumlahKelompok; i++) {
            System.out.printf("%.1f\t", kelompok.get(i).getTotalLatitude());
            System.out.printf("%.1f\t", kelompok.get(i).getTotalLongitude());
            System.out.printf("%.1f\t", kelompok.get(i).getTotalBrightness());
            System.out.printf("%.0f\t", kelompok.get(i).getTotalConfidence());

        }
        System.out.println("");
        System.out.println("F Lama = " + fLama);
        System.out.println("F Baru = " + fBaru);
        System.out.println("Delta = " + delta);
    }

}
