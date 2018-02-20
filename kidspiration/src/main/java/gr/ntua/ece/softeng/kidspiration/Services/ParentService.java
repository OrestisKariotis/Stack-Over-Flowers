package gr.ntua.ece.softeng.kidspiration.Services;

import java.util.List;

import gr.ntua.ece.softeng.kidspiration.Dao.ParentDao;
import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ParentService")
public class ParentService implements UserService<Parent> {

    @Autowired
    //@Qualifier("ParentDao")
    ParentDao parentDao;

    public void addUser(Parent user) {
        parentDao.addUser(user);
    } //checked

    public Parent validateUser(Login login) {
        return parentDao.validateUser(login);
    } //checked

    public void editUser(Parent user, int id) {
        parentDao.editUser(user, id);
    }

    public void deleteUser(int id) {
        parentDao.deleteUser(id);
    }

    public Parent find(int id) {
        return parentDao.find(id);
    }

    public List<Parent> findAll() {
        return parentDao.findAll();
    }
}
