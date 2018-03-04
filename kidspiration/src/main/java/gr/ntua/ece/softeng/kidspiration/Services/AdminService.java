package gr.ntua.ece.softeng.kidspiration.Services;

import java.util.List;

import gr.ntua.ece.softeng.kidspiration.Administrator;
import gr.ntua.ece.softeng.kidspiration.Dao.AdminDao;
import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AdminService")

public class AdminService {

    @Autowired
    AdminDao adminDao;

    public Administrator validateUser(Login login) {
        return adminDao.validateUser(login);
    }
}

