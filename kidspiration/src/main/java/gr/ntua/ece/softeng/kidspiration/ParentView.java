package gr.ntua.ece.softeng.kidspiration;

public class ParentView extends User{

    private int wallet;

    public ParentView(int id, String username, String firstname, String lastname, String email, String phone, int wallet) {
        super(id, username, firstname, lastname, email, phone);
        this.wallet = wallet;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
}
