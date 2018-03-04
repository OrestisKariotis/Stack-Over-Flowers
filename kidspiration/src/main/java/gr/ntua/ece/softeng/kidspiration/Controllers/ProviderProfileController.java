package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.*;
import gr.ntua.ece.softeng.kidspiration.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/profile/provider/{id}") //path could be parametric to provider_id
public class ProviderProfileController {

    @Autowired
    ProviderService providerService;

    @Autowired
    CurrentEventService currentEventService;

    @Autowired
    MonthProviderReferenceService monthProviderReferenceService;

    @Autowired
    OldEventService oldEventService;

    @Autowired
    PendingEventService pendingEventService;


    @RequestMapping(path = "/personal_info", method = RequestMethod.GET)   // private profile // OK
    public Provider ProviderProfile_PersonalInfo_Private(@PathVariable String id) {
        // Should we have some authorisation for Private Profile?
        return providerService.find(Integer.parseInt(id));
    }

    @RequestMapping(path = "/personal_info/edit", method = RequestMethod.POST)  // private profile
    public ProviderInfo ProviderProfile_PersonalInfoEdit_Private(@PathVariable String id, @RequestBody ProviderInfo providerInfo) {

        providerService.editInfo(Integer.parseInt(id), providerInfo.getFirstname(), providerInfo.getLastname(), providerInfo.getPhone(), providerInfo.getBankAccount());
        return providerInfo;
    }

    @RequestMapping(path = "/info", method = RequestMethod.GET) // may not be needed, we can return whole Provider Object when Profile page is requested
    public ProviderView ProviderProfile_PersonalInfo_Public(@PathVariable String id) {  // public profile  // OK
        return providerService.findView(Integer.parseInt(id));  // Diverges a bit from wireframe
    }

    @RequestMapping(path = "/current_events", method = RequestMethod.GET)  // NOT FINISHED
    public List<CurrentEventView> ProviderProfile_CurrentEvents_Public(@PathVariable String id) {
        return  currentEventService.findWithProvider(Integer.parseInt(id));
    }

    @RequestMapping(path = "/events", method = RequestMethod.GET) //Checking  //the private version of /current_events
    public List<CurrentEvent> ProviderProfile_Events_Private(@PathVariable String id) {
        List<CurrentEvent> currentEvents= currentEventService.findAllByProvider(Integer.parseInt(id));
        return currentEvents;

    }

    @RequestMapping(path = "/pending_events", method = RequestMethod.GET) //Checking
    public List<PendingEvent> ProviderProfile_PendingEvents_Private(@PathVariable String id) {

        List<PendingEvent> pendingEvents=pendingEventService.findWithProvider(Integer.parseInt(id));
        return pendingEvents;
    }

    @RequestMapping(path = "/old_events", method = RequestMethod.GET) //Checking
    public List<OldEvent> ProviderProfile_OldEvents_Private(@PathVariable String id) {

        List<OldEvent> oldEvents=oldEventService.findWithProvider(Integer.parseInt(id));
        return oldEvents;
    }

    @RequestMapping(path = "/months_report/{month}", method = RequestMethod.GET) //Checking
    public ProviderReportView ProviderProfile_MonthReport_Private(@PathVariable String id, @PathVariable String month) {
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

    @RequestMapping(path = "/totalReport/{mont}", method = RequestMethod.GET) //Checking
    public OldEventView[] find_Profit_Of_Old_Events(@PathVariable String id, @PathVariable String mont) {

         List<OldEvent> oldEvents=oldEventService.findWithMonth(Integer.parseInt(mont)+1, Integer.parseInt(id));
         OldEventView[] oldEventViews=new OldEventView[oldEvents.size()];
         for (int i=0; i<oldEvents.size(); i++) {
             double profit=oldEvents.get(i).getSold_ticketsNumber()*0.9*oldEvents.get(i).getTicket_cost()/100;
             oldEventViews[i]=new OldEventView(oldEvents.get(i).getTitle(), oldEvents.get(i).getDate(), oldEvents.get(i).getTicket_cost(), oldEvents.get(i).getInitial_ticketsNumber(), oldEvents.get(i).getSold_ticketsNumber(), profit);
         }
         return oldEventViews;
         }
}
