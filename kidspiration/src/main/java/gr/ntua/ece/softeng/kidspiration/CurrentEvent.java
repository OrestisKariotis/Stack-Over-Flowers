package gr.ntua.ece.softeng.kidspiration;

public class CurrentEvent extends PendingEvent {

    private int available_ticketsNumber;
    private double longtitude;
    private double latitude;

    public CurrentEvent(int event_id, int provider_id, String title, String date, String starting_time, String place, String type, int ticket_cost, int initial_ticketsNumber, byte lowestAge, byte highestAge, String description, int available_ticketsNumber, double longtitude, double latitude) {
        super(event_id, provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, lowestAge, highestAge, description);
        this.available_ticketsNumber = available_ticketsNumber;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public int getAvailable_ticketsNumber() {
        return available_ticketsNumber;
    }

    public void setAvailable_ticketsNumber(int available_ticketsNumber) {
        this.available_ticketsNumber = available_ticketsNumber;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}