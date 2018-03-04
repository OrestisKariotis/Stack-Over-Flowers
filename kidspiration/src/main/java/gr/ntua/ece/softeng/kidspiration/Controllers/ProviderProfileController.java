package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.OldEvent;
import gr.ntua.ece.softeng.kidspiration.CurrentEventView;
import gr.ntua.ece.softeng.kidspiration.MonthProviderReference;
import gr.ntua.ece.softeng.kidspiration.Provider;
import gr.ntua.ece.softeng.kidspiration.ProviderView;
import gr.ntua.ece.softeng.kidspiration.Services.CurrentEventService;
import gr.ntua.ece.softeng.kidspiration.Services.OldEventService;
import gr.ntua.ece.softeng.kidspiration.Services.ProviderService;
import gr.ntua.ece.softeng.kidspiration.Services.MonthProviderReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import gr.ntua.ece.softeng.kidspiration.ProviderReportView;

import java.util.List;
import gr.ntua.ece.softeng.kidspiration.OldEventView;

@RestController
@RequestMapping(path = "/profile/provider") //path could be parametric to provider_id
public class ProviderProfileController {

    @Autowired
    ProviderService providerService;

    @Autowired
    CurrentEventService currentEventService;

    @Autowired
    MonthProviderReferenceService monthProviderReferenceService;

    @Autowired
    OldEventService oldEventService;

    @RequestMapping(path = "/personal_info", method = RequestMethod.GET)   // private profile // OK
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
    public ProviderView ProviderProfile_PersonalInfo_Public(@RequestParam String id) {  // public profile  // OK
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
    public ProviderReportView ProviderProfile_MonthReport_Private(@RequestParam String id, @RequestParam String month) {
         MonthProviderReference monthProviderReference=monthProviderReferenceService.find(Integer.parseInt(id));
         int temp=Integer.parseInt(month);
         double monthProfit;
         if (temp==0) {
             monthProfit= monthProviderReference.getJanuary();
         }
         else if (temp==1) {
             monthProfit= monthProviderReference.getFebruary();
         }
         else if (temp==2) {
             monthProfit=monthProviderReference.getMarch();
         }
         else if (temp==3) {
             monthProfit=monthProviderReference.getApril();
         }
         else if (temp==4) {
             monthProfit=monthProviderReference.getMay();
         }
         else if (temp==5) {
             monthProfit=monthProviderReference.getJune();
         }
         else if (temp==6) {
             monthProfit=monthProviderReference.getJuly();
         }
         else if (temp==7) {
             monthProfit=monthProviderReference.getAugust();
         }
         else if (temp==8) {
             monthProfit=monthProviderReference.getSeptember();
         }
         else if (temp==9) {
             monthProfit=monthProviderReference.getOctomber();
         }
         else if (temp==10) {
             monthProfit=monthProviderReference.getNovember();
         }
         else {
             monthProfit=monthProviderReference.getDecember();
          }
          Provider p=providerService.find(Integer.parseInt(id));
          double totalProfit=p.getProfit();
          ProviderReportView providerReportView=new ProviderReportView(totalProfit, monthProfit);
          return providerReportView;
    }

    @RequestMapping(path = "/totalReport", method = RequestMethod.GET) //Checking
    public OldEventView[] find_Profit_Of_Old_Events(@RequestParam String provider_id, @RequestParam String month) {

         List<OldEvent> oldEvents=oldEventService.findWithMonth(Integer.parseInt(month)+1, Integer.parseInt(provider_id)); //PREPEI NA TO VROUME!!!!!!
         OldEventView[] oldEventViews=new OldEventView[oldEvents.size()];
         for (int i=0; i<oldEvents.size(); i++) {
             double profit=oldEvents.get(i).getSold_ticketsNumber()*0.9*oldEvents.get(i).getTicket_cost()/100;
             oldEventViews[i]=new OldEventView(oldEvents.get(i).getTitle(), oldEvents.get(i).getDate(), oldEvents.get(i).getTicket_cost(), oldEvents.get(i).getInitial_ticketsNumber(), oldEvents.get(i).getSold_ticketsNumber(), profit);
         }
         return oldEventViews;
         }
}
