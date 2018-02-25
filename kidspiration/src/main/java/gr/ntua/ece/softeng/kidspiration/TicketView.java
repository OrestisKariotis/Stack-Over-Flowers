package gr.ntua.ece.softeng.kidspiration;

public class TicketView extends Ticket {  // do we need OldTicketView as well ?

    // ticket code ?
    // parent id probably is not needed

    String event_title;
    String provider_businessName;
    String date;   // could be date
    int ticket_cost;

    public TicketView(int ticketId, int parentId, int eventId, String event_title, String provider_businessName, String date, int ticket_cost) {
        super(ticketId, parentId, eventId);
        this.event_title = event_title;
        this.provider_businessName = provider_businessName;
        this.date = date;
        this.ticket_cost = ticket_cost;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getProvider_businessName() {
        return provider_businessName;
    }

    public void setProvider_businessName(String provider_businessName) {
        this.provider_businessName = provider_businessName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTicket_cost() {
        return ticket_cost;
    }

    public void setTicket_cost(int ticket_cost) {
        this.ticket_cost = ticket_cost;
    }
}
