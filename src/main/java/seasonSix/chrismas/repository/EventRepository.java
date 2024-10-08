package seasonSix.chrismas.repository;

import seasonSix.chrismas.model.event.*;
import seasonSix.chrismas.service.dto.DateInfoDTO;

import java.util.ArrayList;
import java.util.List;

public class EventRepository {

    public List<Event> findTodayEvents(DateInfoDTO dateInfo) {
        List<Event> events = new ArrayList<>();
        if (dateInfo.isWeekend()) {
            events.add(new WeekendsEvent());
        }
        if (!dateInfo.isWeekend()) {
            events.add(new WeekdaysEvent());
        }
        if (dateInfo.isSpecialDay()) {
            events.add(new SpecialEvent());
        }
        if (dateInfo.isOnChristmasSeason()) {
            events.add(new ChristmasEvent(dateInfo.getDate()));
        }
        events.add(new PrizeEvent());
        return events;
    }
}
