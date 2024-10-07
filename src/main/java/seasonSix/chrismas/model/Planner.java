package seasonSix.chrismas.model;

import seasonSix.chrismas.model.event.Event;

import java.util.List;

public class Planner {
    private int date;
    private boolean isWeekend;
    private boolean isSpecial;
    private List<Event> events;

    public Planner(int date, boolean isWeekend, boolean isSpecial, List<Event> events) {
        this.date = date;
        this.isWeekend = isWeekend;
        this.isSpecial = isSpecial;
        this.events = events;
    }
}
