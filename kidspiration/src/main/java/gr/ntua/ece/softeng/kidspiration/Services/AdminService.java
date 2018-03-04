package gr.ntua.ece.softeng.kidspiration.Services;

import java.util.List;

import gr.ntua.ece.softeng.kidspiration.Administrator;
import gr.ntua.ece.softeng.kidspiration.Dao.AdminDao;
import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.Salt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AdminService")

public class AdminService {

    @Autowired
    AdminDao adminDao;

    public Administrator validateUser(Login login) {
        Administrator admin = adminDao.findByUsername(login.getUsername());
        if (admin != null) {
            Salt hash = new Salt();
            String hashedPassword = hash.hashed(login.getPassword(), admin.getSalt());
            login.setPassword(hashedPassword);
            return adminDao.validateUser(login);
        }
        return admin;
    }
}

