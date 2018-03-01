package gr.ntua.ece.softeng.kidspiration;

import java.util.Date;

public class CurrentEventView {  // could extend Event Class. Only initial_tickets is missing
    private int event_id;
    private int provider_id; // probably not needed!
    private String title;
    private Date date; //could be date?
    private String starting_time;
    private String place; // place is not given in wireframe
    private String type;
    private int ticket_cost;

    public CurrentEventView(int event_id, int provider_id, String title, Date date, String starting_time, String place, String type, int ticket_cost) {
        this.event_id = event_id;
        this.provider_id = provider_id;
        this.title = title;
        this.date = date;
        this.starting_time = starting_time;
        this.place = place;
        this.type = type;
        this.ticket_cost = ticket_cost;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTicket_cost() {
        return ticket_cost;
    }

    public void setTicket_cost(int ticket_cost) {
        this.ticket_cost = ticket_cost;
    }
}
