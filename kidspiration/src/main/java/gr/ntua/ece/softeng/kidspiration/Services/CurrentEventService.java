package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.*;
import gr.ntua.ece.softeng.kidspiration.Dao.CurrentEventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static gr.ntua.ece.softeng.kidspiration.Services.GeocodingService.geocodingService;

@Service
@Qualifier("CurrentEventService")
public class CurrentEventService {//implements EventService<CurrentEvent> {

    @Autowired
    CurrentEventDao currentEventDao;

    public void buyTickets (CurrentEvent event, int count, int event_id) {  // OK

        System.out.println("Entering CurrentEvent's Buying Tickets Service");

        int available_tickets = event.getAvailable_ticketsNumber();
        event.setAvailable_ticketsNumber(available_tickets - count);
        currentEventDao.updateNumberOfTickets(event_id, available_tickets - count);

        System.out.println("Leaving CurrentEvent's Buying Tickets Service");
    }

    public CurrentEvent addEvent(CurrentEvent event) { //checked /* adding geocoded coords and rechecking */
        Geocoding geocodedCoordinates = geocodingService(event.getPlace());
        event.setLatitude(geocodedCoordinates.getLat());
        event.setlongitude(geocodedCoordinates.getLng());
        System.out.println("Coordinates of event \"" + event.getTitle()
                + "\" were set to (" + geocodedCoordinates.getLat() + ", " + event.getlongitude() + ").\n");
        currentEventDao.addEvent(event);
        return event;
    } // OK

    public void addEventElastic(CurrentEvent event) throws IOException{
        CurrentEvent currentEvent;
        currentEvent =  currentEventDao.findId(event.getProvider_id(), event.getTitle(), event.getDate());
        Location location = new Location(currentEvent.getLatitude(), currentEvent.getlongitude()); //CHECK THINGS
        Elastic leplak = new Elastic();
        leplak.setup("localhost", 9200, "kids3"); // kanei to set up to server
        Event2 event2 = new Event2(currentEvent.getEvent_id(), currentEvent.getTitle(), currentEvent.getDate().toString(), currentEvent.getCategories(), currentEvent.getTicket_cost(), location, currentEvent.getDescription(), currentEvent.getLowestAge(), currentEvent.getHighestAge(), currentEvent.getStarting_time());
        leplak.add(event2);
    }

    public void editEvent(CurrentEvent event, int id) {

    }

    public void deleteEvent(int id) {
        currentEventDao.deleteEvent(id);
    }

    public CurrentEvent find(int id) {
        return currentEventDao.find(id);
    } // OK

    public List<CurrentEventView> findAllViews_ByProviderId(int id) {
       return null;
    }

    public List<CurrentEvent> findWithDate(Date date) {    ///CHECKING
        System.out.println("vres to me vash thn hmeromhnia gamw!!");
        return currentEventDao.findWithDate(date);
    }

    public List<CurrentEventView> findLatest() {
        return currentEventDao.findLatest();
    }

    public EventPageView findEventPage(int id) {
        return currentEventDao.findEventPage(id);
    }

    public List<EventPageView> findAllEventPages() { return  currentEventDao.findAllEventPages();}

    public List<CurrentEvent> findAll() { // OK

        return currentEventDao.findAll();
    }
}
