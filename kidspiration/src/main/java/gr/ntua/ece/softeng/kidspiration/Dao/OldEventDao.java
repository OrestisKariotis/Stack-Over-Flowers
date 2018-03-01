package gr.ntua.ece.softeng.kidspiration.Dao;

import gr.ntua.ece.softeng.kidspiration.OldEvent;
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
@Qualifier("OldEventDao")
public class OldEventDao implements EventDao<OldEvent> { // CHECKING

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addEvent(OldEvent event){}

    public int addOldEvent(OldEvent event) {
        System.out.println("Now we add the event to the list of old events!");
        jdbcTemplate.update("INSERT INTO OldEvents (event_id, provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, sold_ticketsNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                event.getEvent_id(), event.getProvider_id(), event.getTitle(), event.getDate(), event.getStarting_time(), event.getPlace(), event.getType(), event.getTicket_cost(), event.getInitial_ticketsNumber(), event.getSold_ticketsNumber());
        //OldEvent temp =  jdbcTemplate.queryForObject("SELECT * FROM OldEvents WHERE event_id = (SELECT MAX(event_id) FROM kidspiration..oldevents)", new OldEventMapper());
        OldEvent temp =  jdbcTemplate.queryForObject("SELECT * FROM OldEvents ORDER BY event_id DESC LIMIT 1", new OldEventMapper());
        return temp.getEvent_id();
    }

    public void editEvent(OldEvent event, int event_id) {  //checking
        System.out.println("Entering CurrentEvent base for edit");
        jdbcTemplate.update("UPDATE OldEvents SET  title = ?, date = ?, starting_time = ?, place = ?, type = ?, ticket_cost = ?, initial_ticketsNumber = ?, sold_ticketsNumber = ? WHERE event_id = ? ",
                event.getTitle() , event.getDate(), event.getStarting_time(), event.getPlace(), event.getType(), event.getTicket_cost(), event.getInitial_ticketsNumber(), event.getSold_ticketsNumber(), event_id);
        System.out.println("CurrentEvent Base edited!!");

        //event_id can be omitted, already included in event object
    }

    public void deleteEvent(int id) {  //not checked
        jdbcTemplate.update("DELETE FROM OldEvents WHERE event_id = ?", id);
    }

    public void deleteWithDate(java.sql.Date date){
        jdbcTemplate.update("DELETE FROM OldEvents WHERE date = ?", date);
    }

    public OldEvent find(int id) {   // checking
        return null;
    }

    public List<OldEvent> findWithDate(Date date) {

        return null;
    }

    public List<OldEvent> findAll() {    //not checked
        return null;
    }

    class OldEventMapper implements RowMapper<OldEvent> {

        public OldEvent mapRow(ResultSet rs, int rowNum) throws SQLException {

            int event_id = rs.getInt("event_id");
            int provider_id = rs.getInt("provider_id");
            String name = rs.getString("title");
            Date date = rs.getDate("date");
            String starting_time = rs.getString("starting_time");
            String place = rs.getString("place");
            String type = rs.getString("type");

            int ticket_cost = rs.getInt("ticket_cost");
            int initial_ticketsNumber = rs.getInt("initial_ticketsNumber");
            int sold_ticketsNumber= rs.getInt("sold_ticketsNumber");

            OldEvent event = new OldEvent(event_id, provider_id, name, date, starting_time, place, type, ticket_cost, initial_ticketsNumber,sold_ticketsNumber);

            return event;
        }
    }
}