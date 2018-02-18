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


}
