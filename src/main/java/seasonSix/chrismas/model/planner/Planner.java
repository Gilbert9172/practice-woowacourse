package seasonSix.chrismas.model.planner;

import seasonSix.chrismas.model.event.Event;

import java.util.List;

public class Planner {
    private int date;
    private boolean isWeekend;
    private boolean isSpecialDay;
    private List<Event> events;

    public static Planner newOne(int date, boolean isWeekend, boolean isSpecialDay, List<Event> events) {
        return new Planner(date, isWeekend, isSpecialDay, events);
    }

    private Planner(int date, boolean isWeekend, boolean isSpecialDay, List<Event> events) {
        this.date = date;
        this.isWeekend = isWeekend;
        this.isSpecialDay = isSpecialDay;
        this.events = events;
    }
}
