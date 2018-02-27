package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.ProviderView;
import gr.ntua.ece.softeng.kidspiration.Dao.ProviderDao;
import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("ProviderService")
public class ProviderService implements UserService<Provider> {

    @Autowired
    ProviderDao providerDao;

    public void addUser(Provider user) {
        providerDao.addUser(user);
    }  // checked

    public Provider validateUser(Login login) {
        return providerDao.validateUser(login);
    }  //checked

    public void editUser(Provider user, int id) { // checking
        providerDao.editUser(user, id);  // Provider object already formed in controller
        // for that reason, editUser WILL change
    }

    public Provider changeRights(int id, byte rights_code) {   //checked
        Provider provider = providerDao.find(id);   //could be done by better way, only one query
        provider.setRights_code(rights_code);
        providerDao.editUser(provider, id);
        return provider;
    }

    public void deleteUser(int id) { //checked
        providerDao.deleteUser(id);
    }

    public Provider find(int id) {  // checking
        return providerDao.find(id);
    }

    public ProviderView findView(int id) { // checking
        Provider provider =  providerDao.find(id);
        ProviderView providerView = new ProviderView(provider.getFirstname(), provider.getLastname(), provider.getEmail(), provider.getPhone(), provider.getBusinessName());
        return providerView;
    }

    public List<Provider> findAll() {  //checked
        return providerDao.findAll();
    }
}
