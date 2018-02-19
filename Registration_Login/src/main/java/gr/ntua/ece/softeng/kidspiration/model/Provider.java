package gr.ntua.ece.softeng.kidspiration.model;

public class Provider {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private int password;
    private String businessName;
    private int phone;
    private String email;
    private int bankNumber;
    private int inputMoney;
    private int rightsNumber;

    public Provider(String firstname, String lastname, String username, int password, String businessName, int phone, String email, int bankNumber) {
        //this.id = id; ????
        this.firstname = firstname;
        this.lastname = lastname;
        this.username=username;
        this.password = password;
        this.businessName = businessName;
        this.phone = phone;
        this.email = email;
        this.bankNumber = bankNumber;
        this.inputMoney=0;
        this.rightsNumber=2;
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public int getRightsNumber() {
        return rightsNumber;
    }

    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
    }

    public void setInputMoney(int inputMoney) {
        this.inputMoney = inputMoney;
    }

    public void setRightsNumber(int rightsNumber) {
        this.rightsNumber = rightsNumber;
    }
}