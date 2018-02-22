package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.CurrentEvent;
import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public String PurchaseTickets(@RequestParam String id, @RequestParam String username, @RequestParam String password, @RequestParam String firstname,
    @RequestParam String lastname, @RequestParam String email, @RequestParam String phone, @RequestParam String wallet, @RequestParam String spent_points,
                                @RequestParam String ban, @RequestParam String event_id,@RequestParam String tickets_number) {

        Parent parent = new Parent(Integer.parseInt(id), username, password, firstname, lastname, email, phone, Integer.parseInt(wallet), Integer.parseInt(spent_points), Boolean.parseBoolean(ban));
        int tickets = Integer.parseInt(tickets_number);

        // above parameters should give the appropriate Parent and Event Objects and WILL BE CHANGED

        // should be considered as one transaction, All or Nothing. SYNCRONISATION needed. SEE @Transactional in Spring
        // LOCK

        CurrentEvent event = eventService.find(Integer.parseInt(event_id));

        // should get Event Object DEFENITELY, frontend maybe have an incosistent instance of it

        if (tickets > event.getAvailable_ticketsNumber())  // could be checked in frontend, tickets > 0!!!
            return "Number of tickets requested exceed available tickets number";
        else if (parent.getWallet() < tickets*event.getTicket_cost())  // could be checked in frontend, or NOT?
            return "Your wallet is not enough for purchasing requested tickets";
        else {
            eventService.buyTickets(event, tickets, Integer.parseInt(event_id));
            ticketService.addTickets(Integer.parseInt(id), Integer.parseInt(event_id), tickets);
            parentService.decreasePoints(parent, tickets * event.getTicket_cost());
        }

        // UNLOCK, SEE @Transacctional in Spring

        return "Successful Ticket Purchase!!!";

        //!!! Frontend should get new updated instance of parent!!!!!
        //probably this request will be subset of event page GET method
        // event_id should be known to client -> will be known when event page will be requested
        // same for parent
    }


}
