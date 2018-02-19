package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.Dao.PendingProviderDao;
import gr.ntua.ece.softeng.kidspiration.Dao.UserDao;
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
    //@Qualifier("PendingProviderDao")
    PendingProviderDao pendingProviderDao;

    public void addUser(PendingProvider user) {
        pendingProviderDao.addUser(user);
    }

    public void editUser(PendingProvider user, int id) {
        pendingProviderDao.editUser(user, id);
    }

    public void deleteUser(int id) {
        pendingProviderDao.deleteUser(id);
    }

    public PendingProvider find(int id) {
        return pendingProviderDao.find(id);
    }

    public List<PendingProvider> findAll() {
        return pendingProviderDao.findAll();
    }
}
