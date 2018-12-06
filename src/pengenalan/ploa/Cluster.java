/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengenalan.ploa;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author dbss092
 */
public class Cluster {

    public DataModel center;
    public int panjang;

    public ArrayList<DataModel> member = new ArrayList<DataModel>();

    public Cluster(DataModel center) {
        this.center = center;
        this.member = member;
    }

    public void reset() {
        double[] newCenter = new double[member.get(0).dataSinggle.length];
        double rata_rata, total;
        for (int i = 0; i < member.get(0).dataSinggle.length; i++) {
            total = 0;
            for (int j = 0; j < member.size(); j++) {
                total+=member.get(j).dataSinggle[i];
            }
            newCenter[i] = total/member.size();
        }
        member = new ArrayList<>();
        center = new DataModel(newCenter);
    }

}
