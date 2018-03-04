package gr.ntua.ece.softeng.kidspiration.Services;

import java.util.List;

public interface EventService<T> {
    public void addEvent(T event);
    public void editEvent(T event, int id);
    public void deleteEvent(int id);
    public T find(int id);
    public List<T> findAll();
}
