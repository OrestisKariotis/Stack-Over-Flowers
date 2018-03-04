package gr.ntua.ece.softeng.kidspiration;

public class Event2 {

    private String title;
    private int event_id; //gia sql
    private String date; //could be date?
    private String starting_time;
    private String description;
    private String categories;  // ena string tlk prepei na allaksw ta panta
    private int ticket_cost;
    private Location location ;
    private int lowestAge ;	//
    private int highestAge;		//ta low kai high pedia gia to serch

    public Event2(int sqlid ,String title, String date, String type, int ticket_cost,Location loc, String desc , int lowage,int highage,String starting_time) {
        this.title = title;
        this.date = date;
        this.starting_time = starting_time;
        this.description=desc;
        this.event_id=sqlid;
        this.lowestAge=lowage ;
        this.highestAge=highage;
        this.categories = type;
        this.ticket_cost = ticket_cost;
        this.location =loc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStarting_time() {
        return starting_time;
    }

    public void setStarting_time(String starting_time) {
        this.starting_time = starting_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public int getTicket_cost() {
        return ticket_cost;
    }

    public void setTicket_cost(int ticket_cost) {
        this.ticket_cost = ticket_cost;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
}

