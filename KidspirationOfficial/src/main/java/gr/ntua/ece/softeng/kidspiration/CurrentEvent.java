package gr.ntua.ece.softeng.kidspiration;

public class CurrentEvent extends Event {

    private int available_ticketsNumber;
    private double longtitude;
    private double latitude;

    public CurrentEvent(int provider_id, String name, String date, String starting_time, String place, String type, int ticket_cost, int initial_ticketsNumber, double longtitude, double latitude) {
        super(provider_id, name, date, starting_time, place, type, ticket_cost, initial_ticketsNumber);
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.available_ticketsNumber = initial_ticketsNumber;
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
