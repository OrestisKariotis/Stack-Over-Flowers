package gr.ntua.ece.softeng.kidspiration.controller;

import gr.ntua.ece.softeng.kidspiration.model.Provider;

@RestController
public class RightsProviderController {

    @RequestMapping("/banProvider")
    public void banProvider(@RequestParam int id){
        //vres sth vash poios einai o provider
        Provider p=validateProvider(id);
        p.setRightsNumber(0);
        //enhmerwse katallhla th vash!
    }

    @RequestMapping("/sProvider")
    public int unbanParent(@RequestParam int id){
        //vres sth vash poios einai o provider
        Provider p=validateProvider(id);
        p.setRightsNumber(1);
        //enhmerwse katallhla th vash!
    }

    @RequestMapping("/unbanProvider")
    public void banProvider(@RequestParam int id){
        //vres sth vash poios einai o provider
        Provider p=validateProvider(id);
        p.setRightsNumber(2);
        //enhmerwse katallhla th vash!
    }
}
