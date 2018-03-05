package gr.ntua.ece.softeng.kidspiration;

import java.util.Date;

public class PendingEvent extends Event{

    private byte lowestAge;
    private byte highestAge;
    private String description;
    private int numOfPhotos;


    public PendingEvent(int event_id, int provider_id, String title, Date date, String starting_time, String place, String categories, int ticket_cost, int initial_ticketsNumber, byte lowestAge, byte highestAge, String description, int numOfPhotos) {
        super(event_id, provider_id, title, date, starting_time, place, categories, ticket_cost, initial_ticketsNumber);
        this.lowestAge = lowestAge;
        this.highestAge = highestAge;
        this.description = description;
        this.numOfPhotos = numOfPhotos;
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

    public int getNumOfPhotos() {
        return numOfPhotos;
    }

    public void setNumOfPhotos(int numOfPhotos) {
        numOfPhotos = numOfPhotos;
    }
}
