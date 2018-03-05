package gr.ntua.ece.softeng.kidspiration.Dao;

import gr.ntua.ece.softeng.kidspiration.Ticket;
import gr.ntua.ece.softeng.kidspiration.TicketView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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

    /*public List<Provider> findAll() {
        List < Provider > users = jdbcTemplate.query("SELECT * FROM PendingProviders", new BeanPropertyRowMapper(User.class));
        return users;
    } */

    public List<TicketView> findAll_ByParentId_TicketView (int id) { // OK
        System.out.println("Entering Tickets Search by Parent id");
        List <TicketView> tickets = jdbcTemplate.query("SELECT sub.ticket_id, sub.parent_id, sub.event_id, CurrentEvents.title, Providers.businessName, CurrentEvents.date, CurrentEvents.ticket_cost FROM (((SELECT * FROM Tickets WHERE Tickets.parent_id = ?) sub INNER JOIN CurrentEvents ON sub.event_id = CurrentEvents.event_id) INNER JOIN Providers ON CurrentEvents.provider_id = Providers.id)",
                new Object[] {id}, new TicketViewMapper());  // Group By would be a nice choice
        System.out.println("Leaving Tickets Search by Parent Id");

        return tickets;
        //TicketView may change, parent_id is not needed
    }

    public List<Ticket> findByEvent(int id){  //checking
        List <Ticket> tickets = jdbcTemplate.query("SELECT * FROM Tickets WHERE event_id = ?", new Object[] {id}, new TicketMapper());
        return tickets;
    }

    public List<Ticket> findTickets(int id, int event_id) {
        List<Ticket> tickets = jdbcTemplate.query("SELECT * FROM Tickets WHERE (parent_id = ? AND event_id = ?)", new Object[] {id, event_id}, new TicketMapper());
        return tickets;
    }

    static class TicketMapper implements RowMapper<Ticket> {  // Defined static for use in OldTicketDao  //checking

        public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {

            int ticket_id = rs.getInt("ticket_id");
            int parent_id = rs.getInt("parent_id");
            int event_id = rs.getInt("event_id");
            Ticket ticket = new Ticket(ticket_id, parent_id, event_id);

            return ticket;
        }
    }
    // Probably more methods will be inserted later. Interface could be a choice.


    static class TicketViewMapper implements RowMapper<TicketView> {  // Defined static for use in OldTicketDao

        public TicketView mapRow(ResultSet rs, int rowNum) throws SQLException {

            int ticket_id = rs.getInt("ticket_id");
            int parent_id = rs.getInt("parent_id");
            int event_id = rs.getInt("event_id");
            String title = rs.getString("title");
            String businessName = rs.getString("businessName");
            Date date = rs.getDate("date");
            int ticket_cost = rs.getInt("ticket_cost");
            TicketView ticket = new TicketView(ticket_id, parent_id, event_id, title, businessName, date, ticket_cost);

            return ticket;
        }
    }

    // Probably more methods will be inserted later. Interface could be a choice.
}
