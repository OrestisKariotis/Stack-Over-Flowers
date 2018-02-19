package gr.ntua.ece.softeng.kidspiration.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.ntua.ece.softeng.kidspiration.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import gr.ntua.ece.softeng.kidspiration.model.PendingProvider;

@RestController
public class RegistrationController {
    ParentImpl newParent;
    ProviderImpl newProvider;

    @RequestMapping("/registerParent")
    public Parent registerParent(@RequestParam String Username, @RequestParam String Password, @RequestParam String Firstname, @RequestParam String Lastname, @RequestParam String email, @RequestParam int phone)
    {
        Parent par= new Parent(Username, Password, Firstname, Lastname, phone, email);
        //newParent.register(par);//enhmerwsh vashs
        return(par);
    }

    @RequestMapping("/registerProvider")
    public void registerProvider(@RequestParam String Username, @RequestParam String Password, @RequestParam String Firstname, @RequestParam String Lastname, @RequestParam String Businessname, @RequestParam String email, @RequestParam int phone, @RequestParam int Banknumber)
    {
        PendingProvider prov= new PendingProvider(Firstname, Lastname, Username, Password, Businessname, phone, email, Banknumber);
        //newPendingProvider.register(prov); enhmerwsh vashs
    }


}
