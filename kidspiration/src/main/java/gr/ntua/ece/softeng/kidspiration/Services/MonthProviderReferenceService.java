package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.Dao.MonthProviderReferenceDao;
import gr.ntua.ece.softeng.kidspiration.MonthProviderReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("MonthProviderReferenceService")
public class MonthProviderReferenceService {  /// CHECKING

    @Autowired
    MonthProviderReferenceDao monthProviderReferenceDao;


    public void editMonthProviderReference(MonthProviderReference monthProviderReference) {
        monthProviderReferenceDao.editMonthProviderReference(monthProviderReference);
    }


    public MonthProviderReference find(int provider_id) {
        //System.out.println("ftiakse ta oikonomika stoixeia gamw to ni pou se petage!");
        return monthProviderReferenceDao.find(provider_id);
    }

    public List<MonthProviderReference> findAll() {  //checked
        return monthProviderReferenceDao.findAll();
    } // OK
}