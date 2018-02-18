package gr.ntua.ece.softeng.kidspiration.controller;

import gr.ntua.ece.softeng.kidspiration.model.PendingEvent;

@RestController
public class SubmitEventController {
    /*

     */
    @RequestMapping("/submission")
    public String SubmitEventController(@RequestParam int id, @RequestParam String name, @RequestParam String place, @RequestParam String date, @RequestParam String time, @RequestParam String kind, @RequestParam int lowestAge, @RequestParam int highestAge, @RequestParam int ticketsNumber, @RequestParam int cost)  //perigrafh eleutherou keimenou???   )
    {
        PendingEvent event= new PendingEvent(id, name, date, time, place, lowestAge, highestAge, kind, cost, ticketsNumber);//perigrafh eleutherou keimenou???
        //enhmerwsh vashs gia to neo event
        return ("Your event will be tested by the administrator");
    }
}