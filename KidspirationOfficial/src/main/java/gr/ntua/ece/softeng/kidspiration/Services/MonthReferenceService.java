package gr.ntua.ece.softeng.kidspiration.Services;

import java.util.List;

import gr.ntua.ece.softeng.kidspiration.MonthReference;
import gr.ntua.ece.softeng.kidspiration.Dao.MonthReferenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("MonthReferenceService")
public class MonthReferenceService {

    @Autowired
    MonthReferenceDao monthReferenceDao;
    public void editMonthReference(MonthReference monthReference) {
        monthReferenceDao.editMonthReference(monthReference);
    }


    public MonthReference find(int month) {
        return monthReferenceDao.find(month);
    }


}