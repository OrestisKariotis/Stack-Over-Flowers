package gr.ntua.ece.softeng.kidspiration;

public class ResetUser {

    private int key;
    private int id;
    private String username;
    private String email;
    private String hashedString;
    private String salt;

    public ResetUser(int key, int id, String username, String email, String hashedString, String salt) {
        this.key = key;
        this.id = id;
        this.username = username;
        this.email = email;
        this.hashedString = hashedString;
        this.salt = salt;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedString() {
        return hashedString;
    }

    public void setHashedString(String hashedString) {
        this.hashedString = hashedString;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
