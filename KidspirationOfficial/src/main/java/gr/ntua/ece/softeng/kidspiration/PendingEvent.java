package gr.ntua.ece.softeng.kidspiration;

public class PendingEvent extends Event{

    private int lowestAge;
    private int highestAge;
    private String freeText;

    public PendingEvent(int provider_id, String name, String date, String starting_time, String place, String type, int ticket_cost, int initial_ticketsNumber, int lowestAge, int highestAge, String freeText) {
        super(provider_id, name, date, starting_time, place, type, ticket_cost, initial_ticketsNumber);
        this.lowestAge = lowestAge;
        this.highestAge = highestAge;
        this.freeText = freeText;
    }

    public int getLowestAge() {
        return lowestAge;
    }

    public void setLowestAge(int lowestAge) {
        this.lowestAge = lowestAge;
    }

    public int getHighestAge() {
        return highestAge;
    }

    public void setHighestAge(int highestAge) {
        this.highestAge = highestAge;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }
}