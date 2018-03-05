package gr.ntua.ece.softeng.kidspiration;

public class ResetPassword {
    private String pseudoPassword;
    private String salt;
    private String newPassword;

    public ResetPassword(String pseudoPassword, String salt, String newPassword) {
        this.pseudoPassword = pseudoPassword;
        this.salt = salt;
        this.newPassword = newPassword;
    }

    public ResetPassword() {

    }

    public String getPseudoPassword() {
        return pseudoPassword;
    }

    public void setPseudoPassword(String pseudoPassword) {
        this.pseudoPassword = pseudoPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
