package gr.ntua.ece.softeng.kidspiration.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("ParentDao")
public class ParentDao {//implements UserDao<Parent>{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addUser(Parent user) { // OK
        jdbcTemplate.update("INSERT INTO Parents (username, password, firstname, lastname, email, phone, wallet, spent_points, ban, salt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), 0, 0, false, user.getSalt());//user.getWallet(), user.getSpent_points(), user.isBan());
        System.out.println("User Added!!");
    }

    public Parent validateUser(Login login) { // OK
        System.out.println("Entering login");
        List <Parent> parents = jdbcTemplate.query("SELECT * FROM Parents WHERE username = ? AND password = ?",
                new Object[] { login.getUsername(), login.getPassword() }, new ParentMapper());

        System.out.println("Parent checked for login");
        return parents.size() > 0 ? parents.get(0) : null;
    }

    public void editUser(Parent user, int id) {  // OK
        System.out.println("Entering Parent Base for Edit");
        jdbcTemplate.update("UPDATE Parents SET username = ? , password = ?, firstname = ?, lastname = ?, email = ?, phone = ?, wallet = ?, spent_points = ?, ban = ? WHERE id = ? ",
                user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), user.getWallet(), user.getSpent_points(), user.isBan(), id);
        System.out.println("Parent Base edited!!!");

        // id can be omitted because it is already included in parent
        // some arguments in query will be omitted
    }

    public void editInfo(int id, String phone) {
        jdbcTemplate.update("UPDATE Parents SET phone = ? WHERE id = ? ", phone, id);
    }

    public void deleteUser(int id) { // OK
        jdbcTemplate.update("DELETE FROM Parents WHERE id = ? ", id);
        System.out.println("Person Deleted!!");
    }

    public Parent find(int id) {  // checked
        List<Parent> users = jdbcTemplate.query("SELECT * FROM Parents where id = ? ",
                new Object[] { id }, new ParentMapper()); // could be query, not needed however

        return users.size() > 0 ? users.get(0) : null;
    }

    public Parent findByUsername (String username) { // CHECKING

        List <Parent> users = jdbcTemplate.query("SELECT * FROM Parents where username = ? ",
                new Object[] { username }, new ParentMapper());

        return users.size() > 0 ? users.get(0) : null;
    }

    public Parent findByEmail (String email) { // CHECKING

        List <Parent> users = jdbcTemplate.query("SELECT * FROM Parents where email = ? ",
                new Object[] { email }, new ParentMapper());

        return users.size() > 0 ? users.get(0) : null;
    }

    public List <Parent> findAll() {  //checked
        List < Parent > users = jdbcTemplate.query("SELECT * FROM Parents", new ParentMapper());
        return users;
    }

    public void updatePoints(int id, int new_wallet, int new_spent_points) { // OK
        System.out.println("Entering Update Points");
        jdbcTemplate.update("UPDATE Parents SET wallet = ?, spent_points = ? WHERE id = ? ", new_wallet, new_spent_points, id);
        System.out.println("Leaving Update Points");
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
            boolean ban = rs.getBoolean("ban");
            String salt = rs.getString("salt");
            Parent parent = new Parent(id, username, password, firstname, lastname, email, phone, wallet, spent_points, ban, salt);

            return parent;
        }
    }
}
