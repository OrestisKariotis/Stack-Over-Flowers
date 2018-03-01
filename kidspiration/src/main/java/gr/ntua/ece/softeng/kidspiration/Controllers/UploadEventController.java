package gr.ntua.ece.softeng.kidspiration.Controllers;

import com.sun.org.apache.xerces.internal.util.ShadowedSymbolTable;
import gr.ntua.ece.softeng.kidspiration.PendingEvent;
import gr.ntua.ece.softeng.kidspiration.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UploadEventController {

    @Autowired
    @Qualifier("PendingEventService")
    EventService eventService;

    @RequestMapping(path = "/upload_event", method = RequestMethod.GET) //will be post method  //Pi8anws na exei kai /id tou Provider
    public PendingEvent Upload_event(@RequestParam String provider_id, @RequestParam String title, @RequestParam String date, @RequestParam String starting_time, @RequestParam String place, @RequestParam String type, @RequestParam String ticket_cost, @RequestParam String initial_ticketsNumber, @RequestParam String lowestAge, @RequestParam String highestAge, @RequestParam String description) {
        System.out.println("Uploading Event Start"); // So far we only get provider_id. Later probably we 'll get the whole Provider Object

        // OK

        /// ADDED, CHECK IF PROBLEMS OCCUR WITH DATE
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        PendingEvent event = null;

        try {
            Date date_format = formatter.parse(date);
            System.out.println(date_format);
            event = new PendingEvent(0, Integer.parseInt(provider_id), title, date_format, starting_time, place, type, Integer.parseInt(ticket_cost), Integer.parseInt(initial_ticketsNumber), Byte.parseByte(lowestAge), Byte.parseByte(highestAge), description);
            eventService.addEvent(event);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        return event;   // Don't forget exeption handling, use Number Format Exception
    }
}