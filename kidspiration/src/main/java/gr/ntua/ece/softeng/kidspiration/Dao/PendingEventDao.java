package gr.ntua.ece.softeng.kidspiration.Dao;

import com.sun.prism.shader.Solid_ImagePattern_Loader;
import gr.ntua.ece.softeng.kidspiration.PendingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Qualifier("PendingEventDao")
public class PendingEventDao implements EventDao<PendingEvent> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addEvent(PendingEvent event) {  //checked
        System.out.println("Entering Event Dao");
        jdbcTemplate.update("INSERT INTO PendingEvents (provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, lowestAge, highestAge, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                event.getProvider_id(), event.getTitle(), event.getDate(), event.getStarting_time(), event.getPlace(), event.getType(), event.getTicket_cost(), event.getInitial_ticketsNumber(), event.getLowestAge(), event.getHighestAge(), event.getDescription());
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
        System.out.println("User Updated!!");
    }

    public void deleteEvent(int id) { //not checked
        jdbcTemplate.update("DELETE FROM Parents WHERE username = ? ", id);
        System.out.println("Person Deleted!!");
    }

    public PendingEvent find(int id) {  // not checked
        PendingEvent user = (PendingEvent) jdbcTemplate.queryForObject("SELECT * FROM PendingEvents where username = ? ",
                new Object[] { id }, new BeanPropertyRowMapper(PendingEvent.class));

        return user;
    }

    public List <PendingEvent> findAll() { //not ckecked
        List < PendingEvent > users = jdbcTemplate.query("SELECT * FROM Parents", new BeanPropertyRowMapper(PendingEvent.class));
        return users;
    }

    /* class ParentMapper implements RowMapper<PendingEvent> {

        public PendingEvent mapRow(ResultSet rs, int rowNum) throws SQLException {

            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            int wallet = rs.getInt("wallet");
            int spent_points = rs.getInt("spent_points");
            boolean ban= rs.getBoolean("ban");
            PendingEvent parent = new PendingEvent(id, username, password, firstname, lastname, email, phone, wallet, spent_points, ban);

            return parent;
        }
    } */
}
