package seasonSix.chrismas.infra.view;

import seasonSix.chrismas.model.Payment;
import seasonSix.chrismas.utils.ConvertingUtils;

import java.util.HashMap;
import java.util.Map;

public class PaymentView {

    private String originalPrice;
    private String benefitPrice;
    private String discountPrice;
    private String finalPrice;
    private Map<String, String> eventPrices = new HashMap<>();

    public static PaymentView from(Payment payment) {

        return new PaymentView(
                payment.getOriginalPrice().toWon(),
                payment.getBenefitPrice().toWon(),
                payment.getDiscountPrice().toWon(),
                payment.getFinalPrice().toWon(),
                ConvertingUtils.mapToStringMap(payment.getEventPrices())
        );
    }

    private PaymentView(String originalPrice, String benefitPrice, String discountPrice, String finalPrice, Map<String, String> eventPrices) {
        this.originalPrice = originalPrice;
        this.benefitPrice = benefitPrice;
        this.discountPrice = discountPrice;
        this.finalPrice = finalPrice;
        this.eventPrices = eventPrices;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public String getBenefitPrice() {
        return benefitPrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public Map<String, String> getEventPrices() {
        return eventPrices;
    }
}
