package gr.ntua.ece.softeng.kidspiration.Services;

import java.util.List;

import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.User;

public interface UserService<T> {
    public void addUser(T user);
    public T validateUser(Login login);
    public void editUser(T user, int id); //not checked
    public void deleteUser(int id); // not checked
    public T find(int id); // not checked
    public List<T> findAll(); // not checked
}
