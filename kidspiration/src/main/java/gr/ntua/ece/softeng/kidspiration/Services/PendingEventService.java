package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.Dao.PendingEventDao;
import gr.ntua.ece.softeng.kidspiration.PendingEvent;
import gr.ntua.ece.softeng.kidspiration.PendingEventView;
import gr.ntua.ece.softeng.kidspiration.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import gr.ntua.ece.softeng.kidspiration.CurrentEventView;

import java.util.List;

@Service
@Qualifier("PendingEventService")
public class PendingEventService implements EventService<PendingEvent> {

    @Autowired
    PendingEventDao pendingEventDao;

    public void addEvent(PendingEvent event) {  //checked
        System.out.println("Entering Event Service");
        pendingEventDao.addEvent(event);
    }

    public void editEvent(PendingEvent event, int id) {

    }

    public List<PendingEvent> findWithProvider(int id) {
        List<PendingEvent> pendingEvents= pendingEventDao.findWithProvider(id);
        return pendingEvents;
    }

    public void deleteEvent(int id) { //checked
        pendingEventDao.deleteEvent(id);
    } // OK

    public PendingEvent find(int id) {  //checked
        return pendingEventDao.find(id);
    } //OK

    public List<PendingEventView> findAllPendingEventViews() { return  pendingEventDao.findAllPendingEventViews();}

    public List<PendingEvent> findAll() {  //checked
        return pendingEventDao.findAll();
    } // OK

}
