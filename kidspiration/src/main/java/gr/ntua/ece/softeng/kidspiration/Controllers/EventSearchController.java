package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.Elastic;
import gr.ntua.ece.softeng.kidspiration.Event2;
import gr.ntua.ece.softeng.kidspiration.Location;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EventSearchController {

    @RequestMapping(path = "/events_search", method = RequestMethod.GET)
    public  void search() {

        Elastic leplak=new Elastic();

        leplak.setup("localhost", 9200, "kidspiration"); // kanei to set up to server
    }

    @RequestMapping(path = "/events_search_insert", method = RequestMethod.GET)
    public String insert() {

        Elastic leplak = new Elastic();

        leplak.setup("localhost", 9200, "kidspiration"); // kanei to set up to server

        Location pagrati =new Location(37.965740,23.751456);//location

        List<String> tags0= new ArrayList() ; //ta taagas gia ton event

        tags0.add("πεπ");

        Event2 event21=new Event2("ωρεεε", "4-4-2016", tags0, 10, pagrati, "μπαλα για τα παιδια",10);

        //	leplak.add2(event);
        leplak.add(event21); //stamataw add na dokimasw delete

        return "Default event added";
    }

    @RequestMapping(path = "/events_search_delete", method = RequestMethod.GET)
    public  void delete() {
        Elastic leplak=new Elastic();

        leplak.setup("localhost", 9200, "kidspiration"); // kanei to set up to server
    }

}
