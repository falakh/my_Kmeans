package kmeans;

public class kelompok {

    private double centroidLatitude, centroidLongitude, centroidBrightness, centroidConfidence;
   public final double BALANCE,BALANCE_FREQUENCY,PURCHASES,ONEOFF_PURCHASES,INSTALLMENTS_PURCHASES,CASH_ADVANCE,PURCHASES_FREQUENCY,ONEOFF_PURCHASES_FREQUENCY,PURCHASES_INSTALLMENTS_FREQUENCY,CASH_ADVANCE_FREQUENCY,CASH_ADVANCE_TRX,PURCHASES_TRX,CREDIT_LIMIT,PAYMENTS,MINIMUM_PAYMENTS,PRC_FULL_PAYMENT,TENURE;

    private int panjang;
    private double totalMinimum;

    public double getCentroidLatitude() {
        return centroidLatitude;
    }

    public void setCentroidLatitude(double centroidLatitude) {
        this.centroidLatitude = centroidLatitude;
    }

    public double getCentroidLongitude() {
        return centroidLongitude;
    }

    public void setCentroidLongitude(double centroidLongitude) {
        this.centroidLongitude = centroidLongitude;
    }

    public double getCentroidBrightness() {
        return centroidBrightness;
    }

    public void setCentroidBrightness(double centroidBrightness) {
        this.centroidBrightness = centroidBrightness;
    }

    public double getCentroidConfidence() {
        return centroidConfidence;
    }

    public void setCentroidConfidence(double centroidConfidence) {
        this.centroidConfidence = centroidConfidence;
    }

    public double getTotalLatitude() {
        return totalLatitude;
    }

    public void setTotalLatitude(double totalLatitude) {
        this.totalLatitude = totalLatitude;
    }

    public double getTotalLongitude() {
        return totalLongitude;
    }

    public void setTotalLongitude(double totalLongitude) {
        this.totalLongitude = totalLongitude;
    }

    public double getTotalBrightness() {
        return totalBrightness;
    }

    public void setTotalBrightness(double totalBrightness) {
        this.totalBrightness = totalBrightness;
    }

    public double getTotalConfidence() {
        return totalConfidence;
    }

    public void setTotalConfidence(double totalConfidence) {
        this.totalConfidence = totalConfidence;
    }

    public int getPanjang() {
        return panjang;
    }

    public void setPanjang(int panjang) {
        this.panjang = panjang;
    }

    public double getTotalMinimum() {
        return totalMinimum;
    }

    public void setTotalMinimum(double minimum) {
        this.totalMinimum = minimum;
    }
    

}
