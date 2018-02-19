package gr.ntua.ece.softeng.kidspiration.model;

public class Ticket {

    private int ticketId;
    private int parentId;
    private int eventId;

    public Ticket(int ticketId, int parentId, int eventId) {
        this.ticketId = ticketId; //pws pairnei to id???
        this.parentId = parentId;
        this.eventId = eventId;
    }
}
