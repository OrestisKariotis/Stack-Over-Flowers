package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.Geocoding;
import gr.ntua.ece.softeng.kidspiration.Services.GeocodingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

    /**
     * The controller has to call the service with an appropriate argument.
     * Non-encoded, string address.
     * E.g. "Συβρισσαριου 18 Βυρωνας 16232 Ελλαδα"
     * The different localities of the address can be placed in any order.
     */

    @RestController
    @RequestMapping(path = "/geocoding")
    public class TestingForGeocodingService {

        private GeocodingService geocodingService;

        @RequestMapping(value = "/service")
        public Geocoding testingGeocoding(@RequestParam String address){
            System.out.println("\ngeocodingService will get: \"" + address + "\" as argument.\n");
            Geocoding response = geocodingService.geocodingService(address);    /* make sure "address" is in correct format */
            System.out.println("Response status: \"" + response.getStatus() + "\"\nLatitude: " + response.getLat() + "\nLongtitude: " + response.getLng());
            return response;
        }
    }

