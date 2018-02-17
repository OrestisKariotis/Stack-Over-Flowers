package gr.ntua.ece.softeng.kidspiration.Register_Login.model;

public class Provider {
    private int id;
    private String firstname;
    private String lastname;
    private int password;
    private String businessName;
    private int phone;
    private String email;
    private int bankNumber;
    private int inputMoney;
    private int rightsNumber;

    public Provider(int id, String firstname, String lastname, int password, String businessName, int phone, String email, int bankNumber) {
        //this.id = id; ????
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.businessName = businessName;
        this.phone = phone;
        this.email = email;
        this.bankNumber = bankNumber;
        this.inputMoney=0;
        this.rightsNumber=2;
    }
}