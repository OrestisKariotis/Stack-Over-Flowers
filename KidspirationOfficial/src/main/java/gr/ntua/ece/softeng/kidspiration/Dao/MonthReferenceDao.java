package gr.ntua.ece.softeng.kidspiration.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import gr.ntua.ece.softeng.kidspiration.MonthReference;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("MonthReferenceDao")
public class MonthReferenceDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void editMonthReference(MonthReference monthReference) {  // checking

        jdbcTemplate.update("UPDATE MonthReferences SET month= ? , earnings = ?, expenses= ? WHERE month = ? ",
                monthReference.getMonth(), monthReference.getEarnings(), monthReference.getExpenses(), monthReference.getMonth());

        // id can be omitted because it is already included in parent
        // some arguments in query will be omitted
    }

    public MonthReference find(int Month) {

            MonthReference monthReference =  jdbcTemplate.queryForObject("SELECT * FROM MonthReferences where month= ? ",
                    new Object[] { Month }, new MonthReferenceMapper());
            return monthReference;
    }

    class MonthReferenceMapper implements RowMapper<MonthReference> {
         public MonthReference mapRow(ResultSet rs, int rowNum) throws SQLException {
             int month = rs.getInt("month");
             int earnings = rs.getInt("earnings");
             double expenses = rs.getDouble("expenses");
             MonthReference monthReference=new MonthReference(month, earnings, expenses);
             return monthReference;
         }
    }
}