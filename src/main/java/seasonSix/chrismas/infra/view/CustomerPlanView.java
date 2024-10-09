package seasonSix.chrismas.infra.view;

import seasonSix.chrismas.model.CustomerPlan;
import seasonSix.chrismas.model.planner.Planner;
import seasonSix.chrismas.service.dto.Payment;

import java.util.Map;

public class CustomerPlanView {

    private Map<String, Integer> purchase;
    private String prizeName;
    private int prizeCount;
    private String badge;
    private long originalPrice;
    private long benefitPrice;
    private long discountPrice;
    private long finalPrice;
    private Map<String, Long> events;

    public static CustomerPlanView from(CustomerPlan customerPlan) {
        PaymentView paymentView = PaymentView.from(customerPlan.getPayment());
        return new CustomerPlanView(
                customerPlan.getPurchase(),
                customerPlan.getPrizeName(),
                customerPlan.getPrizeCount(),
                customerPlan.getBadge().name(),
                paymentView.getOriginalPrice(),
                paymentView.getBenefitPrice(),
                paymentView.getDiscountPrice(),
                paymentView.getFinalPrice(),
                paymentView.getEventPrices()
        );
    }

    private CustomerPlanView(Map<String, Integer> purchase,
                             String prizeName,
                             int prizeCount,
                             String badge,
                             long originalPrice,
                             long benefitPrice,
                             long discountPrice,
                             long finalPrice,
                             Map<String, Long> events) {
        this.purchase = purchase;
        this.prizeName = prizeName;
        this.prizeCount = prizeCount;
        this.badge = badge;
        this.originalPrice = originalPrice;
        this.benefitPrice = benefitPrice;
        this.discountPrice = discountPrice;
        this.finalPrice = finalPrice;
        this.events = events;
    }
}
