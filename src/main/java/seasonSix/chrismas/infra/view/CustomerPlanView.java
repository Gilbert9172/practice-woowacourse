package seasonSix.chrismas.infra.view;

import seasonSix.chrismas.model.CustomerPlan;

import java.util.Map;

public class CustomerPlanView {

    private int date;
    private Map<String, Integer> purchase;
    private String prizeName;
    private int prizeCount;
    private String badge;
    private String originalPrice;
    private String benefitPrice;
    private String discountPrice;
    private String finalPrice;
    private Map<String, String> events;

    public static CustomerPlanView from(CustomerPlan customerPlan) {
        PaymentView paymentView = PaymentView.from(customerPlan.getPayment());
        return new CustomerPlanView(
                customerPlan.getOrderDate(),
                customerPlan.getPurchase(),
                customerPlan.getPrizeName(),
                customerPlan.getPrizeCount(),
                customerPlan.getBadge().getTitle(),
                paymentView.getOriginalPrice(),
                paymentView.getBenefitPrice(),
                paymentView.getDiscountPrice(),
                paymentView.getFinalPrice(),
                paymentView.getEventPrices()
        );
    }

    private CustomerPlanView(int date,
                            Map<String, Integer> purchase,
                             String prizeName,
                             int prizeCount,
                             String badge,
                             String originalPrice,
                             String benefitPrice,
                             String discountPrice,
                             String finalPrice,
                             Map<String, String> events) {
        this.date = date;
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

    public int getDate() {
        return date;
    }

    public Map<String, Integer> getPurchase() {
        return purchase;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public int getPrizeCount() {
        return prizeCount;
    }

    public String getBadge() {
        return badge;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public String getBenefitPrice() {
        return benefitPrice;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public Map<String, String> getEvents() {
        return events;
    }
}
