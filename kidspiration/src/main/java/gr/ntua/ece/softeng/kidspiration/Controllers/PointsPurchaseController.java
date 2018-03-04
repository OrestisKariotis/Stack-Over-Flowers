package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.PurchaseView;
import gr.ntua.ece.softeng.kidspiration.PurchasePointsInfo;
import gr.ntua.ece.softeng.kidspiration.Services.MonthReferenceService;
import gr.ntua.ece.softeng.kidspiration.Services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointsPurchaseController {

    @Autowired
    //@Qualifier("ParentService")
    private ParentService parentService;

    @Autowired
    private MonthReferenceService monthReferenceService;  /// ADDED

    @RequestMapping(value = "/api/purchase_points", method = RequestMethod.POST)
    public ResponseEntity<?> Purchase_Points(@RequestBody PurchasePointsInfo info) {

        // OK
        // CHECK TRANSACTION

        Parent parent = parentService.find(info.getId());  // could be done with only one query if editUser returns parent

        if (parent == null)
            return ResponseEntity.badRequest().body("Something went wrong");
        // two queries perhaps are redundant,for example parent could not be returned
        parent = parentService.purchasePoints(parent, info);
        if (parent == null)
            return ResponseEntity.badRequest().body("Something went wrong");
        monthReferenceService.updateMonthReference(info.getPointsCode());  /// ADDED
        //EMAIL NOTIFICATION
        PurchaseView purchase_return = new PurchaseView(info.getId(), parent.getWallet());
        return ResponseEntity.accepted().body(purchase_return);
    }
}