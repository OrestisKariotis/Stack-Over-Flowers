package gr.ntua.ece.softeng.kidspiration;

public class Provider extends PendingProvider {

    private int profit; //could be long, mhpws einai esoda?
    private char rights_code;

    public Provider(String username, String password, String firstname, String lastname, String email, String phone, String businessName, String bankAccount) {
        super(username, password, firstname, lastname, email, phone, businessName, bankAccount);
        this.profit = 0;
        this.rights_code = 0; //depends on the way we see it
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public char getRights_code() {
        return rights_code;
    }

    public void setRights_code(char rights_code) {
        this.rights_code = rights_code;
    }
}
