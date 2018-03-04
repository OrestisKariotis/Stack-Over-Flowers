package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.*;
import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.Services.ParentService;
import gr.ntua.ece.softeng.kidspiration.Services.ProviderService;
import gr.ntua.ece.softeng.kidspiration.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(path = "/api/login", method = RequestMethod.POST)  //could be POST method
public class LoginController {

    @Autowired
    //@Qualifier("ParentService")
    //private UserService parent_service;
    private ParentService parentService;

    @Autowired
    //@Qualifier("ProviderService")
    //private UserService provider_service;
    ProviderService providerService;

    @RequestMapping(value = "/parent", method = RequestMethod.POST)  // POST method
    public ResponseEntity<?> Parent_login(@RequestBody Login login) {  // OK
    // @RequestBody Login
        //Login login;
        //login = new Login(username, password);
        Parent parent = parentService.validateUser(login);

        if (parent == null)
            return ResponseEntity.badRequest().body("Invalid username or password");
        else if (parent.isBan())
            return ResponseEntity.badRequest().body("Banned");
        else {
            ParentView parentView = new ParentView(parent.getId(), parent.getUsername(), parent.getFirstname(), parent.getLastname(), parent.getEmail(), parent.getPhone(), parent.getWallet());
            return ResponseEntity.accepted().body(parentView);
        }
    }

    @RequestMapping(value = "/provider", method = RequestMethod.POST)  // POST method
    public ResponseEntity<?> Provider_login(@RequestBody Login login) {//@RequestParam String username, @RequestParam String password) {   // OK

        //Login login
        //login = new Login(username, password);
        Provider provider = providerService.validateUser(login);

        if (provider == null)
            return ResponseEntity.badRequest().body("Invalid username or password");
        else if (provider.getRights_code() == 2)
            return ResponseEntity.badRequest().body("Banned");
        else {
            ProviderView providerView = new ProviderView(provider.getId(), provider.getUsername(), provider.getFirstname(), provider.getLastname(), provider.getEmail(), provider.getPhone(), provider.getBusinessName(), provider.getBankAccount(), provider.getProfit(), provider.getRights_code());
            return ResponseEntity.accepted().body(providerView);
        }
    }

}