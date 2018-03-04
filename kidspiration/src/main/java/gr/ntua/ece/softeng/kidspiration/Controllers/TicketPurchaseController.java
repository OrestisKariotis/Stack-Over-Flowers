package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.CurrentEvent;
import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.PurchaseView;
import gr.ntua.ece.softeng.kidspiration.Services.*;
import gr.ntua.ece.softeng.kidspiration.PurchaseTicketInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/api/purchase_tickets/{event_id}", method = RequestMethod.POST) // POST method
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ResponseEntity<?> PurchaseTickets(@PathVariable String event_id, @RequestBody PurchaseTicketInfo info) {

        System.out.println("ENTER");

        info.setEvent_id(Integer.parseInt(event_id));
        int tickets = info.getTicketsNumber();

        Parent parent = parentService.find(info.getId());  //could be put inside Services
        CurrentEvent event = eventService.find(info.getEvent_id());  // could be put inside services

        // should get Event Object DEFENITELY, frontend maybe have an incosistent instance of it

        if (tickets > event.getAvailable_ticketsNumber())  // could be checked in frontend, tickets > 0!!! /* Or could be checked in the service. *** */
            return ResponseEntity.badRequest().body("Number of tickets requested exceed available tickets number");
        else if (parent.getWallet() < tickets*event.getTicket_cost())  // could be checked in frontend, or NOT?
            return ResponseEntity.badRequest().body("Your wallet is not enough for purchasing requested tickets");
        // + elegxos gia wraaaaaaa /* Implemented yet? *** */
        else {
            eventService.buyTickets(event, tickets, info.getEvent_id());
            ticketService.addTickets(info.getId(), info.getEvent_id(), tickets);
            parentService.decreasePoints(parent, tickets * event.getTicket_cost());
        }
        // UNLOCK, SEE @Transactional in Spring
        // EMAIL NOTIFICATION
        PurchaseView purchase_return = new PurchaseView(info.getId(), parent.getWallet());
        System.out.println("LEAVING");
        return ResponseEntity.accepted().body(purchase_return);
    }


}
