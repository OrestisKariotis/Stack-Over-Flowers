package gr.ntua.ece.softeng.kidspiration.Register_Login.dao;
import gr.ntua.ece.softeng.kidspiration.Register_Login.model.Login;
import gr.ntua.ece.softeng.kidspiration.Register_Login.model.Parent;

public interface ParentDao {
    void register(Parent parent)
    Parent validateParent(Login login);
}
