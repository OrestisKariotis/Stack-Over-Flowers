package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.Services.OldTicketService;
import gr.ntua.ece.softeng.kidspiration.Services.ParentService;
import gr.ntua.ece.softeng.kidspiration.Services.TicketService;
import gr.ntua.ece.softeng.kidspiration.TicketView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/profile/parent") //path could be parametric to parent_id
public class ParentProfileController {

    @Autowired
    TicketService ticketService;

    @Autowired
    OldTicketService oldTicketService;

    @Autowired
    ParentService parentService;

    @RequestMapping(path = "/tickets", method = RequestMethod.GET)
    public List<TicketView> ParentProfile_Tickets(@RequestParam String id) {  //parameters may change  // OK

        // show tickets
        return ticketService.findAll_byParentId_TicketView(Integer.parseInt(id));
    }

    @RequestMapping(path = "/old_tickets", method = RequestMethod.GET)  // NOT checked for not empty list  // OK
    public List<TicketView> ParentProfile_OldTickets(@RequestParam String id) {

        //show old tickets
        return oldTicketService.findAl_ByParentId_TicketView(Integer.parseInt(id));
    }

    @RequestMapping(path = "/personal_info", method = RequestMethod.GET)   // OK
    public Parent ParentProfile_PersonalInfo(@RequestParam String id) {  // maybe frontend has already information
        return parentService.find(Integer.parseInt(id));
    }

    @RequestMapping(path = "/personal_info/edit", method = RequestMethod.GET) // POST  method!!!   CHECKING
    public Parent ParentProfile_PersonalInfoEdit(@RequestParam String id, @RequestParam String username, @RequestParam String password, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String phone, @RequestParam String wallet, @RequestParam String spent_points, @RequestParam String ban) {
            //if not all parameters can change, then Parent object sending is redundant. Later, we 'll use JSON commands
            //to get only the things that are about to change, find will be needed then to get Parent Object or a new more reduced editUser
        Parent parent = new Parent(Integer.parseInt(id), username, password, firstname, lastname, email, phone, Integer.parseInt(wallet), Integer.parseInt(spent_points), Boolean.parseBoolean(ban));
        // Need to know what can we change and what not. These will be passed to EditUser
        parentService.editUser(parent, Integer.parseInt(id));
        return parent;
    }
}