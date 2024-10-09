package seasonSix.chrismas.repository;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.Order;
import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.event.EventManager;

import java.util.ArrayList;
import java.util.List;

public class EventRepository {

    public List<Event> findTodayEvents(int date, Order order) {
        List<Event> events = new ArrayList<>();
        Money originalPrice = order.getOriginalPrice();
        boolean canApplyEvents = EventManager.canApplyEvents(originalPrice);
        boolean canReceivePrize = EventManager.canReceivePrize(originalPrice);
        boolean canApplyXmasEvent = EventManager.canApplyXmasEvent(date);
        boolean canApplySpecialEvent = EventManager.canApplySpecialEvent(date);
        if (!canApplyEvents) {
            return events;
        }
        if (canApplyEvents) {
            Event event = EventManager.applyWeekEvent(date);
            events.add(event);
        }
        if (canApplyXmasEvent) {
            Event event = EventManager.applyXmasEvent(date);
            events.add(event);
        }
        if (canReceivePrize) {
            Event event = EventManager.applyPrizeEvent();
            events.add(event);
        }
        if (canApplySpecialEvent) {
            Event event = EventManager.applySpecialEvent();
            events.add(event);
        }
        return events;
    }
}
