package gr.ntua.ece.softeng.kidspiration;

public class ProviderView extends User{

    private String businessName;
    private String bankAccount;
    private double profit;
    private byte rights_code;

    public ProviderView(int id, String username, String firstname, String lastname, String email, String phone, String businessName, String bankAccount, double profit, byte rights_code) {
        super(id, username, firstname, lastname, email, phone);
        this.businessName = businessName;
        this.bankAccount = bankAccount;
        this.profit = profit;
        this.rights_code = rights_code;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public byte getRights_code() {
        return rights_code;
    }

    public void setRights_code(byte rights_code) {
        this.rights_code = rights_code;
    }
}
