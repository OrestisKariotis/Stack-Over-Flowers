package gr.ntua.ece.softeng.kidspiration.controller;

import gr.ntua.ece.softeng.kidspiration.model.CurrentEvent;

@RestController
public class ApproveEventController {

    @RequestMapping("/approveEvent");

    public String ApproveEventController(@RequestParam int id) {
        //search sth vash twn pending events kai epistrofh tou pending event me auto to id
        //PendingEvent temp=find(id);
        //
        //pote vriskoume geografiko mhkos kai platos??????
        CurrentEvent event = new CurrentEvent(temp.getId_provider(), temp.getEventName(), temp.getDate(), temp.getTime(), temp.getLowestAge(), temp.getHighestAge(), temp.getKind(), temp.getCost(), temp.getTicketsNumber(), temp.getGeographicLength(), temp.getGeographicWidth())
        //delete to event apo th vash twn pending events
        //insert to event sth vash twn current events
        //ti epistrefoume sto frontend?????
    }
}