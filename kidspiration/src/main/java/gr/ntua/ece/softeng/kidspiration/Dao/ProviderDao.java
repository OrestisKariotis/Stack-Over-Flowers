package gr.ntua.ece.softeng.kidspiration.Dao;

import gr.ntua.ece.softeng.kidspiration.CurrentEventView;
import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.Provider;
import gr.ntua.ece.softeng.kidspiration.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Qualifier("ProviderDao")
public class ProviderDao implements UserDao<Provider> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addUser(Provider user) { // OK
        jdbcTemplate.update("INSERT INTO Providers (username, password, firstname, lastname, email, phone, businessName, bankAccount, profit, rights_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), user.getBusinessName(), user.getBankAccount(), user.getProfit(), user.getRights_code());
        System.out.println("Provider Added!!");
    }

    public Provider validateUser(Login login) { // OK
        List <Provider> providers = jdbcTemplate.query("SELECT * FROM Providers WHERE username = ? AND password = ?",
                new Object[] { login.getUsername(), login.getPassword() }, new ProviderMapper());
        System.out.println("Provider checked for login!");
        return providers.size() > 0 ? providers.get(0) : null;
    }

    public void editUser(Provider user, int id) { // OK
        jdbcTemplate.update("UPDATE Providers SET username = ?, password = ?, firstname = ?, lastname = ?, email = ?, phone = ?, businessName = ?, bankAccount = ?, profit = ?, rights_code = ? WHERE id = ? ",
                user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), user.getBusinessName(), user.getBankAccount(), user.getProfit(), user.getRights_code(), id);
        System.out.println("User Updated!!");
    }

    public void deleteUser(int id) { // OK
        jdbcTemplate.update("DELETE FROM Providers WHERE id = ? ", id);
        System.out.println("Person Deleted!!");
    }

    public Provider find(int id) {  // OK
        Provider user = jdbcTemplate.queryForObject("SELECT * FROM Providers where id = ? ",
                new Object[] { id }, new ProviderMapper());

        return user;
    }

    public List<Provider> findAll() { // OK
        List < Provider > users = jdbcTemplate.query("SELECT * FROM Providers", new ProviderMapper());
        return users;
    }

    class ProviderMapper implements RowMapper<Provider> {

        public Provider mapRow(ResultSet rs, int rowNum) throws SQLException {

            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            String businessName = rs.getString("businessName");
            String bankAccount = rs.getString("bankAccount");
            double profit = rs.getDouble("profit");
            byte rights_code = rs.getByte("rights_code");
            Provider provider = new Provider(id, username, password, firstname, lastname, email, phone, businessName, bankAccount, profit, rights_code);

            return provider;
        }
    }

}
