package gr.ntua.ece.softeng.kidspiration;

import java.util.Date;

public class EventPageView extends CurrentEvent{
    public String businessName;

    public EventPageView(int event_id, int provider_id, String title, Date date, String starting_time, String place, String type, int ticket_cost, int initial_ticketsNumber, byte lowestAge, byte highestAge, String description, int available_ticketsNumber, double latitude, double longitude, String businessName) {
        super(event_id, provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, lowestAge, highestAge, description, available_ticketsNumber, latitude, longitude);
        this.businessName = businessName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}
