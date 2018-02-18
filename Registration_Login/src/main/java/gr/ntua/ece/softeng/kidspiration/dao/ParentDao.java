package gr.ntua.ece.softeng.kidspiration.dao;
import gr.ntua.ece.softeng.kidspiration.model.Login;
import gr.ntua.ece.softeng.kidspiration.model.Parent;

public interface ParentDao {
    void register(Parent parent)
    Parent validateParent(Login login);
}
