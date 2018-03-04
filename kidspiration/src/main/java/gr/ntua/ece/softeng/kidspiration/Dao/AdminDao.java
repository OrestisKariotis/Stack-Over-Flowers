package gr.ntua.ece.softeng.kidspiration.Dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import gr.ntua.ece.softeng.kidspiration.Administrator;
import gr.ntua.ece.softeng.kidspiration.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("AdminDao")
public class AdminDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Administrator validateUser(Login login) { // OK
        System.out.println("Entering login");
        List <Administrator> admins = jdbcTemplate.query("SELECT * FROM Admins WHERE username = ? AND password = ?",
                new Object[] { login.getUsername(), login.getPassword() }, new AdminMapper());

        System.out.println("Admin checked for login");
        return admins.size() > 0 ? admins.get(0) : null;
    }


    class AdminMapper implements RowMapper<Administrator> {

        public Administrator mapRow(ResultSet rs, int rowNum) throws SQLException {

            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String email = rs.getString("email");

            Administrator administrator = new Administrator(id, username, password, email);

            return administrator;
        }
    }

}
