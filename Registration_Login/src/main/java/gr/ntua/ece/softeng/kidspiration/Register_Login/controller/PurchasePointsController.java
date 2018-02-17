package gr.ntua.ece.softeng.kidspiration.Register_Login.controller;
import gr.ntua.ece.softeng.kidspiration.Register_Login.model.Parent;
import gr.ntua.ece.softeng.kidspiration.Register_Login.model.Login;

@RestController
public class PurchasePointsController {
    @RequestMapping("/paketo1")
    public Parent(@RequestParam String Username, @RequestParam String Password) {
        Login login=new Login(Username, Password);   //id mas dinei h username kai password??
        Parent p= validateParent(login)//search ton xrhsth me auta ta stoixeia
        int temp=p.getRemain_points();
        p.setRemain_points(temp+500);
        //enhmerwsh vashs
    }

    @RequestMapping("/paketo2")
    public Parent(@RequestParam String Username, @RequestParam String Password) {
        Login login=new Login(Username, Password);   //id mas dinei h username kai password??
        Parent p= validateParent(login)//search ton xrhsth me auta ta stoixeia
        int temp=p.getRemain_points();
        p.setRemain_points(temp+1025);
        //enhmerwsh vashs
    }

    @RequestMapping("/paketo3")
    public Parent(@RequestParam String Username, @RequestParam String Password) {
        Login login=new Login(Username, Password);   //id mas dinei h username kai password??
        Parent p= validateParent(login)//search ton xrhsth me auta ta stoixeia
        int temp=p.getRemain_points();
        p.setRemain_points(temp+2100);
        //enhmerwsh vashs
    }

    @RequestMapping("/paketo4")
    public Parent(@RequestParam String Username, @RequestParam String Password) {
        Login login=new Login(Username, Password);   //id mas dinei h username kai password??
        Parent p= validateParent(login)//search ton xrhsth me auta ta stoixeia
        int temp=p.getRemain_points();
        p.setRemain_points(temp+5300);
        //enhmerwsh vashs
    }
}
