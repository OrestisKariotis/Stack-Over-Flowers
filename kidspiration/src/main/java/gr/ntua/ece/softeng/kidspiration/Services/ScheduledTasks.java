package gr.ntua.ece.softeng.kidspiration.Services;

//import java.util.ArrayList;

import com.sun.glass.ui.Pixels;
import com.sun.org.apache.bcel.internal.generic.FieldOrMethod;
import gr.ntua.ece.softeng.kidspiration.*;
import gr.ntua.ece.softeng.kidspiration.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
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
    //private UserService providerService;
    private ProviderService providerService;

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

    @Autowired
    //@Qualifier("MonthProviderReferenceService");
    private MonthProviderReferenceService monthProviderReferenceService;



    /*  3234baa74d2d8ed4137e582f5cf184f4e310b710 <-- What the bloody hell is this turd I found?
    Occured at pull, 02/03 at 0:15, refer to http://prntscr.com/ilqo5v.  *** */
   @Scheduled(fixedRate = 30000)           //@Scheduled(cron = "0 30 2 * * ?") /* Test fixed time *** */ /* Is this fucker not a service */
    public void dailyUpdates() {
        System.out.println("Eisai malakas kai de tha treksei pote");
        Calendar cal = Calendar.getInstance(); /* get now in calendar format */
        //cal.add(Calendar.DATE, -1);      /* find events that transpired YESTERDAY */ /* apply *** */
        Date utilDate = cal.getTime();    /* get now in util.Date format */
        java.sql.Date sDate = new java.sql.Date(utilDate.getTime());    /* get now in sql.Date format */

        /* for month references */
        MonthReference monthReference= monthReferenceService.find(cal.get(Calendar.MONTH));//where month=cal

        MonthReference monthReferenceTotal = monthReferenceService.find(12);

        MonthProviderReference monthProviderReference;

        /* list of all events that transpired yesterday */
        List<CurrentEvent> myList;
        myList = currentEventService.findWithDate(sDate); /*  */
        Provider p;     // every provider whose earnings we change
        System.out.println(myList.size());

        for (int i = 0; i < myList.size(); i++) {

            /* update provider total profits */ /* need to update provider monthly profits *** */
            p = (Provider) providerService.find(myList.get(i).getProvider_id());
            double temp = p.getProfit();

            p.setProfit(temp+(myList.get(i).getTicket_cost()*0.9*(myList.get(i).getInitial_ticketsNumber()-myList.get(i).getAvailable_ticketsNumber()))/100);
            providerService.editUser(p, p.getId());  //vres kai enhmerwse ta esoda tou en logw provider dld esoda=esoda+0.9*myList.get(i).cost

            /* update our monthly expenses */
            temp = monthReference.getExpenses();
            monthReference.setExpenses(temp+(myList.get(i).getTicket_cost()*0.9*(myList.get(i).getInitial_ticketsNumber()-myList.get(i).getAvailable_ticketsNumber()))/100);
            monthReferenceService.editMonthReference(monthReference); //vres kai enhmerwse th vash gia ta eksoda tou en logw mhna!

            temp = monthReferenceTotal.getExpenses();
            monthReferenceTotal.setExpenses(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            monthReferenceService.editMonthReference(monthReferenceTotal);

            /*update provider's monthly report */
            monthProviderReference = monthProviderReferenceService.find(p.getId()); //na paei sto monthproviderservice ***
            if ((cal.get(Calendar.MONTH)) == 0) {
                temp = monthProviderReference.getJanuary();
                monthProviderReference.setJanuary(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            } else if ((cal.get(Calendar.MONTH)) == 1) {
                temp = monthProviderReference.getFebruary();
                monthProviderReference.setFebruary(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            } else if ((cal.get(Calendar.MONTH)) == 2) {
                temp = monthProviderReference.getMarch();
                monthProviderReference.setMarch(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            } else if ((cal.get(Calendar.MONTH)) == 3) {
                temp = monthProviderReference.getApril();
                monthProviderReference.setApril(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            } else if ((cal.get(Calendar.MONTH)) == 4) {
                temp = monthProviderReference.getMay();
                monthProviderReference.setMay(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            } else if ((cal.get(Calendar.MONTH)) == 5) {
                temp = monthProviderReference.getJune();
                monthProviderReference.setJune(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            } else if ((cal.get(Calendar.MONTH)) == 6) {
                temp = monthProviderReference.getJuly();
                monthProviderReference.setJuly(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            } else if ((cal.get(Calendar.MONTH)) == 7) {
                temp = monthProviderReference.getAugust();
                monthProviderReference.setAugust(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            } else if ((cal.get(Calendar.MONTH)) == 8) {
                temp = monthProviderReference.getSeptember();
                monthProviderReference.setSeptember(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            } else if ((cal.get(Calendar.MONTH)) == 9) {
                temp = monthProviderReference.getOctomber();
                monthProviderReference.setOctomber(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            } else if ((cal.get(Calendar.MONTH)) == 10) {
                temp = monthProviderReference.getNovember();
                monthProviderReference.setNovember(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            } else if ((cal.get(Calendar.MONTH)) == 11) {
                temp = monthProviderReference.getDecember();
                monthProviderReference.setDecember(temp + (myList.get(i).getTicket_cost() * 0.9 * (myList.get(i).getInitial_ticketsNumber() - myList.get(i).getAvailable_ticketsNumber()))/100);
            }


            monthProviderReferenceService.editMonthProviderReference(monthProviderReference);

            /* age all events that transpired yesterday */

            int currentEvent_id = myList.get(i).getEvent_id();
            OldEvent oldEvent = new OldEvent(0, myList.get(i).getProvider_id(), myList.get(i).getTitle(), myList.get(i).getDate(), myList.get(i).getStarting_time(), myList.get(i).getPlace(), myList.get(i).getCategories(), myList.get(i).getTicket_cost(), myList.get(i).getInitial_ticketsNumber(), myList.get(i).getInitial_ticketsNumber()-myList.get(i).getAvailable_ticketsNumber());
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
        /* ELASTIC, PLAKAS SAID TO TRUST HIM*/
        utilDate = cal.getTime();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(utilDate);
        System.out.println(s);

        Elastic leplak = new Elastic();
        leplak.setup("localhost", 9200, "kids3");
        try {
            List<String> list = leplak.searchIdsToDelee(s);
            leplak.bulkedDelete(list);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Elastic Error");
        }
    }

/*  3234baa74d2d8ed4137e582f5cf184f4e310b710 <-- What the bloody hell is this turd I found?
    Occured at pull, 02/03 at 0:15, refer to http://prntscr.com/ilqo5v.  *** */
    @Scheduled(fixedRate = 62000)       /* make it monthly */    /* for every start of the month */
    public void monthlyResets(){
        Calendar cal = Calendar.getInstance();
        MonthReference monthReference= monthReferenceService.find(cal.get(Calendar.MONTH));
        monthReference.setEarnings(0);
        monthReference.setProfit(0.0);
        monthReference.setExpenses(0);
        monthReferenceService.editMonthReference(monthReference);

        List<Provider> providerList = providerService.findAll();
        //eksw o elegxos!! ***
        for (int i = 0; i < providerList.size(); i++) {
            MonthProviderReference monthProviderReference = monthProviderReferenceService.find(providerList.get(i).getId());
            if ((cal.get(Calendar.MONTH)) == 0) {
                monthProviderReference.setJanuary(0);
            }
            else if ((cal.get(Calendar.MONTH)) == 1) {
                monthProviderReference.setFebruary(0);
            }
            else if ((cal.get(Calendar.MONTH)) == 2) {
                monthProviderReference.setMarch(0);
            }
            else if ((cal.get(Calendar.MONTH)) == 3) {
                monthProviderReference.setApril(0);
            }
            else if ((cal.get(Calendar.MONTH)) == 4) {
                monthProviderReference.setMay(0);
            }
            else if ((cal.get(Calendar.MONTH)) == 5) {
                monthProviderReference.setJune(0);
            }
            else if ((cal.get(Calendar.MONTH)) == 6) {
                monthProviderReference.setJuly(0);
            }
            else if ((cal.get(Calendar.MONTH)) == 7) {
                monthProviderReference.setAugust(0);
            }
            else if ((cal.get(Calendar.MONTH)) == 8) {
                monthProviderReference.setSeptember(0);
            }
            else if ((cal.get(Calendar.MONTH)) == 9) {
                monthProviderReference.setOctomber(0);
            }
            else if ((cal.get(Calendar.MONTH)) == 10) {
                monthProviderReference.setNovember(0);
            }
            else {
                monthProviderReference.setDecember(0);
            }
            monthProviderReferenceService.editMonthProviderReference(monthProviderReference);
        }
    }
}






