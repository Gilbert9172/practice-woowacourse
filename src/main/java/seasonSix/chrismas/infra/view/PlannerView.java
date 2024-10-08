package seasonSix.chrismas.infra.view;

import seasonSix.chrismas.model.CustomerPlan;
import seasonSix.chrismas.model.planner.Planner;
import seasonSix.chrismas.service.dto.Payment;

import java.util.Map;

public class PlannerView {

    private Map<String, Integer> purchase;
    private String prize;
    private int prizeCount;
    private String events;
    private long originalPrice;
    private long benefitPrice;
    private long discountPrice;
    private long finalPrice;
    private String badge;

    public static PlannerView from(Planner planner, CustomerPlan customerPlan) {
        Payment payment = customerPlan.getPayment();
        return new PlannerView(
                customerPlan.getPurchase(),
                customerPlan.getPrizeName(),
                customerPlan.getPrizeCount(),
                customerPlan.getBadge().name(),
                customerPlan.getAppliedEvents(),
                payment.getOriginalPrice().getVal(),
                payment.getBenefitPrice().getVal(),
                payment.getDiscountPrice().getVal(),
                payment.getFinalPrice().getVal()
        );
    }

    private PlannerView(Map<String, Integer> purchase,
                       String prize,
                       int prizeCount,
                       String badge,
                       String events,
                       long originalPrice,
                       long benefitPrice,
                       long discountPrice,
                       long finalPrice) {
        this.purchase = purchase;
        this.prize = prize;
        this.prizeCount = prizeCount;
        this.events = events;
        this.originalPrice = originalPrice;
        this.benefitPrice = benefitPrice;
        this.discountPrice = discountPrice;
        this.finalPrice = finalPrice;
        this.badge = badge;
    }
}
