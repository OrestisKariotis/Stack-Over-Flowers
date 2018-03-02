package gr.ntua.ece.softeng.kidspiration;

public class PurchaseTicketInfo {
    int id;
    int event_id;
    int ticketsNumber;

    public PurchaseTicketInfo(int id, int event_id, int ticketsNumber) {
        this.id = id;
        this.event_id = event_id;
        this.ticketsNumber = ticketsNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getTicketsNumber() {
        return ticketsNumber;
    }

    public void setTicketsNumber(int ticketsNumber) {
        this.ticketsNumber = ticketsNumber;
    }
}
