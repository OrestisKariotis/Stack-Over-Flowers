package gr.ntua.ece.softeng.kidspiration;

public class Ticket {
    private int ticketId;
    private int parentId;
    private int eventId;

    public Ticket(int ticketId, int parentId, int eventId) {
        this.ticketId = ticketId;
        this.parentId = parentId;
        this.eventId = eventId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int ticketId) {
        this.eventId = ticketId;
    }
}