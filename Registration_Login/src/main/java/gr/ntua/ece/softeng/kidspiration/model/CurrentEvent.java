package gr.ntua.ece.softeng.kidspiration.model;

public class CurrentEvent {
    private int id_event;
    private int id_provider;
    private String eventName;
    private String date;
    private String time;
    //private String place; afou tha exoume geografiko platos kai gewgrafiko ypsos
    private int lowestAge;
    private int highestAge;
    private String kind;
    private int cost;
    private int ticketsRemainNumber;
    private int ticketsStartingNumber;
    private double geographicLength;
    private double geoGeographicWidth;
    //perigrafh eleutherou keimenou???

    public CurrentEvent(int id_provider, String eventName, String date, String time, int lowestAge, int highestAge, String kind, int cost, int ticketsNumber, double geographicLength, double geoGeographicWidth) {
        this.id_event=??????// pws pairnei timh to id tou event????????
        this.id_provider = id_provider;
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.lowestAge = lowestAge;
        this.highestAge = highestAge;
        this.kind = kind;
        this.cost = cost;
        this.ticketsRemainNumber = ticketsNumber;
        this.ticketsStartingNumber=ticketsNumber;
        this.geographicLength=geographicLength;
        this.geoGeographicWidth=geoGeographicWidth;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_provider() {
        return id_provider;
    }

    public void setId_provider(int id_provider) {
        this.id_provider = id_provider;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLowestAge() {
        return lowestAge;
    }

    public void setLowestAge(int lowestAge) {
        this.lowestAge = lowestAge;
    }

    public int getHighestAge() {
        return highestAge;
    }

    public void setHighestAge(int highestAge) {
        this.highestAge = highestAge;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTicketsRemainNumber() {
        return ticketsRemainNumber;
    }

    public void setTicketsRemainNumber(int ticketsRemainNumber) {
        this.ticketsRemainNumber = ticketsRemainNumber;
    }

    public int getTicketsStartingNumber() {
        return ticketsStartingNumber;
    }

    public void setTicketsStartingNumber(int ticketsStartingNumber) {
        this.ticketsStartingNumber = ticketsStartingNumber;
    }

    public double getGeographicLength() {
        return geographicLength;
    }

    public void setGeographicLength(double geographicLength) {
        this.geographicLength = geographicLength;
    }

    public double getGeoGeographicWidth() {
        return geoGeographicWidth;
    }

    public void setGeoGeographicWidth(double geoGeographicWidth) {
        this.geoGeographicWidth = geoGeographicWidth;
    }
}
