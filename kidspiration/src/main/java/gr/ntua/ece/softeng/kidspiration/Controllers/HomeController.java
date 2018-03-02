package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.CurrentEvent;
import gr.ntua.ece.softeng.kidspiration.CurrentEventView;
import gr.ntua.ece.softeng.kidspiration.Services.CurrentEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/home", method = RequestMethod.GET)
public class HomeController {

    @Autowired
    CurrentEventService currentEventService;

    public List<CurrentEventView> ShowLatestEvents() {
        return currentEventService.findLatest();
    }
}
