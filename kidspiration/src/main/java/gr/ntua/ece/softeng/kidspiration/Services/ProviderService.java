package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.*;
import gr.ntua.ece.softeng.kidspiration.Dao.ProviderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import gr.ntua.ece.softeng.kidspiration.Dao.MonthProviderReferenceDao;

import java.io.IOException;
import java.util.List;

@Service
@Qualifier("ProviderService")
public class ProviderService { //implements UserService<Provider> {

    @Autowired
    ProviderDao providerDao;

    @Autowired
    MonthProviderReferenceDao monthProviderReferenceDao;

    public void addUser(Provider user) {
        providerDao.addUser(user);
        user = providerDao.findByUsername(user.getUsername());
        MonthProviderReference monthProviderReference=new MonthProviderReference(0, user.getId(), 0, 0, 0, 0, 0 , 0, 0, 0, 0, 0, 0, 0);
        monthProviderReferenceDao.addMonthProviderReference(monthProviderReference);
    }  // OK

    public Provider validateUser(Login login) {
        Provider provider = providerDao.findByUsername(login.getUsername());
        if (provider != null) {
            Salt hash = new Salt();
            String hashedPassword = hash.hashed(login.getPassword(), provider.getSalt());
            login.setPassword(hashedPassword);
            return providerDao.validateUser(login);
        }
        return provider;
    }  // OK

    public void editUser(Provider user, int id) { // checking
        providerDao.editUser(user, id);  // Provider object already formed in controller
        // for that reason, editUser WILL change
    }

    public void editInfo(int id, String firstname, String lastname, String phone, String bankAccount) {
        providerDao.editInfo(id, firstname, lastname, phone, bankAccount);
    }

    public Provider changeRights(int id, byte rights_code) {   // OK
        Provider provider = providerDao.find(id);   //could be done by better way, only one query
        provider.setRights_code(rights_code);
        providerDao.editUser(provider, id);
        return provider;
    }

    public void deleteUser(int id) { //checked
        providerDao.deleteUser(id);
    } // OK

    public Provider find(int id) {  // checking
        return providerDao.find(id);
    }  // OK

    public ProviderView findView(int id) { // OK
        Provider provider =  providerDao.find(id);
        ProviderView providerView = new ProviderView(provider.getId(), provider.getUsername(), provider.getFirstname(), provider.getLastname(), provider.getEmail(), provider.getPhone(), provider.getBusinessName(), provider.getBankAccount(), provider.getRights_code(), provider.getRights_code());
        return providerView;
    }

    public List<Provider> findAll() {  //checked
        return providerDao.findAll();
    } // OK

    public void addHashedUser(String username) throws IOException {

        SendResetEmail emailer = new SendResetEmail();

        String pseudopass = new StringGenerator().randomgeneratedstring();
        String salt = new StringGenerator().randomgeneratedstring();
        Salt hash = new Salt();
        String hashedString = hash.hashed(pseudopass, salt);

        Provider provider = providerDao.findByUsername(username);

        providerDao.addHashedUser(provider.getId(), provider.getUsername(), provider.getEmail(), hashedString, salt);

        emailer.sendresetEmail(pseudopass,salt,provider.getEmail());  //APOSTOLH EMAIL
    }

    public boolean resetPassword(String pseudoPassword, String salt, String newPassword) {
        Salt hash = new Salt();
        String hashedString = hash.hashed(pseudoPassword, salt);
        ResetUser user = providerDao.findByHashedString(hashedString);
        if(user != null) {
            Provider provider = providerDao.find(user.getId());
            String salt1 = provider.getSalt();
            String new_password = hash.hashed(newPassword, salt1);
            providerDao.editPassword(user.getId(), new_password);
            return true;
        }
        else
            return false;
    }
}
