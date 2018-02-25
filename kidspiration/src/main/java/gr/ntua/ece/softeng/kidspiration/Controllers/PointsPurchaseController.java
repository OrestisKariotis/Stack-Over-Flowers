package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.Services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointsPurchaseController {

    @Autowired
    //@Qualifier("ParentService")
    private ParentService parentService;

    //private MonthReferenceService monthReference_service;

    @RequestMapping("/purchase_points")
    public Parent Purchase_Points(@RequestParam String id, @RequestParam String points_package_code) {  //parameters may change. Whole Parent Object could be sent to Backend

        // Here Parent id and package type is sent, BankAcoount and safe code should be sent as well to simulate Bank Transaction
        // Bank Communication in frontend or Backend ??? In backend i think.

        Parent parent = parentService.find(Integer.parseInt(id));  // could be done with only one query if editUser returns parent
        // two queries perhaps are redundant,for example parent could not be returned
        parent = parentService.purchasePoints(parent, Byte.parseByte(points_package_code));

        /*
        Calendar cal = Calendar.getInstance();
        MonthReference monthReference= (MonthReference) monthReference_service.find(cal.get(Calendar.MONTH));
        temp=monthReference.getEarnings();
        monthReference.setEarnings(temp+5); + 10 for packet2 / 20 for packet3 / 50 for packet4
        monthReference_service.editMonthReference(monthReference);
        */
        //enhmerwsh vashs monthreference kai parent
        //ti stelnoume mprosta???

        return parent;
    }
}