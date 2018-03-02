package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.PurchaseView;
import gr.ntua.ece.softeng.kidspiration.Services.OldTicketService;
import gr.ntua.ece.softeng.kidspiration.Services.ParentService;
import gr.ntua.ece.softeng.kidspiration.Services.TicketService;
import gr.ntua.ece.softeng.kidspiration.TicketView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/profile/parent/{id}") //path could be parametric to parent_id
public class ParentProfileController {

    @Autowired
    TicketService ticketService;

    @Autowired
    OldTicketService oldTicketService;

    @Autowired
    ParentService parentService;

    @RequestMapping(path = "/tickets", method = RequestMethod.GET)
    public List<TicketView> ParentProfile_Tickets(@PathVariable String id) {  //Path Variable  // OK

        // show tickets
        return ticketService.findAll_byParentId_TicketView(Integer.parseInt(id));
    }

    @RequestMapping(path = "/old_tickets", method = RequestMethod.GET)  // NOT checked for not empty list  // OK
    public List<TicketView> ParentProfile_OldTickets(@PathVariable String id) {

        //show old tickets
        return oldTicketService.findAl_ByParentId_TicketView(Integer.parseInt(id));
    }

    @RequestMapping(path = "/personal_info", method = RequestMethod.GET)   // OK
    public PurchaseView ParentProfile_PersonalInfo(@PathVariable String id) {  // maybe frontend has already information

        Parent parent = parentService.find(Integer.parseInt(id));
        PurchaseView view = new PurchaseView(parent.getId(), parent.getWallet());
        return view;
    }

    @RequestMapping(path = "/personal_info/edit", method = RequestMethod.POST) // POST  method!!!   CHECKING
    public String ParentProfile_PersonalInfoEdit(@PathVariable String id, @RequestBody String phone) {

        parentService.editInfo(Integer.parseInt(id) , phone);
        return phone;
    }
}