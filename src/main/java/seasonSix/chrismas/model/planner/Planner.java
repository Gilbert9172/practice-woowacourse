package seasonSix.chrismas.model.planner;

import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.event.EventManager;

import java.util.List;

public class Planner {
    private int date;
    private boolean isWeekend;
    private boolean isSpecialDay;

    public static Planner newOne(int date, boolean isWeekend, boolean isSpecialDay) {
        return new Planner(date, isWeekend, isSpecialDay);
    }

    public Planner(int date, boolean isWeekend, boolean isSpecialDay) {
        this.date = date;
        this.isWeekend = isWeekend;
        this.isSpecialDay = isSpecialDay;
    }

    public int getDate() {
        return date;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public boolean isSpecialDay() {
        return isSpecialDay;
    }
}
