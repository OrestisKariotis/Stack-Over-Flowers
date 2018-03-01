package gr.ntua.ece.softeng.kidspiration;

import java.util.Date;

public class OldEvent extends Event {

    private int sold_ticketsNumber;

    public OldEvent(int event_id, int provider_id, String name, Date date, String starting_time, String place, String type, int ticket_cost, int initial_ticketsNumber, int sold_ticketsNumber) {
        super(event_id, provider_id, name, date, starting_time, place, type, ticket_cost, initial_ticketsNumber);
        this.sold_ticketsNumber = sold_ticketsNumber;
    }

    public int getSold_ticketsNumber() {
        return sold_ticketsNumber;
    }

    public void setSold_ticketsNumber(int sold_ticketsNumber) {
        this.sold_ticketsNumber = sold_ticketsNumber;
    }
}
