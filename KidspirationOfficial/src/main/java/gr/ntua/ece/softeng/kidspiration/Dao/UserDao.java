package gr.ntua.ece.softeng.kidspiration.Dao;

import java.util.List;

import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.User;

public interface UserDao<T> {
    public void addUser(T user);
    public void editUser(T user); //not checked
    public void deleteUser(int id); //not checked
    public T find(int id); //not checked
    public T validateUser (Login login);
    public List<T> findAll();
}