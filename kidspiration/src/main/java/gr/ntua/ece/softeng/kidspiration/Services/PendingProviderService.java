package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.*;
import gr.ntua.ece.softeng.kidspiration.Dao.PendingProviderDao;
import gr.ntua.ece.softeng.kidspiration.Dao.ProviderDao;
import gr.ntua.ece.softeng.kidspiration.Dao.UserDao;
import gr.ntua.ece.softeng.kidspiration.PendingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("PendingProviderService")
public class PendingProviderService { //implements UserService<PendingProvider> {

    @Autowired
    PendingProviderDao pendingProviderDao;

    @Autowired
    ProviderDao providerDao;

    public PendingProvider addUser(PendingProvider user) { // OK

        PendingProvider provider = new PendingProvider();

        if ((pendingProviderDao.findByUsername(user.getUsername()) != null) || (providerDao.findByUsername(user.getUsername()) != null))
            provider.setId(1000);
        else if ((pendingProviderDao.findByEmail(user.getEmail()) != null) || (providerDao.findByEmail(user.getEmail()) != null))
            provider.setId(2000);
        else {
            String salt = new StringGenerator().randomgeneratedstring();
            Salt hash = new Salt();
            String hasedPassword = hash.hashed(user.getPassword(), salt);
            user.setPassword(hasedPassword);
            user.setSalt(salt);
            pendingProviderDao.addUser(user);
            provider = pendingProviderDao.findByUsername(user.getUsername());
        }
        return provider;
    }

    public PendingProvider validateUser(Login login) {
        return null;
    }  // WILL BE REMOVED

    public void editUser(PendingProvider user, int id) {
        //pendingProviderDao.editUser(user, id);
    }

    public void deleteUser(int id) { // checked
        pendingProviderDao.deleteUser(id);
    } // OK

    public PendingProvider find(int id) { //checked
        return pendingProviderDao.find(id);
    } // OK

    public List<PendingProvider> findAll() { //checked
        return pendingProviderDao.findAll();
    }  // OK

}
