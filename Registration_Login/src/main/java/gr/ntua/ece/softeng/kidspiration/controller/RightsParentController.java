package gr.ntua.ece.softeng.kidspiration.controller;

import gr.ntua.ece.softeng.kidspiration.model.Parent;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RightsParentController {

    @RequestMapping("/banParent")
    public void banParent(@RequestParam int id){
        //vres sth vash poios einai o parent
        Parent p= validateParent(id);
        p.setBan(0);
        //enhmerwse katallhla th vash!
    }

    @RequestMapping("/unbanParent")
    public int unbanParent(@RequestParam int id){
        //vres sth vash poios einai o parent
        Parent p= validateParent(id);
        p.setBan(1);
        //enhmerwse katallhla th vash!
    }
}
