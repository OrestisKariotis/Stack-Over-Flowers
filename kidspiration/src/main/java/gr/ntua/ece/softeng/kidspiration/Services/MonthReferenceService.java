package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.Dao.MonthReferenceDao;
import gr.ntua.ece.softeng.kidspiration.MonthReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
@Qualifier("MonthReferenceService")
public class MonthReferenceService {  /// CHECKING

    @Autowired
    MonthReferenceDao monthReferenceDao;

    public void editMonthReference(MonthReference monthReference) {
        monthReferenceDao.editMonthReference(monthReference);
    }


    public MonthReference find(int month) {
        System.out.println("ftiakse ta oikonomika stoixeia gamw to ni pou se petage!");
        return monthReferenceDao.find(month);
    }


    public void updateMonthReference(byte pointsPackage){ // OK
        double packageProfit = 0;
            System.out.println("pointsPackage is: " + pointsPackage);
        int earnings = 0;
        if (pointsPackage == 1) {
            packageProfit = 0.5;
            earnings = 5;
        }
        else if (pointsPackage == 2){
            packageProfit = 0.775;
            earnings = 10;
        }
        else if (pointsPackage == 3){
            packageProfit = 1.1;
            earnings = 20;
        }
        else if (pointsPackage == 4){
            packageProfit = 2.3;
                System.out.println("Imma here bitchez: " + packageProfit);
            earnings = 50;
        }
        else
            System.out.println("Eisai malakas? Den vgazeis lefta???");

        Calendar cal = Calendar.getInstance();
        MonthReference monthReference = monthReferenceDao.find(cal.get(Calendar.MONTH));
            System.out.println("packageProfit is set to: " + packageProfit);
        double temp = monthReference.getProfit();
        monthReference.setProfit(temp + packageProfit);
            System.out.println("temp + packageProfit is set to: " + temp + packageProfit);

        int temp2 = monthReference.getEarnings();
        monthReference.setEarnings(temp2 + earnings);

        monthReferenceDao.editMonthReference(monthReference);

        monthReference = monthReferenceDao.find(12);
        temp = monthReference.getProfit();
        monthReference.setProfit(temp + packageProfit);

        temp2 = monthReference.getEarnings();
        monthReference.setEarnings(temp2 + earnings);

        monthReferenceDao.editMonthReference(monthReference);

    }
}
