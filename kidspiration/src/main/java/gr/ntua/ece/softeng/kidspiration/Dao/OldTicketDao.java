package gr.ntua.ece.softeng.kidspiration.Dao;

import gr.ntua.ece.softeng.kidspiration.Ticket;
import gr.ntua.ece.softeng.kidspiration.TicketView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("OldTicketDao")
public class OldTicketDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<TicketView> findAll_ByParentId_TicketView (int id) { // OK
        System.out.println("Entering Old Tickets Search by Parent id");
        List <TicketView> tickets = jdbcTemplate.query("SELECT sub.ticket_id, sub.parent_id, sub.event_id, OldEvents.title, Providers.businessName, OldEvents.date, OldEvents.ticket_cost FROM (((SELECT * FROM OldTickets WHERE OldTickets.parent_id = ?) sub INNER JOIN OldEvents ON sub.event_id = OldEvents.event_id) INNER JOIN Providers ON OldEvents.provider_id = Providers.id)",
                new Object[] {id}, new TicketDao.TicketViewMapper());  // Group By would be a nice choie
        System.out.println("Leaving Old Tickets Search by Parent Id");

        return tickets;
        //TicketView may change, parent_id is not needed
    }

    public void addOldTicket(Ticket ticket, int id){  //checking
        System.out.println("Entering OldTicket Base");
        jdbcTemplate.update("INSERT INTO OldTickets (parent_id, event_id) VALUES (?, ?)",
                ticket.getParentId(), id);
        System.out.println("OldTicket Base Query Executed!!");
        System.out.println("Renewed ticketId");
    }
}
