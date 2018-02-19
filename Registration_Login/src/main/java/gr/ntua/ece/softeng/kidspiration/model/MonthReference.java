package gr.ntua.ece.softeng.kidspiration.model;

public class MonthReference {
    private String month;
    private int earnings;
    private int expenses;

    public MonthReference(String month, int earnings, int expenses) {
        this.month = month;
        this.earnings = earnings;
        this.expenses = expenses;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String m) {
        month=m;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int e) {
        earnings=e;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int ex) {
        expenses=ex;
    }

}





