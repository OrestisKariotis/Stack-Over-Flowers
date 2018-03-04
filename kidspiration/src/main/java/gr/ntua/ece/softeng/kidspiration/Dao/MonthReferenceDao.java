package gr.ntua.ece.softeng.kidspiration.Dao;

import gr.ntua.ece.softeng.kidspiration.MonthReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Qualifier("MonthReferenceDao")
public class MonthReferenceDao {  //CHECKING

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void editMonthReference(MonthReference monthReference) {  // OK

        jdbcTemplate.update("UPDATE MonthReferences SET month = ? , earnings = ?, expenses= ?, profit = ? WHERE month = ? ",
                monthReference.getMonth(), monthReference.getEarnings(), monthReference.getExpenses(), monthReference.getProfit(), monthReference.getMonth());
        System.out.println("Updating profit in dao with + " + monthReference.getProfit());
        // id can be omitted because it is already included in parent
        // some arguments in query will be omitted
    }

    public MonthReference find(int month) {  // OK

        MonthReference monthReference =  jdbcTemplate.queryForObject("SELECT * FROM MonthReferences WHERE month= ? ",
                    new Object[] { month }, new MonthReferenceMapper());
        return monthReference;
    }

    public List<MonthReference> findAll() {
        List<MonthReference> monthReferences = jdbcTemplate.query("SELECT * FROM MonthReferences", new MonthReferenceMapper());
        return monthReferences;
    }



    class MonthReferenceMapper implements RowMapper<MonthReference> {
         public MonthReference mapRow(ResultSet rs, int rowNum) throws SQLException {
             int month = rs.getInt("month");
             int earnings = rs.getInt("earnings");
             double expenses = rs.getDouble("expenses");
             double profit = rs.getDouble("profit");
             MonthReference monthReference = new MonthReference(month, earnings, expenses, profit);
             return monthReference;
         }
    }
}