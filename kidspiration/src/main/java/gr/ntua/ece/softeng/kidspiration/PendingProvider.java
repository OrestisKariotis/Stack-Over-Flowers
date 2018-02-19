package gr.ntua.ece.softeng.kidspiration;

public class PendingProvider extends User{

    private String businessName;
    private String bankAccount;

    public PendingProvider(String username, String password, String firstname, String lastname, String email, String phone, String businessName, String bankAccount) {
        super(username, password, firstname, lastname, email, phone);
        this.businessName = businessName;
        this.bankAccount = bankAccount;
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
}
