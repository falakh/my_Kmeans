package kmeans;

import java.util.*;

public class data {


    public ArrayList<Double> jarak = new ArrayList<>();
    private int kelompok;
    private double minimum;
    public final double BALANCE,BALANCE_FREQUENCY,PURCHASES,ONEOFF_PURCHASES,INSTALLMENTS_PURCHASES,CASH_ADVANCE,PURCHASES_FREQUENCY,ONEOFF_PURCHASES_FREQUENCY,PURCHASES_INSTALLMENTS_FREQUENCY,CASH_ADVANCE_FREQUENCY,CASH_ADVANCE_TRX,PURCHASES_TRX,CREDIT_LIMIT,PAYMENTS,MINIMUM_PAYMENTS,PRC_FULL_PAYMENT,TENURE;

    public data(double BALANCE, double BALANCE_FREQUENCY, double PURCHASES, double ONEOFF_PURCHASES, double INSTALLMENTS_PURCHASES, double CASH_ADVANCE, double PURCHASES_FREQUENCY, double ONEOFF_PURCHASES_FREQUENCY, double PURCHASES_INSTALLMENTS_FREQUENCY, double CASH_ADVANCE_FREQUENCY, double CASH_ADVANCE_TRX, double PURCHASES_TRX, double CREDIT_LIMIT, double PAYMENTS, double MINIMUM_PAYMENTS, double PRC_FULL_PAYMENT, double TENURE) {
        this.BALANCE = BALANCE;
        this.BALANCE_FREQUENCY = BALANCE_FREQUENCY;
        this.PURCHASES = PURCHASES;
        this.ONEOFF_PURCHASES = ONEOFF_PURCHASES;
        this.INSTALLMENTS_PURCHASES = INSTALLMENTS_PURCHASES;
        this.CASH_ADVANCE = CASH_ADVANCE;
        this.PURCHASES_FREQUENCY = PURCHASES_FREQUENCY;
        this.ONEOFF_PURCHASES_FREQUENCY = ONEOFF_PURCHASES_FREQUENCY;
        this.PURCHASES_INSTALLMENTS_FREQUENCY = PURCHASES_INSTALLMENTS_FREQUENCY;
        this.CASH_ADVANCE_FREQUENCY = CASH_ADVANCE_FREQUENCY;
        this.CASH_ADVANCE_TRX = CASH_ADVANCE_TRX;
        this.PURCHASES_TRX = PURCHASES_TRX;
        this.CREDIT_LIMIT = CREDIT_LIMIT;
        this.PAYMENTS = PAYMENTS;
        this.MINIMUM_PAYMENTS = MINIMUM_PAYMENTS;
        this.PRC_FULL_PAYMENT = PRC_FULL_PAYMENT;
        this.TENURE = TENURE;
    }



    public int getKelompok() {
        return kelompok;
    }

    public void setKelompok(int kelompok) {
        this.kelompok = kelompok;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

}
