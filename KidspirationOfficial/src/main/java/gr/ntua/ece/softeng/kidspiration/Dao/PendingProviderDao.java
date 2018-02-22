package gr.ntua.ece.softeng.kidspiration.Dao;

import java.util.List;

import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.PendingProvider;
import gr.ntua.ece.softeng.kidspiration.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("PendingProviderDao")
public class PendingProviderDao implements UserDao<PendingProvider>{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addUser(PendingProvider user) {  // checked
        jdbcTemplate.update("INSERT INTO PendingProviders (username, password, firstname, lastname, email, phone, businessName, bankAccount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), user.getBusinessName(), user.getBankAccount());
        System.out.println("User Added!!");
    }

    public PendingProvider validateUser(Login login) {
        return null;
    }  // checked

    public void editUser(PendingProvider user) {
        jdbcTemplate.update("UPDATE PendingProviders SET firstname = ? , lastname = ? WHERE id = ? ",
                user.getFirstname(), user.getLastname());
        System.out.println("User Updated!!");
    }

    public void deleteUser(int id) {
        jdbcTemplate.update("DELETE FROM PendingProviders WHERE username = ? ", id);
        System.out.println("Person Deleted!!");
    }

    public PendingProvider find(int id) {
        PendingProvider user = (PendingProvider) jdbcTemplate.queryForObject("SELECT * FROM PendingProviders where username = ? ",
                new Object[] { id }, new BeanPropertyRowMapper(User.class));

        return user;
    }

    public List <PendingProvider> findAll() {
        List < PendingProvider > users = jdbcTemplate.query("SELECT * FROM PendingProviders", new BeanPropertyRowMapper(User.class));
        return users;
    }
}
