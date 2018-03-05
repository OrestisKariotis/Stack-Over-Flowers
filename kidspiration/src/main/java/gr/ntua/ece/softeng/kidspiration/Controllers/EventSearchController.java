package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.*;
import org.elasticsearch.search.SearchHit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.pipe.RegionSpanIterator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static gr.ntua.ece.softeng.kidspiration.Services.GeocodingService.geocodingService;

@RestController
public class EventSearchController {
/*
    @RequestMapping(path = "/api/events_search_delete", method = RequestMethod.GET)
    public  void delete() {

        Elastic leplak = new Elastic();

        leplak.setup("localhost", 9200, "kids3"); // kanei to set up to server

        try {
            List<String> ids = leplak.searchIdsToDelee("2018-04-05");
            leplak.bulkedDelete(ids);
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
    */

/*    @RequestMapping(path = "/api/events_search_insert", method = RequestMethod.GET)
    public String insert() {

        Elastic leplak = new Elastic();

        leplak.setup("localhost", 9200, "kids3"); // kanei to set up to server

        Location pagrati = new Location(37.965740,23.751456);//location

        List<String> tags0= new ArrayList() ; //ta taagas gia ton event

        tags0.add("πεπ");

        Event2 event21 = new Event2(12, "παπια", "2018-04-06", "ποδοσφαιρο", 10, pagrati, "μπαλα και τραμπαλα", 0, 10, "11:30");
        Event2 event22 = new Event2(13, "ντοματα", "2018-04-06", "αθλημα", 10, pagrati, "παιδια", 0, 10, "11:30");


        //leplak.add2(event);
        leplak.add(event21); //stamataw add na dokimasw delete
        leplak.add(event22);

        return "Default event added";
    }*/

    @RequestMapping(path = "/api/events_search", method = RequestMethod.POST)
    public List<Map<String, Object>> search(@RequestBody EventSearchInfo info) {

        Elastic leplak = new Elastic();

        leplak.setup("localhost", 9200, "kids10"); // kanei to set up to server

        List<Map<String, Object>> res;

        Geocoding geocodedCoordinates = geocodingService(info.getFromLoc());  // CHECK IF OK
        Location location = new Location(geocodedCoordinates.getLat(), geocodedCoordinates.getLng());
        System.out.println("Coordinates of event \"" + "\" were set to (" + geocodedCoordinates.getLat() + ", " + geocodedCoordinates.getLng() + ").\n");

        //List<String> tags = new ArrayList<>();
        // PROSOXH STO STRING DATES, AYTO PERIMENOUME
        res = leplak.search(info.getDescription(), info.getCategories(), info.getDistanceInKm(), location, 0, 50, info.getAge(), info.getUpperCost(), info.getLowerCost(), info.getDateUpper(), info.getDateLower());
        //res = leplak.search("παιδια και μπαλα και ντοματα",null, null, null, 0, 50, null, null, null, null, null);
        return res;
        //return ResponseEntity.accepted().body(res);
    }
}
