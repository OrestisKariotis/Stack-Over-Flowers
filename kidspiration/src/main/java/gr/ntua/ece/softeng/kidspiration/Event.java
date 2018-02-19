package gr.ntua.ece.softeng.kidspiration;

public class Event {

    private int event_id; // not-initialised
    private int provider_id;
    private String name;
    private String date; //could be date?
    private String starting_time;
    private String place;
    private String type;
    private int ticket_cost;
    private int initial_ticketsNumber;

    public Event(int provider_id, String name, String date, String starting_time, String place, String type, int ticket_cost, int initial_ticketsNumber) {
        this.provider_id = provider_id;
        this.name = name;
        this.date = date;
        this.starting_time = starting_time;
        this.place = place;
        this.type = type;
        this.ticket_cost = ticket_cost;
        this.initial_ticketsNumber = initial_ticketsNumber;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public int getInitial_ticketsNumber() {
        return initial_ticketsNumber;
    }

    public void setInitial_ticketsNumber(int initial_ticketsNumber) {
        this.initial_ticketsNumber = initial_ticketsNumber;
    }
}
