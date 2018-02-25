package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.CurrentEventView;
import gr.ntua.ece.softeng.kidspiration.Provider;
import gr.ntua.ece.softeng.kidspiration.ProviderView;
import gr.ntua.ece.softeng.kidspiration.Services.CurrentEventService;
import gr.ntua.ece.softeng.kidspiration.Services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/profile/provider") //path could be parametric to provider_id
public class ProviderProfileController {

    @Autowired
    ProviderService providerService;

    @Autowired
    CurrentEventService currentEventService;

    @RequestMapping(path = "/personal_info", method = RequestMethod.GET)   // private profile
    public Provider ProviderProfile_PersonalInfo_Private(@RequestParam String id) {
        // Should we have some authorisation for Private Profile?
        return providerService.find(Integer.parseInt(id));
    }

    @RequestMapping(path = "/personal_info/edit", method = RequestMethod.GET) //POST method!!!  // private profile
    public Provider ProviderProfile_PersonalInfoEdit_Private(@RequestParam String id, @RequestParam String username, @RequestParam String password, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String phone, @RequestParam String businessName, @RequestParam String bankAccount, @RequestParam String profit, @RequestParam String rights_code) {
        //if not all parameters can change, then Provider object sending is redundant. Later, we 'll use JSON commands
        //to get only the things that are about to change, find will be needed then to get Provider Object or a new more reduced editUser
        Provider provider = new Provider(Integer.parseInt(id), username, password, firstname, lastname, email, phone, businessName, bankAccount, Integer.parseInt(profit), Byte.parseByte(rights_code));
        // Need to know what can we change and what not. These will be passed to EditUser
        providerService.editUser(provider, Integer.parseInt(id));
        return provider;
    }

    @RequestMapping(path = "/info", method = RequestMethod.GET) // may not be needed, we can return whole Provider Object when Profile page is requested
    public ProviderView ProviderProfile_PersonalInfo_Public(@RequestParam String id) {  // public profile
        return providerService.findView(Integer.parseInt(id));  // Diverges a bit from wireframe
        // Omit this if not needed!
    }

    @RequestMapping(path = "/current_events", method = RequestMethod.GET)  // NOT FINISHED
    public List<CurrentEventView> ProviderProfile_CurrentEvents_Public(@RequestParam String id) {
        return  currentEventService.findAllViews_ByProviderId(Integer.parseInt(id));
    }

    @RequestMapping(path = "/events", method = RequestMethod.GET) //Checking  //the private version of /current_events
    public List<CurrentEventView> ProviderProfile_Events_Private(@RequestParam String id) {
        return null;
    }

    @RequestMapping(path = "/pending_events", method = RequestMethod.GET) //Checking
    public List<CurrentEventView> ProviderProfile_PendingEvents_Private(@RequestParam String id) {
        return null;
    }

    @RequestMapping(path = "/old_events", method = RequestMethod.GET) //Checking
    public List<CurrentEventView> ProviderProfile_OldEvents_Private(@RequestParam String id) {
        return null;
    }

    @RequestMapping(path = "/months_report", method = RequestMethod.GET) //Checking
    public void ProviderProfile_MonthReport_Private(@RequestParam String id, @RequestParam String month) {

    }
}
