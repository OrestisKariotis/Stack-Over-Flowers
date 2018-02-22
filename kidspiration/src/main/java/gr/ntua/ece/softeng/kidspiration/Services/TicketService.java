package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.Dao.TicketDao;
import gr.ntua.ece.softeng.kidspiration.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("TicketService")
public class TicketService {

    @Autowired
    TicketDao ticketDao;

    public void addTickets (int parent_id, int event_id, int tickets_number) { // arguments may change
        System.out.println("Entering Ticket Service");
        int i;
        Ticket ticket = new Ticket(0,parent_id, event_id);
        for (i = 0; i < tickets_number; i++)
            ticketDao.AddTicket(ticket);
        System.out.println("Leaving Ticket Service");
    }
}
