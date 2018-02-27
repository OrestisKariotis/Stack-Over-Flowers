package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.PendingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import gr.ntua.ece.softeng.kidspiration.User;
import gr.ntua.ece.softeng.kidspiration.Services.UserService;

@RestController
@RequestMapping(path = "/register", method = RequestMethod.GET)  //Could be POST method
public class RegisterController {

    @Autowired
    @Qualifier("ParentService")
    private UserService parent_service;

    @Autowired
    @Qualifier("PendingProviderService")
    private UserService provider_service;

    @RequestMapping(path = "/parent", method = RequestMethod.GET) //Could be POST method?
    public User Parent_registration(@RequestParam String username, @RequestParam String password, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String phone) { //Of course password will be encrypted

        System.out.println("Been parent");
        Parent parent;
        parent = new Parent(0, username, password, firstname, lastname, email, phone, 0, 0, false);
        parent_service.addUser(parent);
        return parent;
        //Probably accepting data in JSON will be different, not @RequestParam
        //Check for atomic id in user, primary key
    }

    @RequestMapping(path = "/provider", method = RequestMethod.GET) //Could be POST method?
    public User Provider_registration(@RequestParam String username, @RequestParam String password, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String phone, @RequestParam String businessName, @RequestParam String bankAccount) { //Of course password will be encrypted

        System.out.println("Been provider");
        PendingProvider provider;
        provider = new PendingProvider(0, username, password, firstname, lastname, email, phone, businessName, bankAccount);
        provider_service.addUser(provider);
        return provider;
        //Probably accepting data in JSON will be different, not @RequestParam
        //Check for atomic id in user, primary key
    }

}