package gr.ntua.ece.softeng.kidspiration;

public class MonthReference {
    private int month;
    private int earnings;
    private double expenses;
    private double profit;

    public MonthReference(int month, int earnings, double expenses, double profit) {
        this.month = month;
        this.earnings = earnings;
        this.expenses = expenses;
        this.profit = profit;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) { this.profit = profit;
    }

}
