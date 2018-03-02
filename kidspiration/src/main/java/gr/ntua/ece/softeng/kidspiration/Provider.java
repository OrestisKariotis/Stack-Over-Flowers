package gr.ntua.ece.softeng.kidspiration;

public class Provider extends PendingProvider {

    private double profit; //could be long, mhpws einai esoda?
    private byte rights_code;

    public Provider(int id, String username, String password, String firstname, String lastname, String email, String phone, String businessName, String bankAccount, double profit, byte rights_code) {
        super(id, username, password, firstname, lastname, email, phone, businessName, bankAccount);
        this.profit = profit;
        this.rights_code = rights_code;
    }

    public Provider() {

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
