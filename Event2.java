
package gr.ntua.ece.softeng.kidspiration;








import java.util.List;





public class Event2 {

    //   private int event_id; // not-initialised
//    private int provider_id;
    private String title;
    private int sqlid; //gia sql
    private String date; //could be date?
    private String starting_time;
    private String desc;
    private String type;  // ena string tlk prepei na allaksw ta panta
    private int ticket_cost;
    //   private int age;
//    private int initial_ticketsNumber;
    private Location location ;

    private int lowage ;		//
    private int highage;		//ta low kai high pedia gia to serch



    public Event2(String title) {

        this.title = title;

    }

    public Event2(int sqlid ,String title, String date, String type, int ticket_cost,Location loc, String desc , int lowage,int highage,String starting_time) {
        //       this.event_id = event_id;
        //       this.provider_id = provider_id;
        this.title = title;
        this.date = date;
        this.starting_time = starting_time;
        this.desc=desc;
        this.sqlid=sqlid;


        this.lowage=lowage ;		//
        this.highage=highage;

        this.type = type;
        this.ticket_cost = ticket_cost;
        //    this.initial_ticketsNumber = initial_ticketsNumber;
        this.location =loc;
        //    this.age=age;

    }

    public int getEvent_id() {
        return sqlid;
    }

    public void setEvent_id(int event_id) {
        this.sqlid = event_id;
    }



//	public int getAge() {
//		return age;//edw
//	}

//	public void setAge(int age) {
//		this.age =age;
//	}




    public int getHighage() {
        return highage;
    }

    public void setHighage(int highage) {
        this.highage = highage;
    }


    public int getLowage() {
        return lowage;
    }

    public void setLowage(int lowage) {
        this.lowage = lowage;
    }



    public String getStarting_time() {
        return starting_time;
    }

    public void setStarting_time(String starting_time) {
        this.starting_time = starting_time;
    }




    public Location getLoc() {
        return location;
    }

    public void setLoc(Location loc) {
        this.location = loc;
    }






    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc= desc;
    }

    /**    public String getPlace() {
     return place;
     }

     public void setPlace(String place) {
     this.place = place;
     }

     **/
    public String getType() {  // to type einai lista apo strings
        return type;
    }




    public void setType(String tagg) { //gia eukolh pros8esh sth lista twn taggs
        this.type=tagg;
    }


    //  public JSONArray fromListTojson() {


    //	JSONArray mJSONArray = new JSONArray((this.type));
    //	return mJSONArray;

    //  }




//    public void setType(List<String> type) {
    //      this.type = type;
    // }

    public int getTicket_cost() {
        return ticket_cost;
    }

    public void setTicket_cost(int ticket_cost) {
        this.ticket_cost = ticket_cost;
    }


    //  public int getAge() {
    //       return age;
    //  }

    //  public void setAge(int age) {
    //      this.age = age;
    //   }
}

