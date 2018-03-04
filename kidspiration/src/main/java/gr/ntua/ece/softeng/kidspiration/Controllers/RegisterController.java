package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.ParentView;
import gr.ntua.ece.softeng.kidspiration.PendingProvider;
import gr.ntua.ece.softeng.kidspiration.Services.ParentService;
import gr.ntua.ece.softeng.kidspiration.Services.PendingProviderService;
import gr.ntua.ece.softeng.kidspiration.Services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gr.ntua.ece.softeng.kidspiration.User;
import gr.ntua.ece.softeng.kidspiration.Services.UserService;

import javax.xml.ws.Response;

@RestController
@RequestMapping(path = "/api/register", method = RequestMethod.POST)  //POST method
public class RegisterController {

    @Autowired
    //@Qualifier("ParentService")
    //private UserService parent_service;
    private ParentService parentService;

    @Autowired
    //@Qualifier("PendingProviderService")
    //private UserService provider_service;
    private PendingProviderService providerService;

    @RequestMapping(path = "/parent", method = RequestMethod.POST) //POST method
    public ResponseEntity<?> Parent_registration(@RequestBody Parent parent) {//@RequestParam String username, @RequestParam String password, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String phone) { //Of course password will be encrypted

        System.out.println(parent.getPassword());
        System.out.println("Enter: Parent Registration");

        //Parent parent;
        // parent = new Parent(0, username, password, firstname, lastname, email, phone, 0, 0, false);

        parent = parentService.addUser(parent);

        System.out.println("Exit: Parent Registartion");

        //EMAIL NOTIFICATION
        if (parent.getSpent_points() == 0) { //or get him to login
            ParentView parentView = new ParentView(parent.getId(), parent.getUsername(), parent.getFirstname(), parent.getLastname(), parent.getEmail(), parent.getPhone(), parent.getWallet());
            return ResponseEntity.accepted().body(parentView);
        } else if (parent.getSpent_points() == 1)
            return ResponseEntity.badRequest().body("Username already exists");
        else
            return ResponseEntity.badRequest().body("Email already exists");
    }

    @RequestMapping(path = "/provider", method = RequestMethod.POST) //POST method
    public ResponseEntity<?> Provider_registration(@RequestBody PendingProvider provider) {//@RequestParam String username, @RequestParam String password, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String phone, @RequestParam String businessName, @RequestParam String bankAccount) { //Of course password will be encrypted
        // @RequestBody PendingProvider
        // OK

        System.out.println("Enter: Provider Registration");
        //PendingProvider provider;
        //provider = new PendingProvider(0, username, password, firstname, lastname, email, phone, businessName, bankAccount);

        provider = providerService.addUser(provider);

        System.out.println("Exit: Provider Registartion");

        //EMAIL NOTIFICATION
        if (provider.getId() == 1000)
            return ResponseEntity.badRequest().body("Username already exists");
        else if (provider.getId() == 2000)
            return ResponseEntity.badRequest().body("Email already exists");
        else
            return ResponseEntity.accepted().body("OK");

    }
}