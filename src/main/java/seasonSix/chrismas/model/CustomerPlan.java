package seasonSix.chrismas.model;

import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.event.EventPriceTable;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.service.dto.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerPlan {

    private Map<Food, Integer> purchase;
    private Payment payment;
    private boolean prizeReceived;
    private String prizeName;
    private int prizeCount;
    private Badge badge;
    private List<Event> appliedEvents = new ArrayList<>();

    public static CustomerPlan newOne(Map<Food, Integer> purchase, Payment payment) {
        return new CustomerPlan(purchase, payment);
    }

    private CustomerPlan(Map<Food, Integer> purchase, Payment payment) {
        this.purchase = purchase;
        this.payment = payment;
        this.badge = Badge.NONE;
    }

    public void assignAppliedEvents(List<Event> events) {
        if (payment.getOriginalPrice().boeThan(EventPriceTable.MIN_EVENT_APPLY_PRICE.getMoney())) {
            this.appliedEvents = events;
        }
    }

    public void assignBadge() {
        this.badge = Badge.assignBy(this.payment.getOriginalPrice());
    }

    public void isPrizeReceivable(Food food) {
        boolean prizeReceivable = this.payment.isPrizeReceivable();
        if (prizeReceivable) {
            this.prizeReceived = true;
            this.prizeName = food.getName();
            this.prizeCount ++;
        }
    }

    public Map<String, Integer> getPurchase() {
        return purchase.entrySet()
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

    public String getAppliedEvents() {
        if (appliedEvents.isEmpty()) {
            return "없음";
        }
        List<String> eventTitles = appliedEvents.stream().map(Event::getTitle).toList();
        return String.join(",", eventTitles);
    }
}
