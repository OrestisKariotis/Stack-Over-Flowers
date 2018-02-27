package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.Dao.PendingProviderDao;
import gr.ntua.ece.softeng.kidspiration.Dao.UserDao;
import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.PendingProvider;
import gr.ntua.ece.softeng.kidspiration.PendingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("PendingProviderService")
public class PendingProviderService implements UserService<PendingProvider> {

    @Autowired
    PendingProviderDao pendingProviderDao;

    public void addUser(PendingProvider user) {
        pendingProviderDao.addUser(user);
    }  // checked

    public PendingProvider validateUser(Login login) {
        return null;
    }  // WILL BE REMOVED

    public void editUser(PendingProvider user, int id) {
        //pendingProviderDao.editUser(user, id);
    }

    public void deleteUser(int id) { // checked
        pendingProviderDao.deleteUser(id);
    }

    public PendingProvider find(int id) { //checked
        return pendingProviderDao.find(id);
    }

    public List<PendingProvider> findAll() { //checked
        return pendingProviderDao.findAll();
    }
}
