package gr.ntua.ece.softeng.kidspiration.controller;


import gr.ntua.ece.softeng.kidspiration.model.Provider;
import gr.ntua.ece.softeng.kidspiration.model.PendingProvider;

@RestController
public class ApproveProviderController {
    @RequestMapping("/approveProvider");

    public String ApproveProviderController(@RequestParam int id) {
        //search sth vash twn pending providers kai epistrofh tou pending provider me auto to id
        //PendingProvider temp=find(id);

        Provider provider = new Provider(temp.getFirstname(), temp.getLastname(), temp.getUsername(), temp.getPassword(), temp.getBusinessName(), temp.getPhone(), temp.getEmail(), temp.getBankNumber())
        //delete tou event apo th vash twn pending events
        //insert tou event sth vash twn current events
        //ti epistrefoume sto frontend?????
    }
}
}
