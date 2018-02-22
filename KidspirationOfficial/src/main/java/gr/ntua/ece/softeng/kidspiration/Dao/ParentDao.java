package gr.ntua.ece.softeng.kidspiration.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("ParentDao")
public class ParentDao implements UserDao<Parent>{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addUser(Parent user) { //checked
        jdbcTemplate.update("INSERT INTO Parents (username, password, firstname, lastname, email, phone, wallet, spent_points, ban) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), user.getWallet(), user.getSpent_points(), user.isBan());
        System.out.println("User Added!!");
    }

    public Parent validateUser(Login login) { //checked
        System.out.println("Entering login");
        List <Parent> parents = jdbcTemplate.query("SELECT * FROM Parents WHERE username = ? AND password = ?",
                new Object[] { login.getUsername(), login.getPassword() }, new ParentMapper());

        System.out.println("Parent checked for login");
        return parents.size() > 0 ? parents.get(0) : null;
    }

    /*public void editUser(Parent user, int id) {
        jdbcTemplate.update("UPDATE Parents SET firstname = ? , lastname = ? WHERE id = ? ",
                user.getFirstname(), user.getLastname(), id);
        System.out.println("User Updated!!");
    }*/


    public void editUser(Parent user) {
        jdbcTemplate.update("UPDATE Parents SET id= ? , firstname= ? , lastname= ? , username= ? , password= ? , phone= ? , email= ? , wallet= ? , spent_points= ? , ban= ? WHERE id= ? ",
                user.getId(), user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword(), user.getPhone(), user.getEmail(), user.getWallet(), user.getSpent_points(), user.isBan(), user.getId());
        System.out.println("User Updated!!");
    }

    public void deleteUser(int id) {
        jdbcTemplate.update("DELETE FROM Parents WHERE username = ? ", id);
        System.out.println("Person Deleted!!");
    }

    public Parent find(int id) {
        Parent user =  jdbcTemplate.queryForObject("SELECT * FROM Parents where id= ? ",
                new Object[] { id }, new ParentMapper());
        return user;
    }

    public List <Parent> findAll() {
        List < Parent > users = jdbcTemplate.query("SELECT * FROM Parents", new ParentMapper());
        return users;
    }

    class ParentMapper implements RowMapper<Parent> {

        public Parent mapRow(ResultSet rs, int rowNum) throws SQLException {

            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            int wallet = rs.getInt("wallet");
            int spent_points = rs.getInt("spent_points");
            boolean ban= rs.getBoolean("ban");
            Parent parent = new Parent(id, username, password, firstname, lastname, email, phone, wallet, spent_points, ban);

            return parent;
        }
    }
}