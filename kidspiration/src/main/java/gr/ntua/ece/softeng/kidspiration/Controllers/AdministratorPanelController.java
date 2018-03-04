package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.*;
import gr.ntua.ece.softeng.kidspiration.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static java.lang.System.exit;

@RestController
@RequestMapping(path = "/api/path_known_to_admins")      //Change name path
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


    @Autowired
    MonthReferenceService monthReferenceService;

    @Autowired
    StatsService statsService;

    @Autowired
    private JavaMailSender sender;

    @RequestMapping(path = "/parents", method = RequestMethod.GET) //OK
    public List<Parent> AllParents() {  // PARENT VIEW 2 SHOULD BE MADE

        try{
            sendEmail();
            System.out.println("EMAIL SENT!");
        }
        catch (Exception ex){
            System.out.println("ERROR in sending Email: " + ex);
        }
        System.out.println("HERE");
        return parentService.findAll();
    }

    @RequestMapping(path = "/parents/ban", method = RequestMethod.POST)  //POST method // OK
    public Parent BanParent(@RequestBody Parent parent) {
        return parentService.changeRights(parent.getId(), parent.isBan());
    }

    @RequestMapping(path = "/parents/reset_password", method = RequestMethod.POST) //could be PostMethod or PUT? // OK
    public String ParentPasswordReset(@RequestBody Parent parent) {
        // unique string generation for unique URL in email
        //email sent
        System.out.println(parent.getId());
        return "Password Reset. Please follow above URL";
    }

    @RequestMapping(path = "/parents/delete", method = RequestMethod.POST) // OK
    public String ParentDelete(@RequestBody Parent parent) {
        parentService.deleteUser(parent.getId());
        return "Parent deleted successfully";
    }

    @RequestMapping(path = "/providers", method = RequestMethod.GET)  // OK
    public List<Provider> AllProviders() {  // Check if ProviderView should be used
        return providerService.findAll();
    }

    @RequestMapping(path = "/providers/rights", method = RequestMethod.POST)  //POST method!!!
    public Provider BanProvider(@RequestBody Provider provider) {
        return providerService.changeRights(provider.getId(), provider.getRights_code());
    }

    @RequestMapping(path = "/providers/reset_password", method = RequestMethod.POST) //could be PostMethod or PUT? // OK
    public String ProviderPasswordReset(@RequestBody Provider provider) {
        // unique string generation for unique URL in email
        //email sent
        System.out.println(provider.getId());
        return "Password Reset. Please follow above URL";
    }

    @RequestMapping(path = "/providers/delete", method = RequestMethod.POST) // OK
    public String ProviderDelete(@RequestBody Provider provider) {
        providerService.deleteUser(provider.getId());
        return "Provider deleted successfully";
    }

    @RequestMapping(path = "/pending_providers", method = RequestMethod.GET) // OK
    public List<PendingProvider> AllPendingProviders() {
        return pendingProviderService.findAll();
    }

    @RequestMapping(path = "/pending_providers/accept", method = RequestMethod.POST) //could be POST or PUT method // OK
    public String PendingProvidersAccept(@RequestBody PendingProvider pendingProvider) {

        if ((pendingProvider.getPhone()).equals("0")) { //Decline
            pendingProviderService.deleteUser(pendingProvider.getId());
            return "Pending provider got declined";
        }
        else {// phone == 1 // Accept

            PendingProvider provider = pendingProviderService.find(pendingProvider.getId());

            Provider new_provider = new Provider(0, provider.getUsername(), provider.getPassword(), provider.getFirstname(), provider.getLastname(), provider.getEmail(), provider.getPhone(), provider.getBusinessName(), provider.getBankAccount(), provider.getSalt(), 0, (byte) 0);

            // THIS SHOULD BE A TRANSACTION!!!
            pendingProviderService.deleteUser(pendingProvider.getId());
            providerService.addUser(new_provider);
            //END OF TRANSACTION

            //if transaction done return OK
            // Notify user via email
            return "Provider got accepted!!!";
        }
    }

    @RequestMapping(path = "/pending_events", method = RequestMethod.GET) // OK
    public List<PendingEventView> AllPendingEvents() {
        return pendingEventService.findAllPendingEventViews();
    }

    @RequestMapping(path = "/pending_events/accept", method = RequestMethod.POST) //could be POST or PUT method // OK
    public String PendingEventsAccept(@RequestBody PendingEvent pendingEvent) {// @RequestBody LinkedHashMap id) {
        //Object o = id.get("id");
        //System.out.println(String.valueOf(o));
        //int integer_id = Integer.valueOf(String.valueOf(o));
        //PendingEvent event =  pendingEventService.find(integer_id); //we can have whole Object from frontend since AllPendingEvents has been executed

        int id = pendingEvent.getEvent_id();

        if(pendingEvent.getHighestAge() == 0) { //Decline
            pendingEventService.deleteEvent(id);
            return "Pending Event got declined";
        }
        else { // Accept

            PendingEvent event = pendingEventService.find(id);

            // !!! GOOGLE API FOR GETTING LONGITUDE, LATITUDE FROM Place !!! /* Doing it now.. Don't push me.. *** */

            CurrentEvent new_event = new CurrentEvent(0, event.getProvider_id(), event.getTitle(), event.getDate(), event.getStarting_time(), event.getPlace(), event.getCategories(), event.getTicket_cost(), event.getInitial_ticketsNumber(), event.getLowestAge(), event.getHighestAge(), event.getDescription(), event.getInitial_ticketsNumber(), 35.0000, 36.0000);

            // THIS SHOULD BE A TRANSACTION!!!
        /*  ***
            Make it a transaction or inverse order of called methods.
            Better to have a duplicate, pending event than to have the original event lost.
         */
            new_event = currentEventService.addEvent(new_event);
            System.out.println("SQL INSERTION DONE");
            pendingEventService.deleteEvent(id);
            System.out.println("DELETION DONE");

            try {
                currentEventService.addEventElastic(new_event);
            } catch (IOException ex) {
                System.out.println(ex);
                return "Insertion in Elastic failed";
            }

            //END OF TRANSACTION

            //if transaction done return OK
            // Notify user via email
            return "Event got accepted";
        }
    }

    @RequestMapping(path = "/current_events", method = RequestMethod.GET) // OK
    public List<EventPageView> AllCurrentEvents() {
        return currentEventService.findAllEventPages();
    }

    @RequestMapping(path = "/month_report", method = RequestMethod.GET)
    public List<MonthReference> sendMonthReference() {
        return monthReferenceService.findAll();
    }

    @RequestMapping(path = "/stats", method = RequestMethod.GET)
    public StatsView sendStats() {
        int numOfParents=statsService.numOfParents();
        int numOfProviders=statsService.numOfProviders();
        MonthReference monthReference=monthReferenceService.find(12);
        double profit=monthReference.getProfit();
        StatsView statsView=new StatsView(numOfParents, numOfProviders, profit);
        return statsView;
    }

    private void sendEmail() throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo("mgvardas@hotmail.com");   /* Under which address is the e-mail sent? *** */
        helper.setText("A test just to see that Email Notification is Working!");
        helper.setSubject("It works!");

        sender.send(message);
    }
}
