package gr.ntua.ece.softeng.kidspiration;

import java.util.Date;

public class PendingEvent extends Event{

    private byte lowestAge;
    private byte highestAge;
    private String description;

    public PendingEvent(int event_id, int provider_id, String title, Date date, String starting_time, String place, String type, int ticket_cost, int initial_ticketsNumber, byte lowestAge, byte highestAge, String description) {
        super(event_id, provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber);
        this.lowestAge = lowestAge;
        this.highestAge = highestAge;
        this.description = description;
    }

    public byte getLowestAge() {
        return lowestAge;
    }

    public void setLowestAge(byte lowestAge) {
        this.lowestAge = lowestAge;
    }

    public byte getHighestAge() {
        return highestAge;
    }

    public void setHighestAge(byte highestAge) {
        this.highestAge = highestAge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
