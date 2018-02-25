package gr.ntua.ece.softeng.kidspiration.Dao;

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

    public List<TicketView> findAll_ByParentId_TicketView (int id) { //checked
        System.out.println("Entering Old Tickets Search by Parent id");
        List <TicketView> tickets = jdbcTemplate.query("SELECT sub.ticket_id, sub.parent_id, sub.event_id, CurrentEvents.title, Providers.businessName, CurrentEvents.date, CurrentEvents.ticket_cost FROM (((SELECT * FROM OldTickets WHERE OldTickets.parent_id = ?) sub INNER JOIN CurrentEvents ON sub.event_id = CurrentEvents.event_id) INNER JOIN Providers ON CurrentEvents.provider_id = Providers.id)",
                new Object[] {id}, new TicketDao.TicketViewMapper());  // Group By would be a nice choie
        System.out.println("Leaving Old Tickets Search by Parent Id");

        return tickets;
        //TicketView may change, parent_id is not needed
    }

}
