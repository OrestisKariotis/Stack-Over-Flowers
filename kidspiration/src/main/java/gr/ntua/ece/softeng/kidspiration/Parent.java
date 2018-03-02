package gr.ntua.ece.softeng.kidspiration;

public class Parent extends ParentView{

    private String password;
    private int spent_points;
    private boolean ban;

    public Parent(int id, String username, String password, String firstname, String lastname, String email, String phone, int wallet, int spent_points, boolean ban) {
        super(id, username, firstname, lastname, email, phone, wallet);
        this.password = password;
        this.spent_points = spent_points;
        this.ban = ban;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
