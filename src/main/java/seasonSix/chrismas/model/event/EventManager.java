package seasonSix.chrismas.model.event;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.event.exception.EventNotFoundException;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

import static seasonSix.chrismas.model.event.EventPriceTable.minEventApplyPrice;
import static seasonSix.chrismas.model.event.EventPriceTable.minPrizeReceivablePrice;
import static seasonSix.chrismas.model.event.EventType.isSingleType;

public class EventManager {

    private List<Event> events = new ArrayList<>();
    private Food prize;

    private EventManager(List<Event> events, Food prize) {
        this.events = events;
        this.prize = prize;
    }

    public static EventManager newOne(List<Event> events, Food prize) {
        return new EventManager(events, prize);
    }

    public Food getPrize() {
        return prize;
    }

    public static boolean canApplyEvents(Money price) {
        return price.boeThan(minEventApplyPrice());
    }

    public static boolean canReceivePrize(Money price) {
        return price.boeThan(minPrizeReceivablePrice());
    }

    public static boolean canApplyXmasEvent(int date) {
        return DateUtil.isOnChristmasSeason(date);
    }

    public static boolean canApplySpecialEvent(int date) {
        return DateUtil.isSpecialDay(date);
    }

    public static Event applyWeekEvent(int date) {
        boolean isWeekend = DateUtil.isWeekend(date);
        if (isWeekend) {
            return new WeekendsEvent();
        }
        return new WeekdaysEvent();
    }

    public static Event applyPrizeEvent() {
        return new PrizeEvent();
    }

    public static Event applyXmasEvent(int date) {
        return new ChristmasEvent(date);
    }

    public static Event applySpecialEvent() {
        return new SpecialEvent();
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

    public List<Event> getEvents() {
        return events;
    }
}
