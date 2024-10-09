package seasonSix.chrismas.service.dto;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.utils.PriceManagingUtil;

import java.util.HashMap;
import java.util.Map;

public class Payment {

    private Money originalPrice;
    private Money benefitPrice;
    private Money discountPrice;
    private Money finalPrice;

    Map<Event, Money> eventPrices = new HashMap<>();

    private Payment(Money originalPrice, Money benefitPrice, Money discountPrice, Money finalPrice, Map<Event, Money> eventPrices) {
        this.originalPrice = originalPrice;
        this.benefitPrice = benefitPrice;
        this.discountPrice = discountPrice;
        this.finalPrice = finalPrice;
        this.eventPrices = eventPrices;
    }

    public static Payment newOne(Money originalPrice, Map<Event, Money> eventPrices) {
        Money totalBenefitPrice = PriceManagingUtil.totalBenefitPrice(eventPrices);
        Money totalDiscountPrice = PriceManagingUtil.totalDiscountPrice(eventPrices);
        Money finalPrice = PriceManagingUtil.getFinalPrice(originalPrice, eventPrices);
        return new Payment(
                originalPrice,
                totalBenefitPrice,
                totalDiscountPrice,
                finalPrice,
                eventPrices
        );
    }

    public Money getOriginalPrice() {
        return originalPrice;
    }

    public Money getBenefitPrice() {
        return benefitPrice;
    }

    public Money getDiscountPrice() {
        return discountPrice;
    }

    public Money getFinalPrice() {
        return finalPrice;
    }

    public Map<Event, Money> getEventPrices() {
        return eventPrices;
    }
}
