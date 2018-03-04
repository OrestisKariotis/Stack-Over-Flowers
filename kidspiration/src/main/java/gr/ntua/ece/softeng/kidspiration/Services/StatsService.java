package gr.ntua.ece.softeng.kidspiration.Services;

import gr.ntua.ece.softeng.kidspiration.StatsView;
import gr.ntua.ece.softeng.kidspiration.Dao.ParentDao;
import gr.ntua.ece.softeng.kidspiration.Dao.ProviderDao;
import gr.ntua.ece.softeng.kidspiration.Dao.StatsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("StatsService")
public class StatsService {

    @Autowired
    StatsDao statsDao;

    public int numOfParents() {
        return statsDao.numOfParents();
    }

    public int numOfProviders() {
        return statsDao.numOfProviders();
    }
}
