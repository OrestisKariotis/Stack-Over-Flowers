package gr.ntua.ece.softeng.kidspiration.Services;

import java.util.List;

import gr.ntua.ece.softeng.kidspiration.Dao.ParentDao;
import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import gr.ntua.ece.softeng.kidspiration.Dao.UserDao;

@Service
@Qualifier("ParentService")
public class ParentService implements UserService<Parent> {

    @Autowired
    //@Qualifier("ParentDao")
    ParentDao parentDao;

    public void addUser(Parent user) {
        parentDao.addUser(user);
    }

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
