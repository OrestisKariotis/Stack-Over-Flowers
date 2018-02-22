package gr.ntua.ece.softeng.kidspiration;

public class Parent extends User{

    private int wallet;   //could be long
    private int spent_points;       //same
    private boolean ban;

    public Parent(int id, String username, String password, String firstname, String lastname, String email, String phone, int wallet, int spent_points, boolean ban) {
        super(id, username, password, firstname, lastname, email, phone);
        this.wallet = wallet;
        this.spent_points = spent_points;
        this.ban = ban;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public int getSpent_points() {
        return spent_points;
    }

    public void setSpent_points(int spent_points) {
        this.spent_points = spent_points;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }
}

