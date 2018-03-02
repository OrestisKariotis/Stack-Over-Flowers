package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.CurrentEvent;
import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketPurchaseController {

    @Autowired
    //@Qualifier("ParentService")
    ParentService parentService;

    @Autowired
    //@Qualifier("CurrentEventService")
    CurrentEventService eventService;

    @Autowired
    //@Qualifier("TicketService")
    TicketService ticketService;

    @RequestMapping(path = "/purchase_tickets", method = RequestMethod.GET) // Will be post method
    //URL probably will be parametric to event_id
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public String PurchaseTickets(@RequestParam String id, @RequestParam String event_id,@RequestParam String tickets_number) {

        System.out.println("ENTER");

        int tickets = Integer.parseInt(tickets_number);

        Parent parent = parentService.find(Integer.parseInt(id));  //could be put inside Services
        CurrentEvent event = eventService.find(Integer.parseInt(event_id));  // could be put inside services

        // should get Event Object DEFENITELY, frontend maybe have an incosistent instance of it

        if (tickets > event.getAvailable_ticketsNumber())  // could be checked in frontend, tickets > 0!!! /* Or could be checked in the service. *** */
            return "Number of tickets requested exceed available tickets number";
        else if (parent.getWallet() < tickets*event.getTicket_cost())  // could be checked in frontend, or NOT?
            return "Your wallet is not enough for purchasing requested tickets";
        // + elegxos gia wraaaaaaa /* Implemented yet? *** */
        else {
            eventService.buyTickets(event, tickets, Integer.parseInt(event_id));
            ticketService.addTickets(Integer.parseInt(id), Integer.parseInt(event_id), tickets);
            parentService.decreasePoints(parent, tickets * event.getTicket_cost());
        }

        // UNLOCK, SEE @Transactional in Spring

        System.out.println("LEAVING");
        return "Successful Ticket Purchase!!!";
        //!!! Frontend should get new updated instance of parent!!!!!
        //probably this request will be subset of event page GET method
        // event_id should be known to client -> will be known when event page will be requested
        // same for parent
    }


}
