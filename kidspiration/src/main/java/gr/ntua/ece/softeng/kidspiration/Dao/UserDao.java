package gr.ntua.ece.softeng.kidspiration.Dao;

import java.util.List;
import gr.ntua.ece.softeng.kidspiration.User;

public interface UserDao<T> {
    public void addUser(T user);
    public void editUser(T user, int id);
    public void deleteUser(int id);
    public T find(int id);
    public List<T> findAll();
}
