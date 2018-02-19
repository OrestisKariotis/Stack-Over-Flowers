package gr.ntua.ece.softeng.kidspiration.model;

public class OldEvent {
    private int id_event;
    private int id_provider;
    private String eventName;
    private String date;
    private String time;
    private String kind;
    private int cost;
    private int ticketsSoldNumber;
    private int ticketsStartingNumber;

    public OldEvent(int id_provider, String eventName, String date, String time, String kind, int cost, int ticketsSoldNumber, int ticketsStartingNumber) {
         this.id_event=??? //
         this.id_provider=id_provider;
         this.eventName=eventName;
         this.date=date;
         this.time=time;
         this.kind=kind;
         this.cost=cost;
         this.ticketsSoldNumber=ticketsSoldNumber;
         this.ticketsStartingNumber=ticketsStartingNumber;
    }
}



