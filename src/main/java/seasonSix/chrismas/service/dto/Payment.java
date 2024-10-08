package seasonSix.chrismas.service.dto;

import seasonSix.chrismas.common.Money;

import static seasonSix.chrismas.model.event.EventPriceTable.MIN_RECEIVABLE_PRICE;

public class Payment {
    Money originalPrice;
    Money benefitPrice;
    Money discountPrice;
    Money finalPrice;

    public static Payment newOne(Money originalPrice, Money benefitPrice, Money discountPrice) {
        return new Payment(originalPrice, benefitPrice, discountPrice);
    }

    private Payment(Money originalPrice, Money benefitPrice, Money discountPrice) {
        this.originalPrice = originalPrice;
        this.benefitPrice = benefitPrice;
        this.discountPrice = discountPrice;
        this.finalPrice = originalPrice.minus(discountPrice);
    }

    public boolean isPrizeReceivable() {
        return this.originalPrice.boeThan(MIN_RECEIVABLE_PRICE.getMoney());
    }

    public Money getOriginalPrice() {
        return originalPrice;
    }
}
