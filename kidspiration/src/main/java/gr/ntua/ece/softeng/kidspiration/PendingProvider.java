package gr.ntua.ece.softeng.kidspiration;

public class PendingProvider extends User{

    private String password;
    private String businessName;
    private String bankAccount;
    private String salt;

    public PendingProvider(int id, String username, String password, String firstname, String lastname, String email, String phone, String businessName, String bankAccount, String salt) {
        super(id, username, firstname, lastname, email, phone);
        this.password = password;
        this.businessName = businessName;
        this.bankAccount = bankAccount;
        this.salt = salt;
    }

    public PendingProvider() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
