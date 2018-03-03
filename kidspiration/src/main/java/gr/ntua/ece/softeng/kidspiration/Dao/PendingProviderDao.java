package gr.ntua.ece.softeng.kidspiration.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.PendingProvider;
import gr.ntua.ece.softeng.kidspiration.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("PendingProviderDao")
public class PendingProviderDao implements UserDao<PendingProvider>{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addUser(PendingProvider user) {  // OK
        jdbcTemplate.update("INSERT INTO PendingProviders (username, password, firstname, lastname, email, phone, businessName, bankAccount, salt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), user.getBusinessName(), user.getBankAccount(), user.getSalt());
        System.out.println("User Added!!");
    }

    public PendingProvider validateUser(Login login) {
        return null;
    }  // checked

    public void editUser(PendingProvider user, int id) {
        jdbcTemplate.update("UPDATE PendingProviders SET firstname = ? , lastname = ? WHERE id = ? ",
                user.getFirstname(), user.getLastname(), id);
        System.out.println("User Updated!!");
    }

    public void deleteUser(int id) { // OK
        jdbcTemplate.update("DELETE FROM PendingProviders WHERE id = ? ", id);
        System.out.println("PendingProvider Deleted!!");
    }

    public PendingProvider find(int id) {  // OK
        PendingProvider user = jdbcTemplate.queryForObject("SELECT * FROM PendingProviders where id = ? ",
                new Object[] { id }, new PendingProviderMapper());
        // could be a list
        return user;
    }

    public PendingProvider findByUsername (String username) { // CHECKING

        List <PendingProvider> users = jdbcTemplate.query("SELECT * FROM PendingProviders where username = ? ",
                new Object[] { username }, new PendingProviderMapper()); // could be query, not needed however

        return users.size() > 0 ? users.get(0) : null;
    }

    public PendingProvider findByEmail (String email) { // CHECKING

        List <PendingProvider> users = jdbcTemplate.query("SELECT * FROM PendingProviders where email = ? ",
                new Object[] { email }, new PendingProviderMapper());

        return users.size() > 0 ? users.get(0) : null;
    }

    public List <PendingProvider> findAll() { // OK
        List < PendingProvider > users = jdbcTemplate.query("SELECT * FROM PendingProviders", new PendingProviderMapper());
        return users;
    }



    class PendingProviderMapper implements RowMapper<PendingProvider> {

        public PendingProvider mapRow(ResultSet rs, int rowNum) throws SQLException {

            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            String businessName = rs.getString("businessName");
            String bankAccount = rs.getString("bankAccount");
            String salt = rs.getString("salt");
            PendingProvider provider = new PendingProvider(id, username, password, firstname, lastname, email, phone, businessName, bankAccount, salt);

            return provider;
        }
    }
}

