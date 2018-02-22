package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.Parent;

import gr.ntua.ece.softeng.kidspiration.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import gr.ntua.ece.softeng.kidspiration.MonthReference;
import gr.ntua.ece.softeng.kidspiration.Services.MonthReferenceService;
import java.util.Calendar;

@RestController
public class PurchasePointsController {
    @Autowired
    @Qualifier("ParentService")

    private UserService parent_service;
    private MonthReferenceService monthReference_service;

    @RequestMapping("/paketo1")
    public Parent FirstPackage(@RequestParam String id) {

        Parent p = (Parent) parent_service.find(Integer.parseInt(id));
        int temp = p.getWallet();
        p.setWallet(temp + 500);
        parent_service.editUser(p);
        Calendar cal = Calendar.getInstance();
        MonthReference monthReference=monthReference_service.find(cal.get(Calendar.MONTH));
        temp=monthReference.getEarnings();
        monthReference.setEarnings(temp+5);
        monthReference_service.editMonthReference(monthReference);
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
        Calendar cal = Calendar.getInstance();
        MonthReference monthReference=monthReference_service.find(cal.get(Calendar.MONTH));
        temp=monthReference.getEarnings();
        monthReference.setEarnings(temp+10);
        monthReference_service.editMonthReference(monthReference);
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
        Calendar cal = Calendar.getInstance();
        MonthReference monthReference=monthReference_service.find(cal.get(Calendar.MONTH));
        temp=monthReference.getEarnings();
        monthReference.setEarnings(temp+20);
        monthReference_service.editMonthReference(monthReference);
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
        Calendar cal = Calendar.getInstance();
        MonthReference monthReference=monthReference_service.find(cal.get(Calendar.MONTH));
        temp=monthReference.getEarnings();
        monthReference.setEarnings(temp+50);
        monthReference_service.editMonthReference(monthReference);
        //enhmerwsh vashs monthreference kai parent
        //ti stelnoume mprosta???
        return p;
    }
}