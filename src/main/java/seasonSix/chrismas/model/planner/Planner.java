package seasonSix.chrismas.model.planner;

import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.event.EventManager;

import java.util.List;

public class Planner {
    private int date;
    private boolean isWeekend;
    private boolean isSpecialDay;

    private EventManager eventManager;

    public static Planner newOne(int date, boolean isWeekend, boolean isSpecialDay, List<Event> events) {
        return new Planner(date, isWeekend, isSpecialDay, new EventManager(events));
    }

    private Planner(int date, boolean isWeekend, boolean isSpecialDay, EventManager eventManager) {
        this.date = date;
        this.isWeekend = isWeekend;
        this.isSpecialDay = isSpecialDay;
        this.eventManager = eventManager;
    }

    public int getDate() {
        return date;
    }

    public EventManager getEventManager() {
        return eventManager;
    }
}
