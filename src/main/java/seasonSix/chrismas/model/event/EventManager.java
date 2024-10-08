package seasonSix.chrismas.model.event;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.event.exception.EventNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static seasonSix.chrismas.model.event.EventPriceTable.MIN_EVENT_APPLY_PRICE;
import static seasonSix.chrismas.model.event.EventType.isSingleType;

public class EventManager {

    private List<Event> events = new ArrayList<>();

    public EventManager(List<Event> events) {
        this.events = events;
    }

    public boolean canNotApplyEvents(Money price) {
        return price.lowerThen(MIN_EVENT_APPLY_PRICE.getMoney());
    }

    public Event getSingleTypeEvent() {
        return events.stream()
                .filter(source -> isSingleType(source.getType()))
                .findFirst()
                .orElseThrow(EventNotFoundException::new);
    }

    public List<Event> getAllEventsExceptSingleType() {
        return events.stream()
                .filter(source -> !isSingleType(source.getType()))
                .toList();
    }

    public Event getPrizeTypeEvent() {
        return events.stream()
                .filter(source -> isSingleType(source.getType()))
                .findFirst()
                .orElseThrow(EventNotFoundException::new);
    }
}
