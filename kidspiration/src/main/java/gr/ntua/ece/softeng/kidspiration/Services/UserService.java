package gr.ntua.ece.softeng.kidspiration.Services;

import java.util.List;

import gr.ntua.ece.softeng.kidspiration.User;

public interface UserService<T> {
    public void addUser(T user);
    public void editUser(T user, int id);
    public void deleteUser(int id);
    public T find(int username);
    public List<T> findAll();
}
