package gr.ntua.ece.softeng.kidspiration.controller;

import gr.ntua.ece.softeng.kidspiration.model.Ticket;
import gr.ntua.ece.softeng.kidspiration.model.CurrentEvent;
import gr.ntua.ece.softeng.kidspiration.model.Parent;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PurchaseTicketController {
    @RequestMapping("/purchase");

    public String PurchaseTicketController(@RequestParam int id_parent, @RequestParam int id_event, @RequestParam int numOfTickets) {
        //search ton parent mesw tou id_parent sth vash
        Parent p= validateParent(id_parent);
        //search to event mesw tou id_event sth vash
        CurrentEvent event=validate(id_event);
        //prwta kanoume sygkrish hmeromhnias kai wras me trexousa gia na doume an ta eisithria einai energa! pws???
        if (event.getTicketsRemainNumber()>=numOfTickets) {
            if (p.getRemain_points()>= (numOfTickets*event.getCost())) {
                int temp= event.getTicketsRemainNumber();
                event.setTicketsRemainNumber(temp-numOfTickets);
                temp= p.getRemain_points();
                p.setRemain_points(temp-(numOfTickets*event.getCost());
                Ticket ticket=new Ticket(id_parent, id_event);
                //enhmerwsh vashs event
                //enhmerwsh vashs parent
                //enhmerwsh vashs ticket
                return "Transaction achieved!! Thank you very much!";
            }
            else {
                return "You do not have enough points for the transaction! Transaction failed!";
            }
        }
        else {
            return "There are only "+event.getTicketsRemainNumber()+" available tickets for this event";
        }
    }
}
