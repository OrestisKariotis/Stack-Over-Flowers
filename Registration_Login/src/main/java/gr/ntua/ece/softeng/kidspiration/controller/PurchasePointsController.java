package gr.ntua.ece.softeng.kidspiration.controller;
import gr.ntua.ece.softeng.kidspiration.model.Parent;
import gr.ntua.ece.softeng.kidspiration.model.MonthReference;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@RestController
public class PurchasePointsController {
    @RequestMapping("/paketo1")
    public Parent(@RequestParam int id) {
          //id mas dinei h username kai password??
        Parent p= validateParent(id)//search ton xrhsth me auta ta stoixeia
        int temp=p.getRemain_points();
        p.setRemain_points(temp+500);
        Calendar cal = Calendar.getInstance();
        MonthReference monthReference= findMonthReference(cal.get(Calendar.MONTH));//where month=cal
        temp=monthReference.getEarnings();
        monthReference.setEarnings(temp+5);
        //enhmerwsh vashs monthreference kai parent
        //ti stelnoume mprosta???
    }

    @RequestMapping("/paketo2")
    public Parent(@RequestParam int id) {
        Parent p= validateParent(id) //search ton xrhsth me auta ta stoixeia
        int temp=p.getRemain_points();
        p.setRemain_points(temp+1025);
        Calendar cal = Calendar.getInstance();
        MonthReference monthReference= findMonthReference(cal.get(Calendar.MONTH));//where month=cal
        temp=monthReference.getEarnings();
        monthReference.setEarnings(temp+10);
        //enhmerwsh vashs monthreference kai parent
        //ti stelnoume mprosta???
    }

    @RequestMapping("/paketo3")
    public Parent(@RequestParam int id) {
        Parent p= validateParent(id) //search ton xrhsth me auta ta stoixeia
        int temp=p.getRemain_points();
        p.setRemain_points(temp+2100);
        Calendar cal = Calendar.getInstance();
        MonthReference monthReference= findMonthReference(cal.get(Calendar.MONTH));//where month=cal
        temp=monthReference.getEarnings();
        monthReference.setEarnings(temp+20);
        //enhmerwsh vashs monthreference kai parent
        //ti stelnoume mprosta??
    }

    @RequestMapping("/paketo4")
    public Parent(@RequestParam int id) {
        Parent p= validateParent(id)//search ton xrhsth me auta ta stoixeia
        int temp=p.getRemain_points();
        p.setRemain_points(temp+5300);
        Calendar cal = Calendar.getInstance();
        MonthReference monthReference= findMonthReference(cal.get(Calendar.MONTH));//where month=cal
        temp=monthReference.getEarnings();
        monthReference.setEarnings(temp+50);
        //enhmerwsh vashs monthreference kai parent
        //ti stelnoume mprosta????
    }
}

