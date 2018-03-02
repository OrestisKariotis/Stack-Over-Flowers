package gr.ntua.ece.softeng.kidspiration;

public class PurchasePointsInfo {
    int id;
    byte pointsCode;
    String paymentType;
    String cardNumber;
    String expireDate;
    String CRC; // int ?
    String firstName;
    String lastName;
    String address;
    String city;
    String phone;

    public PurchasePointsInfo(int id, byte pointsCode, String paymentType, String cardNumber, String expireDate, String CRC, String firstName, String lastName, String address, String city, String phone) {
        this.id = id;
        this.pointsCode = pointsCode;
        this.paymentType = paymentType;
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.CRC = CRC;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getPointsCode() {
        return pointsCode;
    }

    public void setPointsCode(byte pointsCode) {
        this.pointsCode = pointsCode;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getCRC() {
        return CRC;
    }

    public void setCRC(String CRC) {
        this.CRC = CRC;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
