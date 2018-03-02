package gr.ntua.ece.softeng.kidspiration.Services;

import java.util.List;

import gr.ntua.ece.softeng.kidspiration.Login;
import gr.ntua.ece.softeng.kidspiration.User;

public interface UserService<T> {
    public T addUser(T user);
    public T validateUser(Login login);
    public void editUser(T user, int id);
    public void deleteUser(int id);
    public T find(int id);
    public List<T> findAll();
}
