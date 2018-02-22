package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.Dao.ProviderDao;
import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("ProviderService")
public class ProviderService implements UserService<Provider> {

    @Autowired
    ProviderDao providerDao;

    public void addUser(Provider user) {
        providerDao.addUser(user);
    }

    public Provider validateUser(Login login) {
        return providerDao.validateUser(login);
    }  //checked

    public void editUser(Provider user) {
        providerDao.editUser(user);
    }

    public void deleteUser(int id) {
        providerDao.deleteUser(id);
    }

    public Provider find(int id) {
        return providerDao.find(id);
    }

    public List<Provider> findAll() {
        return providerDao.findAll();
    }
}