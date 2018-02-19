package gr.ntua.ece.softeng.kidspiration.Dao;

import java.util.List;

import gr.ntua.ece.softeng.kidspiration.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("ParentDao")
public class ParentDao implements UserDao<Parent>{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addUser(Parent user) {
        jdbcTemplate.update("INSERT INTO Parents (username, password, firstname, lastname, email, phone, available_points, spent_points, ban) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), user.getAvailable_points(), user.getSpent_points(), user.isBan());
        System.out.println("User Added!!");
    }

    public void editUser(Parent user, int id) {
        jdbcTemplate.update("UPDATE Parents SET firstname = ? , lastname = ? WHERE id = ? ",
                user.getFirstname(), user.getLastname(), id);
        System.out.println("User Updated!!");
    }

    public void deleteUser(int id) {
        jdbcTemplate.update("DELETE FROM Parents WHERE username = ? ", id);
        System.out.println("Person Deleted!!");
    }

    public Parent find(int id) {
        Parent user = (Parent) jdbcTemplate.queryForObject("SELECT * FROM Parents where username = ? ",
                new Object[] { id }, new BeanPropertyRowMapper(Parent.class));

        return user;
    }

    public List <Parent> findAll() {
        List < Parent > users = jdbcTemplate.query("SELECT * FROM Parents", new BeanPropertyRowMapper(Parent.class));
        return users;
    }
}
