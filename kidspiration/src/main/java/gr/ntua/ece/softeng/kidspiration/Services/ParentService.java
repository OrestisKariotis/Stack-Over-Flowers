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
    } // OK

    public Parent validateUser(Login login) {
        return parentDao.validateUser(login);
    } // OK

    public void decreasePoints(Parent parent, int points) {    //OK //check if parent should be searched here

        System.out.println("Entering parent's points decreasing service");
        int wallet = parent.getWallet();
        int spent_points = parent.getSpent_points();
        parent.setWallet(wallet - points); //not needed
        parent.setSpent_points(spent_points + points);  // Bonus will be checked later //not needed
        parentDao.updatePoints(parent.getId(),wallet - points, spent_points + points);
        //parentDao.editUser(parent, parent.getId());
        System.out.println("Leaving parent's points decreasing service");

        // getId can be omitted as mentioned in Parent Dao
    }

    public Parent purchasePoints(Parent parent, byte points_package_code) { // OK

        int wallet = parent.getWallet();

        if (points_package_code == 1)
            parent.setWallet(wallet + 500);
        else if (points_package_code == 2)
            parent.setWallet(wallet + 1025);
        else if (points_package_code == 3)
            parent.setWallet(wallet + 2100);
        else if (points_package_code == 4)
            parent.setWallet(wallet + 5300);
        // else error
        parentDao.editUser(parent, parent.getId());   // id could be omitted //USE updatePoints Dao method!!!
        return parent;
    }

    public Parent changeRights(int id, boolean ban) {   // OK
        Parent parent = parentDao.find(id);   //could be done by better way, only one query
        parent.setBan(ban);
        parentDao.editUser(parent, id);
        return parent;
    }

    public void editUser(Parent user, int id) { //checked
        parentDao.editUser(user, id);  // Parent object already formed in controller
        // for that reason, editUser WILL change
    }

    public void deleteUser(int id) {  //checked
        parentDao.deleteUser(id);
    } // OK

    public Parent find(int id) {   //checked
        return parentDao.find(id);
    }  // OK

    public List<Parent> findAll() {  //checked
        return parentDao.findAll();
    } // OK
}
