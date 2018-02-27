package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.CurrentEvent;
import gr.ntua.ece.softeng.kidspiration.CurrentEventView;
import gr.ntua.ece.softeng.kidspiration.Dao.CurrentEventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("CurrentEventService")
public class CurrentEventService implements EventService<CurrentEvent> {

    @Autowired
    CurrentEventDao currentEventDao;

    public void buyTickets (CurrentEvent event, int count, int event_id) {  // checked

        System.out.println("Entering CurrentEvent's Buying Tickets Service");

        int available_tickets = event.getAvailable_ticketsNumber();
        event.setAvailable_ticketsNumber(available_tickets - count);
        currentEventDao.updateNumberOfTickets(event_id, available_tickets - count);

        System.out.println("Leaving CurrentEvent's Buying Tickets Service");
    }

    public void addEvent(CurrentEvent event) { //checked
        currentEventDao.addEvent(event);
    }

    public void editEvent(CurrentEvent event, int id) {

    }

    public void deleteEvent(int id) {

    }

    public CurrentEvent find(int id) {
        return currentEventDao.find(id);
    } //checking

    public List<CurrentEventView> findAllViews_ByProviderId(int id) {
       return null;
    }

    public List<CurrentEvent> findAll() { //checked

        return currentEventDao.findAll();
    }
}
