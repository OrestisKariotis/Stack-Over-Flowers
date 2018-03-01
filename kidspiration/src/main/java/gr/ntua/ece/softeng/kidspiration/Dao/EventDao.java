package gr.ntua.ece.softeng.kidspiration.Dao;

import java.util.List;

public interface EventDao<T> {
    public void addEvent(T event);
    public void editEvent(T event, int id); //not checked
    public void deleteEvent(int id); //not checked
    public T find(int id); //not checked
    public List<T> findAll(); // not checked
}
