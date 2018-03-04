package gr.ntua.ece.softeng.kidspiration.Dao;

import com.sun.prism.shader.Solid_ImagePattern_Loader;
import gr.ntua.ece.softeng.kidspiration.PendingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import gr.ntua.ece.softeng.kidspiration.CurrentEventView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
@Qualifier("PendingEventDao")
public class PendingEventDao implements EventDao<PendingEvent> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addEvent(PendingEvent event) {  //checked
        System.out.println("Entering Event Dao");
        jdbcTemplate.update("INSERT INTO PendingEvents (provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, lowestAge, highestAge, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                event.getProvider_id(), event.getTitle(), event.getDate(), event.getStarting_time(), event.getPlace(), event.getCategories(), event.getTicket_cost(), event.getInitial_ticketsNumber(), event.getLowestAge(), event.getHighestAge(), event.getDescription());
        System.out.println("Event Added!!");
    }

    /* public PendingEvent validateUser(Login login) {
        System.out.println("Entering login");
        List<PendingEvent> parents = jdbcTemplate.query("SELECT * FROM Parents WHERE username = ? AND password = ?",
                new Object[] { login.getUsername(), login.getPassword() }, new ParentDao.ParentMapper());

        System.out.println("Parent checked for login");
        return parents.size() > 0 ? parents.get(0) : null;
    } */

    public void editEvent(PendingEvent user, int id) { // Not checked
        jdbcTemplate.update("UPDATE PendingEvents SET firstname = ? , lastname = ? WHERE event_id = ? ",
                user.getDescription(), user.getDescription(), id);
        System.out.println("Event Updated!!");
    }

    public List<PendingEvent> findWithProvider(int id) {  // checking
        List<PendingEvent> events = jdbcTemplate.query("SELECT * FROM PendingEvents where provider_id = ? ",
                new Object[] { id }, new PendingEventMapper());
        return events;
    }

    public void deleteEvent(int id) { // OK
        jdbcTemplate.update("DELETE FROM PendingEvents WHERE event_id = ? ", id);
        System.out.println("Event Deleted!!");
    }

    public PendingEvent find(int id) {  // OK
        PendingEvent user = jdbcTemplate.queryForObject("SELECT * FROM PendingEvents where event_id = ? ",
                new Object[] { id }, new PendingEventMapper());
        // could be a list
        return user;
    }

    public List <PendingEvent> findAll() { // OK
        List < PendingEvent > events = jdbcTemplate.query("SELECT * FROM PendingEvents", new PendingEventMapper());
        return events;
    }

    class PendingEventMapper implements RowMapper<PendingEvent> {

        public PendingEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
            int event_id = rs.getInt("event_id");
            int provider_id = rs.getInt("provider_id");
            String title = rs.getString("title");
            Date date = rs.getDate("date");
            String starting_time = rs.getString("starting_time");
            String place = rs.getString("place");
            String type = rs.getString("type");
            int ticket_cost = rs.getInt("ticket_cost");
            int initial_ticketsNumber = rs.getInt("initial_ticketsNumber");
            byte lowestAge = rs.getByte("lowestAge");
            byte highestAge = rs.getByte("highestAge");
            String description = rs.getString("description");
            PendingEvent pendingEvent = new PendingEvent(event_id, provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, lowestAge, highestAge, description);
            return pendingEvent;
        }

    }

}
