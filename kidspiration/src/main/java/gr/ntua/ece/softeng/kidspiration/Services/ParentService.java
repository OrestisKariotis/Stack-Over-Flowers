package gr.ntua.ece.softeng.kidspiration.Services;

import java.io.IOException;
import java.util.List;

import gr.ntua.ece.softeng.kidspiration.*;
import gr.ntua.ece.softeng.kidspiration.Dao.ParentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ParentService")
public class ParentService implements UserService<Parent> {

    @Autowired
    //@Qualifier("ParentDao")
    ParentDao parentDao;

    public Parent addUser(Parent user) {  //CHECKING

        Parent parent = new Parent();
        if (parentDao.findByUsername(user.getUsername()) != null)
            parent.setSpent_points(1);
        else if (parentDao.findByEmail(user.getEmail()) != null)
            parent.setSpent_points(2);
        else {
            String salt = new StringGenerator().randomgeneratedstring();
            Salt hash = new Salt();
            String hasedPassword = hash.hashed(user.getPassword(), salt);
            user.setPassword(hasedPassword);
            user.setSalt(salt);
            parentDao.addUser(user);
            parent = parentDao.findByUsername(user.getUsername());
        }
        return parent;
    }

    public Parent validateUser(Login login) {
        Parent parent = parentDao.findByUsername(login.getUsername());
        if (parent != null) {
            Salt hash = new Salt();
            String hashedPassword = hash.hashed(login.getPassword(), parent.getSalt());
            login.setPassword(hashedPassword);
            return parentDao.validateUser(login);
        }
        return parent;
    } // OK

    public Parent decreasePoints(Parent parent, int points) {    //OK //check if parent should be searched here

        System.out.println("Entering parent's points decreasing service");
        int wallet = parent.getWallet();
        int spent_points = parent.getSpent_points();
        parent.setWallet(wallet - points); //not needed
        parent.setSpent_points(spent_points + points);  // Bonus will be checked later //not needed
        if (parent.getSpent_points() < 30000)
            parentDao.updatePoints(parent.getId(),wallet - points, spent_points + points);
        else {  // BONUS
            //EMAIL NOTIFICATION
            SendResetEmail sendResetEmail = new SendResetEmail();
            sendResetEmail.sendSimpleMail(parent.getEmail(), "Συγχαρητήρια " + parent.getUsername()+"!\nΚερδίσατε 1000 πόντους για αγορές στην πλατφόρμα μας, αφού συμπληρώσατε αγορές 30000 πόντων!");
            parent.setWallet(wallet - points + 1000);
            parent.setWallet(spent_points + points - 30000);
            parentDao.updatePoints(parent.getId(), wallet - points + 1000, spent_points + points - 30000);
        }
        System.out.println("Leaving parent's points decreasing service");
        return parent;
    }

    public Parent purchasePoints(Parent parent, PurchasePointsInfo info) { // OK

        int wallet = parent.getWallet();

        if (info.getPointsCode() == 1)
            parent.setWallet(wallet + 500);
        else if (info.getPointsCode() == 2)
            parent.setWallet(wallet + 1025);
        else if (info.getPointsCode() == 3)
            parent.setWallet(wallet + 2100);
        else if (info.getPointsCode() == 4)
            parent.setWallet(wallet + 5300);
        else
            return null;
        // else error
        parentDao.updatePoints(parent.getId(), parent.getWallet(), parent.getSpent_points());
        return parent;
    }

    public Parent changeRights(int id, boolean ban) {   // OK
        Parent parent = parentDao.find(id);   //could be done by better way, only one query
        parent.setBan(ban);
        parentDao.editUser(parent, id);
        return parent;
    }

    public void editInfo(int id, String phone) {
        parentDao.editInfo(id, phone);
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

    public void addHashedUser(String username) throws IOException {

        SendResetEmail emailer = new SendResetEmail();

        String pseudopass = new StringGenerator().randomgeneratedstring();
        String salt = new StringGenerator().randomgeneratedstring();
        Salt hash = new Salt();
        String hashedString = hash.hashed(pseudopass, salt);

        Parent parent = parentDao.findByUsername(username);

        parentDao.addHashedUser(parent.getId(), parent.getUsername(), parent.getEmail(), hashedString, salt);

        emailer.sendresetEmail(pseudopass,salt,parent.getEmail());  //APOSTOLH EMAIL
    }

    public boolean resetPassword(String pseudoPassword, String salt, String newPassword) {
        Salt hash = new Salt();
        String hashedString = hash.hashed(pseudoPassword, salt);
        ResetUser user = parentDao.findByHashedString(hashedString);
        if(user != null) {
            Parent parent = parentDao.find(user.getId());
            String salt1 = parent.getSalt();
            String new_password = hash.hashed(newPassword, salt1);
            parentDao.editPassword(user.getId(), new_password);
            return true;
        }
        else
            return false;
    }
}
