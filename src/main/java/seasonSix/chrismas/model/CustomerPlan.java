package seasonSix.chrismas.model;

import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.service.dto.Payment;

import java.util.Map;

public class CustomerPlan {

    private Map<Food, Integer> purchase;
    private Payment payment;
    private boolean prizeReceived;
    private int prizeCount;
    private Badge badge;

    public static CustomerPlan newOne(Map<Food, Integer> purchase, Payment payment) {
        return new CustomerPlan(purchase, payment);
    }

    public CustomerPlan(Map<Food, Integer> purchase, Payment payment) {
        this.purchase = purchase;
        this.payment = payment;
    }

    public void assignBadge() {
        this.badge = Badge.assignBy(this.payment.getOriginalPrice());
    }

    public void isPrizeReceivable() {
        if ( this.payment.isPrizeReceivable()) {
            this.prizeReceived = true;
            this.prizeCount = 1;
        }
    }
}
