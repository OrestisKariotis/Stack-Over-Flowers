package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.*;

/**
 * Our Google Geocoding API key:
 * AIzaSyBRhF66pYVCc_C2km3tvIxt-pp7Ae6Gjw4
 */


public class GeocodingService {

    /* Google almost always returns an answer with coordinates.
       The idea is an administrator checks the pending event's address
       before approving it and may thus request a request a resubmission.

       Also, in the case of event searching, the problem -if existent-
       is visible to the user via the front-end's map and as such
       can be easily understood and resolved.
     */
    public static Geocoding geocodingService(String address) {
        /* receive the whole json response */
        GeoCoordinates coordinates = Geocoding.findCoordinates(address);
        System.out.println("error message is: " + coordinates.error_message + "\n");

        /**         // Code displaying the full, geocoded address.
         if (coordinates != null && coordinates.isValid()) {
         System.out.println("Street Address:" + address);
         System.out.println("Formatted Address: " + coordinates.getFormattedAddress());
         System.out.println("Latitude: " + coordinates.getLatitude());
         System.out.println("Longitude: " + coordinates.getLongitude());
         System.out.println("\nHoly fucking guacamole, I think it fuckably worked!\n");
         } else {
         System.out.println("Error: findCoordinates failed for address: " + address);
         System.out.println("\nHoly fucking shit I wanna kill somebody. \n");
         }
         */

        /* returns response */
        if (coordinates.isValid())
            return new Geocoding(coordinates.getLatitude(), coordinates.getLongitude(), "OK");
        else
            return new Geocoding(0,0, "Geocoding Failed");
    }
}