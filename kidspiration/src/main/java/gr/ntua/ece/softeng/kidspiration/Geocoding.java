package gr.ntua.ece.softeng.kidspiration;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Geocoding {
    private double lat = 0;
    private double lng = 0;
    private String status;

    public Geocoding(double lat, double lng, String status) {
        this.lat = lat;
        this.lng = lng;
        this.status = status;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // URL for the Google Maps Geocoding API
    private static final String GEOCODING_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";

    // charset used for encoding the address
    private static final String CHARSET = "UTF-8";

    public static GeoCoordinates findCoordinates(String streetAddress) {
        GeoCoordinates coordinates = null;
        try {
            System.out.println("Trying to find coordinates... \n");
            String jsonResponse = lookupAddress(streetAddress);
            coordinates = new Gson().fromJson(jsonResponse, GeoCoordinates.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coordinates;
    }

    private static String lookupAddress(String address) throws IOException {
        // encode address in a form to pass as part of URL as get request
        String encodedAddress = URLEncoder.encode(address, CHARSET);

        // prepare get request string.
        String ourAPIKey = "AIzaSyBRhF66pYVCc_C2km3tvIxt-pp7Ae6Gjw4"; /* hard-coded API key, maybe change it? *** */

        String httpGetRequest = GEOCODING_URL + encodedAddress + "&key=" + ourAPIKey;
        System.out.println("The following http request will be made: " + httpGetRequest + "\n");

        // perform get request
        URLConnection connection = new URL(httpGetRequest).openConnection();
        connection.setRequestProperty("Accept-Charset", CHARSET);

        // gather and return JSON response as a String
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputReader);

        StringBuffer response = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            response.append(line);
            response.append("\n");
        }

        return response.toString();
    }
}
