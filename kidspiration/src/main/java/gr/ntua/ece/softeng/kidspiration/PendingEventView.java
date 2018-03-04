package gr.ntua.ece.softeng.kidspiration;

import java.util.Date;

public class PendingEventView extends PendingEvent{

    String businessName;

    public PendingEventView(int event_id, int provider_id, String title, Date date, String starting_time, String place, String type, int ticket_cost, int initial_ticketsNumber, byte lowestAge, byte highestAge, String description, String businessName) {
        super(event_id, provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, lowestAge, highestAge, description);
        this.businessName = businessName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}
