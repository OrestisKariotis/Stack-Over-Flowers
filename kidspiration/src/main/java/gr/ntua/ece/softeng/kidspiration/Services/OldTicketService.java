package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.Dao.OldTicketDao;
import gr.ntua.ece.softeng.kidspiration.Ticket;
import gr.ntua.ece.softeng.kidspiration.TicketView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("OldTicketService")
public class OldTicketService {

    @Autowired
    OldTicketDao oldTicketDao;

    public List <TicketView> findAl_ByParentId_TicketView (int id) { // OK
        return oldTicketDao.findAll_ByParentId_TicketView(id);
    } //checking

    public void addOldTicket(Ticket ticket, int event_id){ oldTicketDao.addOldTicket(ticket, event_id); } //CHECKING
}
