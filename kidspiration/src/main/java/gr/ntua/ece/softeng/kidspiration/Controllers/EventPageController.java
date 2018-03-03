package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.EventPageView;
import gr.ntua.ece.softeng.kidspiration.Services.CurrentEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventPageController {

    @Autowired
    CurrentEventService currentEventService;

    @RequestMapping(path = "/api/events/{event_id}", method = RequestMethod.GET)
    public ResponseEntity<?> Find_EventPage(@PathVariable String event_id) {

        EventPageView event = currentEventService.findEventPage(Integer.parseInt(event_id));
        if (event != null)
            return ResponseEntity.accepted().body(event);
        else
            return ResponseEntity.badRequest().body("Error");
    }
}
