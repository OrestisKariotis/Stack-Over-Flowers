package gr.ntua.ece.softeng.kidspiration;

import java.util.Date;

public class CurrentEventView {  // could extend Event Class. Only initial_tickets is missing
    private int event_id;
    private String title;
    private Date date;
    private String starting_time;
    private String categories;
    private int ticket_cost;
    private double latitude;
    private double longitude;
    private String description;

    public CurrentEventView(int event_id, String title, Date date, String starting_time, String categories, int ticket_cost, double latitude, double Longitude, String description) {
        this.event_id = event_id;
        this.title = title;
        this.date = date;
        this.starting_time = starting_time;
        this.categories = categories;
        this.ticket_cost = ticket_cost;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStarting_time() {
        return starting_time;
    }

    public void setStarting_time(String starting_time) {
        this.starting_time = starting_time;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public int getTicket_cost() {
        return ticket_cost;
    }

    public void setTicket_cost(int ticket_cost) {
        this.ticket_cost = ticket_cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
