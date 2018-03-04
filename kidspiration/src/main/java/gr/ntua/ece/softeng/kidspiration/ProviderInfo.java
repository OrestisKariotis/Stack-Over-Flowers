package gr.ntua.ece.softeng.kidspiration;

public class ProviderInfo {
    String firstname;
    String lastname;
    String phone;
    String bankAccount;

    public ProviderInfo(String firstname, String lastname, String phone, String bankAccount) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.bankAccount = bankAccount;
    }

    public ProviderInfo() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
}
