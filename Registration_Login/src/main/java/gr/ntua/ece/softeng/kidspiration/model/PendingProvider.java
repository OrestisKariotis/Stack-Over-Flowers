package gr.ntua.ece.softeng.kidspiration.model;

public class PendingProvider {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private int password;
    private String businessName;
    private int phone;
    private String email;
    private int bankNumber;

    public PendingProvider(int id, String firstname, String lastname, String username, int password, String businessName, int phone, String email, int bankNumber) {
        //this.id = id; ????
        this.firstname = firstname;
        this.lastname = lastname;
        this.username=username;
        this.password = password;
        this.businessName = businessName;
        this.phone = phone;
        this.email = email;
        this.bankNumber = bankNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }

    public String getBusinessName() {
        return businessName;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getBankNumber() {
        return bankNumber;
    }
}
