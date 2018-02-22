package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.Provider;
import gr.ntua.ece.softeng.kidspiration.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/login", method = RequestMethod.GET)  //could be POST method
public class LoginController {

    @Autowired
    @Qualifier("ParentService")
    private UserService parent_service;

    @Autowired
    @Qualifier("ProviderService")
    private UserService provider_service;

    @RequestMapping(value = "/parent", method = RequestMethod.GET)  // Could be POST method
    public Parent Parent_login(@RequestParam String username, @RequestParam String password) {

        Login login;
        login = new Login(username, password);
        Parent parent = (Parent) parent_service.validateUser(login);
        /*if (null != parent)
            return "Requested parent is in database with id = " + parent.getId();  //return value will be changed
        else
            return "There is no such parent in database"; //perhaps a null parent
        */
        return parent;
    }

    @RequestMapping(value = "/provider", method = RequestMethod.GET)  // Could be POST method
    public Provider Provider_login(@RequestParam String username, @RequestParam String password) {

        Login login;
        login = new Login(username, password);
        Provider provider = (Provider) provider_service.validateUser(login);
        return provider;
    }

}
