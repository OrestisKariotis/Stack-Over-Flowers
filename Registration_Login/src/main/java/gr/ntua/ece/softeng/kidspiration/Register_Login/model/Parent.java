package gr.ntua.ece.softeng.kidspiration.Register_Login.model;

public class Parent {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private int phone;
    private String email;
    private int remain_points;
    private int spent_points;
    private int ban;

    public Parent(String username, String password, String firstname, String lastname, int phone, String email) {
        //this.id=??
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.remain_points = 0;
        this.spent_points = 0;
        this.ban = 1;
    }

    public int getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getRemain_points() {
        return remain_points;
    }

    public int getSpent_points() {
        return spent_points;
    }

    public int getBan() {
        return ban;
    }

    public void setRemain_points(int remain_points) {
        this.remain_points = remain_points;
    }

    public void setSpent_points(int spent_points) {
        this.spent_points = spent_points;
    }
}