package gr.ntua.ece.softeng.kidspiration;

public class StatsView {

    int parentNumber;
    int providerNumber;
    double profit;

    public StatsView(int parentNumber, int providerNumber, double profit) {
        this.parentNumber = parentNumber;
        this.providerNumber = providerNumber;
        this.profit = profit;
    }

    public int getParentNumber() {
        return parentNumber;
    }

    public void setParentNumber(int parentNumber) {
        this.parentNumber = parentNumber;
    }

    public int getProviderNumber() {
        return providerNumber;
    }

    public void setProviderNumber(int providerNumber) {
        this.providerNumber = providerNumber;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
