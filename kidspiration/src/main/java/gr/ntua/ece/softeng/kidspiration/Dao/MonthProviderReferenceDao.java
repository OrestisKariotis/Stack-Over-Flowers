package gr.ntua.ece.softeng.kidspiration.Dao;

import gr.ntua.ece.softeng.kidspiration.MonthProviderReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Qualifier("MonthProviderReferenceDao")
public class MonthProviderReferenceDao {  //CHECKING

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addMonthProviderReference(MonthProviderReference monthProviderReference) { // OK
        jdbcTemplate.update("INSERT INTO MonthProviderReferences (provider_id, january, february, march, april, may, june, july, august, september, octomber, november, december) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                monthProviderReference.getProvider_id(), monthProviderReference.getJanuary(), monthProviderReference.getFebruary(), monthProviderReference.getMarch(), monthProviderReference.getApril(), monthProviderReference.getMay(), monthProviderReference.getJune(), monthProviderReference.getJuly(), monthProviderReference.getAugust(), monthProviderReference.getSeptember(), monthProviderReference.getOctomber(), monthProviderReference.getNovember(), monthProviderReference.getDecember());
    }

    public void editMonthProviderReference(MonthProviderReference monthProviderReference) {  // OK

        jdbcTemplate.update("UPDATE MonthProviderReferences SET monthProviderReference_id= ? , provider_id = ? , january_profit= ? , february_profit= ? , march_profit= ? , april_profit= ? , may_profit= ?, june_profit= ?, july_profit= ? , august_profit= ? , september_profit= ? , octomber_profit= ? , november_profit= ?, december_profit= ?  WHERE provider_id=? ",
                monthProviderReference.getId(), monthProviderReference.getProvider_id(), monthProviderReference.getJanuary(), monthProviderReference.getFebruary(), monthProviderReference.getMarch(), monthProviderReference.getApril(), monthProviderReference.getMay(), monthProviderReference.getJune(), monthProviderReference.getJuly(), monthProviderReference.getAugust(), monthProviderReference.getSeptember(), monthProviderReference.getOctomber(), monthProviderReference.getNovember(), monthProviderReference.getDecember(), monthProviderReference.getProvider_id());
        System.out.println("Updating profit in dao " );
        // id can be omitted because it is already included in parent
        // some arguments in query will be omitted
    }

    public MonthProviderReference find(int provider_id) {  // OK

        MonthProviderReference monthProviderReference =  jdbcTemplate.queryForObject("SELECT * FROM MonthProviderReferences WHERE provider_id = ?  ",
                new Object[] { provider_id }, new MonthProviderReferenceMapper());
        return monthProviderReference;
    }

    public List<MonthProviderReference> findAll() {  //checked
        List <MonthProviderReference> monthProviderReferences = jdbcTemplate.query("SELECT * FROM MonthProviderReferences", new MonthProviderReferenceMapper());
        return monthProviderReferences;
    }

    class MonthProviderReferenceMapper implements RowMapper<MonthProviderReference> {
        public MonthProviderReference mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("monthProviderReference_id");
            int provider_id=rs.getInt("provider_id");
            double january=rs.getDouble("january_profit");
            double february=rs.getDouble("february_profit");
            double march=rs.getDouble("march_profit");
            double april=rs.getDouble("april_profit");
            double may=rs.getDouble("may_profit");
            double june=rs.getDouble("june_profit");
            double july=rs.getDouble("july_profit");
            double august=rs.getDouble("august_profit");
            double september=rs.getDouble("september_profit");
            double octomber=rs.getDouble("octomber_profit");
            double november=rs.getDouble("november_profit");
            double december=rs.getDouble("december_profit");

            MonthProviderReference monthProviderReference = new MonthProviderReference(id, provider_id, january, february, march, april, may, june, july, august, september, octomber, november, december);
            return monthProviderReference;
        }
    }
}