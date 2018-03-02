package gr.ntua.ece.softeng.kidspiration.Controllers;

//import java.util.ArrayList;

import gr.ntua.ece.softeng.kidspiration.*;
import gr.ntua.ece.softeng.kidspiration.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

//import org.springframework.beans.factory.annotation.Qualifier;
//import gr.ntua.ece.softeng.kidspiration.Ticket;
//import gr.ntua.ece.softeng.kidspiration.Services.EventService;


@Component
public class ScheduledTasks {

    @Autowired
    //@Qualifier("ProviderService");
    private UserService providerService;


    @Autowired
    // @Qualifier("CurrentEventService");
    private CurrentEventService currentEventService;

    @Autowired
    //@Qualifier("OldEventService");
    private OldEventService oldEventService;

    @Autowired
    // @Qualifier("MonthReferenceService");
    private MonthReferenceService monthReferenceService;

    @Autowired
    // @Qualifier("CurrentEventService");
    private TicketService ticketService;

    @Autowired
    //@Qualifier("OldTicketService");
    private OldTicketService oldTicketService;


    @Scheduled(fixedRate = 30000)           //@Scheduled(cron = "0 30 2 * * ?") /* Test fixed time *** */ /* Is this fucker not a service */
    public void dailyUpdates() {
        System.out.println("Eisai malakas kai de tha treksei pote");
        Calendar cal = Calendar.getInstance(); /* get now in calendar format */
        //cal.add(Calendar.DATE, -1);      /* find events that transpired YESTERDAY */ /* apply *** */
        Date utilDate = cal.getTime();    /* get now in util.Date format */
        java.sql.Date sDate = new java.sql.Date(utilDate.getTime());    /* get now in sql.Date format */

        /* for month references */
        MonthReference monthReference= monthReferenceService.find(cal.get(Calendar.MONTH));//where month=cal

        /* list of all events that transpired yesterday */
        List<CurrentEvent> myList;
        myList = currentEventService.findWithDate(sDate); /*  */
        Provider p;     // every provider whose earnings we change
        System.out.println(myList.size());

        for (int i = 0; i < myList.size(); i++) {

            /* update provider total profits */ /* need to update provider monthly profits *** */
            p = (Provider) providerService.find(myList.get(i).getProvider_id());
            double temp = p.getProfit();

            p.setProfit(temp+myList.get(i).getTicket_cost()*0.9*(myList.get(i).getInitial_ticketsNumber()-myList.get(i).getAvailable_ticketsNumber()));
            providerService.editUser(p, p.getId());  //vres kai enhmerwse ta esoda tou en logw provider dld esoda=esoda+0.9*myList.get(i).cost

            /* update our monthly expenses */
            temp = monthReference.getExpenses();
            monthReference.setExpenses(temp+myList.get(i).getTicket_cost()*0.9*(myList.get(i).getInitial_ticketsNumber()-myList.get(i).getAvailable_ticketsNumber()));
            monthReferenceService.editMonthReference(monthReference); //vres kai enhmerwse th vash gia ta eksoda tou en logw mhna!

            /* age all events that transpired yesterday */
            int currentEvent_id = myList.get(i).getEvent_id();
            OldEvent oldEvent = new OldEvent(0, myList.get(i).getProvider_id(), myList.get(i).getTitle(), myList.get(i).getDate(), myList.get(i).getStarting_time(), myList.get(i).getPlace(), myList.get(i).getType(), myList.get(i).getTicket_cost(), myList.get(i).getInitial_ticketsNumber(), myList.get(i).getInitial_ticketsNumber()-myList.get(i).getAvailable_ticketsNumber());
            int oldEvent_id = oldEventService.addOldEvent(oldEvent); /* save event_id for later on (tickets' aging */
            System.out.println("Fuck my life (I age)");

            /* age tickets of each event */
            List<Ticket> ticketsList;
            ticketsList = ticketService.findByEvent(currentEvent_id);
            for (int j = 0; j < ticketsList.size(); j++) {
                System.out.println("new oldEvent id is: " + oldEvent_id);
                oldTicketService.addOldTicket(ticketsList.get(j), oldEvent_id);
            }
            System.out.println("Fuck! My tickets aged well! :)");


            /* delete every event that transpired and sql cascade-deletes all of its tickets */
            currentEventService.deleteEvent(myList.get(i).getEvent_id());
        }

        /* Delete events -and as such, tickets- 365 days ago */ /* check id and foreign key relations *** */
        //final int blackMagic = 23; //Back to the future.

        Calendar calDrogo = Calendar.getInstance();     /* get new time instance */
        calDrogo.add(Calendar.DATE, -365);
        Date date = calDrogo.getTime();   /* make util */
        System.out.println(date);
        sDate = new java.sql.Date(date.getTime());  /* make usable sql.Date */
        oldEventService.deleteWithDate(sDate);
    }


    @Scheduled(fixedRate = 62000)       /* make it monthly */    /* for every start of the month */
    public void monthlyResets(){
        Calendar cal = Calendar.getInstance();
        MonthReference monthReference= monthReferenceService.find(cal.get(Calendar.MONTH));
        monthReference.setEarnings(0);
        monthReference.setProfit(0.0);
        monthReference.setExpenses(0);
        monthReferenceService.editMonthReference(monthReference);
    }





}


