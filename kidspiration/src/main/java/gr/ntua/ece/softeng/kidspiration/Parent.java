package gr.ntua.ece.softeng.kidspiration;

public class Parent extends User{

    private int available_points;   //could be long
    private int spent_points;       //same
    private boolean ban;

    public Parent(String username, String password, String firstname, String lastname, String email, String phone) {
        super(username, password, firstname, lastname, email, phone);
        this.available_points = 0;
        this.spent_points = 0;
        this.ban = false;
    }

    public int getAvailable_points() {
        return available_points;
    }

    public void setAvailable_points(int available_points) {
        this.available_points = available_points;
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
