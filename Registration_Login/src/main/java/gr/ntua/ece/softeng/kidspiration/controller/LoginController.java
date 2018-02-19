package gr.ntua.ece.softeng.kidspiration.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import gr.ntua.ece.softeng.kidspiration.model.Login;
import gr.ntua.ece.softeng.kidspiration.dao.ParentDaoImpl;
import gr.ntua.ece.softeng.kidspiration.dao.ProviderDaoImpl;

@RestController
public class LoginController {
    ParentDaoImpl checkParent;
    ProviderDaoImpl checkProvider;

    @RequestMapping("/loginParent")
    public Parent(@RequestParam String Username, @RequestParam String Password) {
        Login login= new Login(Username, Password);
        //search if there is a parent with this username and password
        //ti epistrefw?
    }

    @RequestMapping("/loginProvider")
    public Provider (@RequestParam String Username, @RequestParam String Password) {
        Login login = new Login(Username, Password);
        //search if there is a provider with this username and password AND check if he is ban!!!!!!!1
        //ti epistrefw??
    }
}
