package gr.ntua.ece.softeng.kidspiration.Dao;

import gr.ntua.ece.softeng.kidspiration.Parent;
import gr.ntua.ece.softeng.kidspiration.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("StatsDao")
public class StatsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int numOfParents() {
        String sql = "SELECT COUNT(*) FROM Parents";
        int rowCount = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(rowCount);
        return rowCount;
    }

    public int numOfProviders() {
        String sql = "select count(*) from Providers";
        int rowCount = jdbcTemplate.queryForObject(sql, Integer.class);
        return rowCount;
    }
}
