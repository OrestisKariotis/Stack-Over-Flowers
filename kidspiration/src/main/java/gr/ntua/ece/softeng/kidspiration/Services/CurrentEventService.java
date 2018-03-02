package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.CurrentEvent;
import gr.ntua.ece.softeng.kidspiration.CurrentEventView;
import gr.ntua.ece.softeng.kidspiration.Dao.CurrentEventDao;
import gr.ntua.ece.softeng.kidspiration.EventPageView;
import gr.ntua.ece.softeng.kidspiration.Geocoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static gr.ntua.ece.softeng.kidspiration.Services.GeocodingService.geocodingService;

@Service
@Qualifier("CurrentEventService")
public class CurrentEventService implements EventService<CurrentEvent> {

    @Autowired
    CurrentEventDao currentEventDao;

    public void buyTickets (CurrentEvent event, int count, int event_id) {  // OK

        System.out.println("Entering CurrentEvent's Buying Tickets Service");

        int available_tickets = event.getAvailable_ticketsNumber();
        event.setAvailable_ticketsNumber(available_tickets - count);
        currentEventDao.updateNumberOfTickets(event_id, available_tickets - count);

        System.out.println("Leaving CurrentEvent's Buying Tickets Service");
    }

    public void addEvent(CurrentEvent event) { //checked /* adding geocoded coords and rechecking */
        Geocoding geocodedCoordinates = geocodingService(event.getPlace());
        event.setLatitude(geocodedCoordinates.getLat());
        event.setlongitude(geocodedCoordinates.getLng());
        System.out.println("Coordinates of event \"" + event.getTitle()
                + "\" were set to (" + geocodedCoordinates.getLat() + ", " + event.getlongitude() + ").\n");
        currentEventDao.addEvent(event);
    } // OK

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

    public List<CurrentEvent> findAll() { // OK

        return currentEventDao.findAll();
    }
}
