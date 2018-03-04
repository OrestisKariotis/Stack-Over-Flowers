package gr.ntua.ece.softeng.kidspiration.Dao;

import gr.ntua.ece.softeng.kidspiration.CurrentEvent;
import gr.ntua.ece.softeng.kidspiration.CurrentEventView;
import gr.ntua.ece.softeng.kidspiration.EventPageView;
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
@Qualifier("CurrentEventDao")
public class CurrentEventDao implements EventDao<CurrentEvent> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //java.sql.Date sDate = new java.sql.Date(utilDate.getTime());

    public void addEvent(CurrentEvent event) {    // OK
        System.out.println("Entering CurrentEvent Dao");
        jdbcTemplate.update("INSERT INTO CurrentEvents (provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, available_ticketsNumber, lowestAge, highestAge, latitude, longitude, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                event.getProvider_id(), event.getTitle(), event.getDate(), event.getStarting_time(), event.getPlace(), event.getCategories(), event.getTicket_cost(), event.getInitial_ticketsNumber(), event.getAvailable_ticketsNumber(), event.getLowestAge(), event.getHighestAge(), event.getLatitude(), event.getlongitude(), event.getDescription());
        System.out.println("CurrentEvent Added!!");
    }

    public void editEvent(CurrentEvent event, int event_id) {  //checking
        System.out.println("Entering CurrentEvent base for edit");
        jdbcTemplate.update("UPDATE CurrentEvents SET  title = ?, date = ?, starting_time = ?, place = ?, type = ?, ticket_cost = ?, initial_ticketsNumber = ?, available_ticketsNumber = ?, lowestAge = ?, highestAge = ?, longitude = ?, latitude = ?, description = ? WHERE event_id = ? ",
               event.getTitle() , event.getDate(), event.getStarting_time(), event.getPlace(), event.getCategories(), event.getTicket_cost(), event.getInitial_ticketsNumber(), event.getAvailable_ticketsNumber(), event.getLowestAge(), event.getHighestAge(), event.getlongitude(), event.getLatitude(), event.getDescription(), event_id);
        System.out.println("CurrentEvent Base edited!!");

        //event_id can be omitted, already included in event object
    }

    public void deleteEvent(int id) {  //not checked, to be checked
        System.out.println("Now we delete!");
        jdbcTemplate.update("DELETE  FROM CurrentEvents WHERE event_id = ? ", id);
    }

    public CurrentEvent find(int id) {   // OK
        System.out.println("Entering CurrentEvent Base for search");
        CurrentEvent event = jdbcTemplate.queryForObject("SELECT * FROM CurrentEvents where event_id = ? ",
                new Object[] { id }, new CurrentEventMapper());

        System.out.println("CurrentEvent Base search done");
        //probably can change to list

        return event;
    }

    public List<CurrentEvent> findAllByProvider(int id) {
        List<CurrentEvent> events=jdbcTemplate.query("SELECT * FROM CurrentEvents where provider_id= ?",
                new Object[] { id }, new CurrentEventMapper());
        return events;
    }

    public List<CurrentEventView> findWithProvider(int id) {  // checking
        List<CurrentEventView> events = jdbcTemplate.query("SELECT * FROM CurrentEvents where provider_id = ? ",
                new Object[] { id }, new CurrentEventViewMapper());
        return events;
    }

    public List<CurrentEvent> findWithDate(Date date) {  //checking
        System.out.println(date);
        List <CurrentEvent> currentEvents = jdbcTemplate.query("SELECT * FROM CurrentEvents WHERE date = ? ",
                new Object[] { date }, new CurrentEventMapper());
        System.out.println(currentEvents.size());
        return currentEvents;
    }

    public CurrentEvent findId(int provider_id, String title, Date date) {
        List <CurrentEvent> events = jdbcTemplate.query("SELECT * FROM CurrentEvents WHERE (provider_id = ? AND title = ? AND  date = ?) ORDER BY event_id DESC LIMIT 1",
                new Object[] { provider_id, title, date }, new CurrentEventMapper());

        return events.size() > 0 ? events.get(0) : null;
    }

    public List<CurrentEvent> findAll() {    // OK
        List < CurrentEvent > events = jdbcTemplate.query("SELECT * FROM CurrentEvents", new CurrentEventMapper());
        return events;
    }

    public List<CurrentEventView> findLatest() {
        List <CurrentEventView> events =  jdbcTemplate.query("SELECT event_id, title, date, starting_time, type, ticket_cost, latitude, longitude, description FROM CurrentEvents ORDER BY event_id DESC LIMIT 6", new CurrentEventViewMapper());
        return events;
    }

    public EventPageView findEventPage(int id) {
        List <EventPageView> events = jdbcTemplate.query("select event_id, provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, available_ticketsNumber, lowestAge, highestAge, latitude, longitude, description, businessName from ((SELECT * FROM currentevents WHERE event_id = ?) sub INNER JOIN providers ON sub.provider_id = providers.id)",
                new Object[] {id}, new EventPageViewMapper());  // Group By would be a nice choice
        return events.size() > 0 ? events.get(0) : null;
    }

    public List<EventPageView> findAllEventPages() {
        List <EventPageView> events = jdbcTemplate.query("select event_id, provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, available_ticketsNumber, lowestAge, highestAge, latitude, longitude, description, businessName from ((SELECT * FROM currentevents) sub INNER JOIN providers ON sub.provider_id = providers.id)",
                new EventPageViewMapper());  // Group By would be a nice choice
        return events;
    }

    public void updateNumberOfTickets(int id, int count) { //checked
        System.out.println("Changing number of tickets");
        jdbcTemplate.update("UPDATE CurrentEvents SET  available_ticketsNumber = ? WHERE event_id = ? ", count, id);
        System.out.println("Changed number of tickets!!");
    }

    class CurrentEventMapper implements RowMapper<CurrentEvent> {

        public CurrentEvent mapRow(ResultSet rs, int rowNum) throws SQLException {

            int event_id = rs.getInt("event_id");
            int provider_id = rs.getInt("provider_id");
            String title = rs.getString("title");
            Date date = rs.getDate("date");
            String starting_time = rs.getString("starting_time");
            String place = rs.getString("place");
            String type = rs.getString("type");

            int ticket_cost = rs.getInt("ticket_cost");
            int initial_ticketsNumber = rs.getInt("initial_ticketsNumber");
            int available_ticketsNumber = rs.getInt("available_ticketsNumber");
            byte lowestAge = rs.getByte("lowestAge");
            byte highestAge = rs.getByte("highestAge");
            double latitude = rs.getDouble("latitude");
            double longitude = rs.getDouble("longitude");
            String description = rs.getString("description");

            CurrentEvent event = new CurrentEvent(event_id, provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, lowestAge, highestAge, description, available_ticketsNumber, latitude, longitude);

            return event;
        }
    }

    public class CurrentEventViewMapper implements RowMapper<CurrentEventView> {

        public CurrentEventView mapRow(ResultSet rs, int rowNum) throws SQLException {

            int event_id = rs.getInt("event_id");
            String title = rs.getString("title");
            Date date = rs.getDate("date");
            String starting_time = rs.getString("starting_time");
            String type = rs.getString("type");
            int ticket_cost = rs.getInt("ticket_cost");
            String description = rs.getString("description");
            double latitude = rs.getDouble("latitude");
            double longitude = rs.getDouble("longitude");
            CurrentEventView event = new CurrentEventView(event_id, title, date, starting_time, type, ticket_cost, latitude, longitude, description);
            return event;
        }
    }

    class EventPageViewMapper implements RowMapper<EventPageView> {

        public EventPageView mapRow(ResultSet rs, int rowNum) throws SQLException {

            int event_id = rs.getInt("event_id");
            int provider_id = rs.getInt("provider_id");
            String title = rs.getString("title");
            Date date = rs.getDate("date");
            String starting_time = rs.getString("starting_time");
            String place = rs.getString("place");
            String type = rs.getString("type");

            int ticket_cost = rs.getInt("ticket_cost");
            int initial_ticketsNumber = rs.getInt("initial_ticketsNumber");
            int available_ticketsNumber = rs.getInt("available_ticketsNumber");
            byte lowestAge = rs.getByte("lowestAge");
            byte highestAge = rs.getByte("highestAge");
            double latitude = rs.getDouble("latitude");
            double longitude = rs.getDouble("longitude");
            String description = rs.getString("description");

            String businessName = rs.getString("businessName");

            EventPageView event = new EventPageView(event_id, provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, lowestAge, highestAge, description, available_ticketsNumber, latitude, longitude, businessName);
            return event;
        }
    }
}

