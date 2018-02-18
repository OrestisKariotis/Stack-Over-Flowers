package gr.ntua.ece.softeng.kidspiration.model;

public class PendingEvent {
    private int id_event;
    private int id_provider;
    private String eventName;
    private String date;
    private String time;
    private String place;
    private int lowestAge;
    private int highestAge;
    private String kind;
    private int cost;
    private int ticketsNumber;
    private double geographicLength;
    private double getGeographicWidth;
    //perigrafh eleutherou keimenou edw?????
    //pote pairnoume syntetagmenes???

    public PendingEvent(int id_provider, String eventName, String date, String time, String place, int lowestAge, int highestAge, String kind, int cost, int ticketsNumber) {
        this.id_event=??????// pws pairnei timh to id tou event????????
        this.id_provider = id_provider;
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.place = place;
        this.lowestAge = lowestAge;
        this.highestAge = highestAge;
        this.kind = kind;
        this.cost = cost;
        this.ticketsNumber = ticketsNumber;
    }

    public int getId_event() {
        return id_event;
    }

    public int getId_provider() {
        return id_provider;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public int getLowestAge() {
        return lowestAge;
    }

    public int getHighestAge() {
        return highestAge;
    }

    public String getKind() {
        return kind;
    }

    public int getCost() {
        return cost;
    }

    public int getTicketsNumber() {
        return ticketsNumber;
    }

    public double getGeographicLength() {
        return geographicLength;
    }

    public double getGetGeographicWidth() {
        return getGeographicWidth;
    }


    public void setGeographicLength(double geographicLength) {
        this.geographicLength = geographicLength;
    }

    public void setGetGeographicWidth(double getGeographicWidth) {
        this.getGeographicWidth = getGeographicWidth;
    }
}
