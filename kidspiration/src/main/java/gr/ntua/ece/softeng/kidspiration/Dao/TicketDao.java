package gr.ntua.ece.softeng.kidspiration.Dao;

import gr.ntua.ece.softeng.kidspiration.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("TicketDao")
public class TicketDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void AddTicket(Ticket ticket){  // may change to a batch update!
        System.out.println("Entering Ticket Base");
        jdbcTemplate.update("INSERT INTO Tickets (parent_id, event_id) VALUES (?, ?)",
                ticket.getParentId(), ticket.getEventId());
        System.out.println("Ticket Base Query Executed!!");
    }

    // Probably more methods will be inserted later. Interface could be a choice.
}
