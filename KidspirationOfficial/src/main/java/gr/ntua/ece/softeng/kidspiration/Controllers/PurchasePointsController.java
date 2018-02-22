package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.Parent;

import gr.ntua.ece.softeng.kidspiration.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PurchasePointsController {
    @Autowired
    @Qualifier("ParentService")
    private UserService parent_service;

    @RequestMapping("/paketo1")
    public Parent FirstPackage(@RequestParam String id) {

        Parent p = (Parent) parent_service.find(Integer.parseInt(id));
        int temp = p.getWallet();
        p.setWallet(temp + 500);
        parent_service.editUser(p);
        //enhmerwsh vashs monthreference kai parent
        //ti stelnoume mprosta???
        return p;
    }

    @RequestMapping("/paketo2")
    public Parent SecondPackage(@RequestParam String id) {

        Parent p = (Parent) parent_service.find(Integer.parseInt(id));
        int temp = p.getWallet();
        p.setWallet(temp + 1025);
        parent_service.editUser(p);
        //enhmerwsh vashs monthreference kai parent
        //ti stelnoume mprosta???
        return p;
    }

    @RequestMapping("/paketo3")
    public Parent ThirdPackage(@RequestParam String id) {

        Parent p = (Parent) parent_service.find(Integer.parseInt(id));
        int temp = p.getWallet();
        p.setWallet(temp + 2100);
        parent_service.editUser(p);
        //enhmerwsh vashs monthreference kai parent
        //ti stelnoume mprosta???
        return p;
    }

    @RequestMapping("/paketo4")
    public Parent FourthPackage(@RequestParam String id) {

        Parent p = (Parent) parent_service.find(Integer.parseInt(id));
        int temp = p.getWallet();
        p.setWallet(temp + 5300);
        parent_service.editUser(p);
        //enhmerwsh vashs monthreference kai parent
        //ti stelnoume mprosta???
        return p;
    }
}