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

    public void decreasePoints(Parent parent, int points) {
        System.out.println("Entering parent's points decreasing service");
        int wallet = parent.getWallet();
        int spent_points = parent.getSpent_points();
        parent.setWallet(wallet - points);
        parent.setSpent_points(spent_points + points);  // Bonus will be checked later
        parentDao.editUser(parent, parent.getId());

        System.out.println("Leaving parent's points decreasing service");

        // getId can be omitted as mentned in Parent Dao
    }

    public void editUser(Parent user, int id) {
        //parentDao.editUser(user, id);
    }

    public void deleteUser(int id) {
        //parentDao.deleteUser(id);
    }

    public Parent find(int id) {
        return null;
        //return parentDao.find(id);
    }

    public List<Parent> findAll() {
        return null;
        // return parentDao.findAll();
    }
}
