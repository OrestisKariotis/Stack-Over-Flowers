package gr.ntua.ece.softeng.kidspiration.controller;
import gr.ntua.ece.softeng.kidspiration.model.Parent;

@RestController
public class PurchasePointsController {
    @RequestMapping("/paketo1")
    public Parent(@RequestParam int id) {
          //id mas dinei h username kai password??
        Parent p= validateParent(id)//search ton xrhsth me auta ta stoixeia
        int temp=p.getRemain_points();
        p.setRemain_points(temp+500);
        //enhmerwsh vashs
        //ti stelnoume mprosta???
    }

    @RequestMapping("/paketo2")
    public Parent(@RequestParam int id) {
        Parent p= validateParent(id) //search ton xrhsth me auta ta stoixeia
        int temp=p.getRemain_points();
        p.setRemain_points(temp+1025);
        //enhmerwsh vashs
        //ti stelnoume mprosta???
    }

    @RequestMapping("/paketo3")
    public Parent(@RequestParam int id) {
        Parent p= validateParent(id) //search ton xrhsth me auta ta stoixeia
        int temp=p.getRemain_points();
        p.setRemain_points(temp+2100);
        //enhmerwsh vashs
        //ti stelnoume mprosta??
    }

    @RequestMapping("/paketo4")
    public Parent(@RequestParam int id) {
        Parent p= validateParent(id)//search ton xrhsth me auta ta stoixeia
        int temp=p.getRemain_points();
        p.setRemain_points(temp+5300);
        //enhmerwsh vashs
        //ti stelnoume mprosta????
    }
}
