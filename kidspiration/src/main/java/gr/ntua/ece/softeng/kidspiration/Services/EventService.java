package gr.ntua.ece.softeng.kidspiration.Services;

import java.util.List;

public interface EventService<T> {
    public void addEvent(T event);
    public void editEvent(T event, int id); //not checked
    public void deleteEvent(int id); // not checked
    public T find(int id); // not checked
    public List<T> findAll(); // not checked
}
