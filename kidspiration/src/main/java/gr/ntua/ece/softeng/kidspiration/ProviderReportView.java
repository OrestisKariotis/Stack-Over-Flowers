package gr.ntua.ece.softeng.kidspiration;

public class ProviderReportView {
    double totalProfit;
    double monthProfit;

    public ProviderReportView(double totalProfit, double monthProfit) {
        this.totalProfit = totalProfit;
        this.monthProfit = monthProfit;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public double getMonthProfit() {
        return monthProfit;
    }

    public void setMonthProfit(double monthProfit) {
        this.monthProfit = monthProfit;
    }
}
