package gr.ntua.ece.softeng.kidspiration;

import java.util.Date;

public class CurrentEvent extends PendingEvent {

    private int available_ticketsNumber;
    private double latitude;
    private double longitude;

    public CurrentEvent(int event_id, int provider_id, String title, Date date, String starting_time, String place, String type, int ticket_cost, int initial_ticketsNumber, byte lowestAge, byte highestAge, String description, int numOfPhotos, int available_ticketsNumber, double latitude, double longitude) {
        super(event_id, provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, lowestAge, highestAge, description, numOfPhotos);
        this.available_ticketsNumber = available_ticketsNumber;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getAvailable_ticketsNumber() {
        return available_ticketsNumber;
    }

    public void setAvailable_ticketsNumber(int available_ticketsNumber) {
        this.available_ticketsNumber = available_ticketsNumber;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getlongitude() {
        return longitude;
    }

    public void setlongitude(double longitude) {
        this.longitude = longitude;
    }
}