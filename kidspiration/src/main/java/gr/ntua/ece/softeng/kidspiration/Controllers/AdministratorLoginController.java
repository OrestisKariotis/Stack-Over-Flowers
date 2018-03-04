package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.*;
import gr.ntua.ece.softeng.kidspiration.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AdministratorLoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/api/path_known_to_admins/login", method = RequestMethod.POST)
    public ResponseEntity<?> Admin_login(@RequestBody Login login) {
        //Login login;
        //login = new Login(username, password);
        Administrator admin = adminService.validateUser(login);
        if (admin == null) {
            return ResponseEntity.badRequest().body("Invalid username or password");
        } else {
            return ResponseEntity.accepted().body(admin.getId());
        }
    }
}
