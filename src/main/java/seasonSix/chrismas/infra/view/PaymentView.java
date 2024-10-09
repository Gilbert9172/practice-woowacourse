package seasonSix.chrismas.infra.view;

import seasonSix.chrismas.service.dto.Payment;
import seasonSix.chrismas.utils.ConvertingUtils;

import java.util.HashMap;
import java.util.Map;

public class PaymentView {

    private long originalPrice;
    private long benefitPrice;
    private long discountPrice;
    private long finalPrice;
    private Map<String, Long> eventPrices = new HashMap<>();

    public static PaymentView from(Payment payment) {

        return new PaymentView(
                payment.getOriginalPrice().getVal(),
                payment.getBenefitPrice().getVal(),
                payment.getDiscountPrice().getVal(),
                payment.getFinalPrice().getVal(),
                ConvertingUtils.mapToStringLongMap(payment.getEventPrices())
        );
    }

    private PaymentView(long originalPrice, long benefitPrice, long discountPrice, long finalPrice, Map<String, Long> eventPrices) {
        this.originalPrice = originalPrice;
        this.benefitPrice = benefitPrice;
        this.discountPrice = discountPrice;
        this.finalPrice = finalPrice;
        this.eventPrices = eventPrices;
    }

    public long getOriginalPrice() {
        return originalPrice;
    }

    public long getBenefitPrice() {
        return benefitPrice;
    }

    public long getDiscountPrice() {
        return discountPrice;
    }

    public long getFinalPrice() {
        return finalPrice;
    }

    public Map<String, Long> getEventPrices() {
        return eventPrices;
    }
}
