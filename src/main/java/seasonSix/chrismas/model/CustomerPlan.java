package seasonSix.chrismas.model;

import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.event.EventManager;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.service.dto.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerPlan {

    private Order order;
    private Payment payment;
    private boolean prizeReceived;
    private String prizeName;
    private int prizeCount;
    private Badge badge;
    private List<Event> appliedEvents = new ArrayList<>();

    private CustomerPlan(Order order, Payment payment, List<Event> events) {
        this.order = order;
        this.payment = payment;
        this.badge = Badge.NONE;
        this.appliedEvents = events;
    }

    public static CustomerPlan newOne(Order order, Payment payment, List<Event> events) {
        return new CustomerPlan(order, payment, events);
    }

    public void assignBadge() {
        this.badge = Badge.assignBy(order.getOriginalPrice());
    }

    public void receivePrizeIfNecessary(Food prize) {
        boolean canReceivePrize = EventManager.canReceivePrize(order.getOriginalPrice());
        if (canReceivePrize) {
            this.prizeReceived = true;
            this.prizeName = prize.getName();
            this.prizeCount ++;
        }
    }

    public Map<String, Integer> getPurchase() {
        return order.getPurchase().entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getName(), Map.Entry::getValue)
                );
    }

    public Payment getPayment() {
        return payment;
    }

    public int getPrizeCount() {
        return prizeCount;
    }

    public Badge getBadge() {
        return badge;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public int getOrderDate() {
        return order.getDate();
    }
}
