package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.ProviderView;
import gr.ntua.ece.softeng.kidspiration.Dao.ProviderDao;
import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import gr.ntua.ece.softeng.kidspiration.Dao.MonthProviderReferenceDao;
import gr.ntua.ece.softeng.kidspiration.MonthProviderReference;

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
        MonthProviderReference monthProviderReference=new MonthProviderReference(0, user.getId(), 0, 0, 0, 0, 0 , 0, 0, 0, 0, 0, 0, 0);
        monthProviderReferenceDao.addMonthProviderReference(monthProviderReference);
    }  // OK

    public Provider validateUser(Login login) {
        return providerDao.validateUser(login);
    }  // OK

    public void editUser(Provider user, int id) { // checking
        providerDao.editUser(user, id);  // Provider object already formed in controller
        // for that reason, editUser WILL change
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
}
