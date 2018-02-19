package gr.ntua.ece.softeng.kidspiration;

public class OldEvent extends Event {

    private int sold_ticketsNumber;

    public OldEvent(int provider_id, String name, String date, String starting_time, String place, String type, int ticket_cost, int initial_ticketsNumber, int sold_ticketsNumber) {
        super(provider_id, name, date, starting_time, place, type, ticket_cost, initial_ticketsNumber);
        this.sold_ticketsNumber = sold_ticketsNumber;
    }

    public int getSold_ticketsNumber() {
        return sold_ticketsNumber;
    }

    public void setSold_ticketsNumber(int sold_ticketsNumber) {
        this.sold_ticketsNumber = sold_ticketsNumber;
    }
}
