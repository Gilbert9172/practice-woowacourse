package seasonSix.chrismas.repository;

import seasonSix.chrismas.model.event.*;

import java.util.ArrayList;
import java.util.List;

public class EventRepository {

    private List<Event> events = new ArrayList<>();

    public void initializeEvents(int today) {
        events = List.of(
                new WeekdaysEvent(),
                new WeekendsEvent(),
                new SpecialEvent(),
                new PrizeEvent(),
                new ChristmasEvent(today)
        );
    }
}
