package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.*;
import gr.ntua.ece.softeng.kidspiration.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/path_known_to_admins")      //Change name path
public class AdministratorPanelController {

    @Autowired
    ParentService parentService;

    @Autowired
    ProviderService providerService;

    @Autowired
    PendingProviderService pendingProviderService;

    @Autowired
    PendingEventService pendingEventService;

    @Autowired
    CurrentEventService currentEventService;

    @RequestMapping(path = "/parents", method = RequestMethod.GET)
    public List<Parent> AllParents() {  // Check if ParentView should be used
        return parentService.findAll();
    }

    @RequestMapping(path = "/parents/ban", method = RequestMethod.GET)  //could be POST method!!! //will be parametric to id
    public Parent BanParent(@RequestParam String id, @RequestParam String ban) {
        return parentService.changeRights(Integer.parseInt(id), Boolean.parseBoolean(ban));
    }

    @RequestMapping(path = "/parents/reset_password", method = RequestMethod.GET) //could be PostMethod or PUT?
    public String ParentPasswordReset(@RequestParam String id) {
        // unique string generation for unique URL in email
        //email sent
        return "Password Reset. Please follow above URL";
    }

    @RequestMapping(path = "/parents/delete", method = RequestMethod.GET) //checking
    public String ParentDelete(@RequestParam String id) {
        parentService.deleteUser(Integer.parseInt(id));
        return "Parent deleted successfully";
    }

    @RequestMapping(path = "/providers", method = RequestMethod.GET)
    public List<Provider> AllProviders() {  // Check if ProviderView should be used
        return providerService.findAll();
    }

    @RequestMapping(path = "/providers/rights", method = RequestMethod.GET)  //could be POST method!!! //will be parametric to id
    public Provider BanProvider(@RequestParam String id, @RequestParam String rights_code) {
        return providerService.changeRights(Integer.parseInt(id), Byte.parseByte(rights_code));
    }

    @RequestMapping(path = "/providers/reset_password", method = RequestMethod.GET) //could be PostMethod or PUT?
    public String ProviderPasswordReset(@RequestParam String id) {
        // unique string generation for unique URL in email
        //email sent
        return "Password Reset. Please follow above URL";
    }

    @RequestMapping(path = "/providers/delete", method = RequestMethod.GET) //checked
    public String ProviderDelete(@RequestParam String id) {
        providerService.deleteUser(Integer.parseInt(id));
        return "Provider deleted successfully";
    }

    @RequestMapping(path = "/pending_providers", method = RequestMethod.GET)
    public List<PendingProvider> AllPendingProviders() {
        return pendingProviderService.findAll();
    }

    @RequestMapping(path = "/pending_providers/accept", method = RequestMethod.GET) //could be POST or PUT method
    public String PendingProvidersAccept(@RequestParam String id) {

        PendingProvider provider =  pendingProviderService.find(Integer.parseInt(id)); //we can have whole Object from frontend since AllPendingProviders has been executed

        Provider new_provider = new Provider(0, provider.getUsername(), provider.getPassword(), provider.getFirstname(), provider.getLastname(), provider.getEmail(), provider.getPhone(), provider.getBusinessName(), provider.getBankAccount(), 0, (byte) 0 );

        // THIS SHOULD BE A TRANSACTION!!!
        pendingProviderService.deleteUser(Integer.parseInt(id));
        providerService.addUser(new_provider);
        //END OF TRANSACTION

        //if transaction done return OK
        // Notify user via email
        return "Provider got accepted!!!";
    }

    @RequestMapping(path = "/pending_providers/decline", method = RequestMethod.GET) //could be POST or PUT method
    public String PendingProvidersDecline(@RequestParam String id) {
        pendingProviderService.deleteUser(Integer.parseInt(id));
        return "Pending Provider deleted successfully!";
    }

    @RequestMapping(path = "/pending_events", method = RequestMethod.GET)
    public List<PendingEvent> AllPendingEvents() {
        return pendingEventService.findAll();
    }

    @RequestMapping(path = "/pending_events/accept", method = RequestMethod.GET) //could be POST or PUT method
    public String PendingEventsAccept(@RequestParam String id) {

        PendingEvent event =  pendingEventService.find(Integer.parseInt(id)); //we can have whole Object from frontend since AllPendingEvents has been executed

        // !!! GOOGLE API FOR GETTING LONGTITUDE, LATITUDE FROM Place !!!

        CurrentEvent new_event = new CurrentEvent(0, event.getProvider_id(), event.getTitle(), event.getDate(), event.getStarting_time(), event.getPlace(), event.getType(), event.getTicket_cost(), event.getInitial_ticketsNumber(), event.getLowestAge(), event.getHighestAge(), event.getDescription(), event.getInitial_ticketsNumber(), 35.0000, 36.0000);

        // THIS SHOULD BE A TRANSACTION!!!
        pendingEventService.deleteEvent(Integer.parseInt(id));
        currentEventService.addEvent(new_event);
        //END OF TRANSACTION

        //if transaction done return OK
        // Notify user via email
        return "Event got accepted!!!";
    }

    @RequestMapping(path = "/pending_events/decline", method = RequestMethod.GET) //could be POST or PUT method
    public String PendingEventsDecline(@RequestParam String id) {
            pendingEventService.deleteEvent(Integer.parseInt(id));
            return "Pending Event deleted successfully!";
    }

    @RequestMapping(path = "/current_events", method = RequestMethod.GET)
    public List<CurrentEvent> AllCurrentEvents() {
        return currentEventService.findAll();
    }
}
