package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.Dao.OldEventDao;
import gr.ntua.ece.softeng.kidspiration.OldEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
//import java.util.Calendar;

@Service
@Qualifier("OldEventService")
public class OldEventService implements EventService<OldEvent> {   /// CHECKING

    @Autowired
    OldEventDao oldEventDao;

    public void addEvent(OldEvent event){}

    public int addOldEvent(OldEvent event) {
       return oldEventDao.addOldEvent(event);
    }

    public void editEvent(OldEvent event, int id){}


    public void deleteEvent(int id) { oldEventDao.deleteEvent(id); }

    public OldEvent find(int id) {
        return oldEventDao.find(id);
    }

    public List<OldEvent> findWithDate(Date date) {
        return oldEventDao.findWithDate(date);
    }

    public List<OldEvent> findAll() {
        return null;
    }

    public void deleteWithDate(java.sql.Date date){
        oldEventDao.deleteWithDate(date);
    }
}
