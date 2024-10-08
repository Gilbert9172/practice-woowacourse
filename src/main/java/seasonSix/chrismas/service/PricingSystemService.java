package seasonSix.chrismas.service;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.event.EventManager;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.service.dto.Payment;
import seasonSix.chrismas.utils.PriceManagingUtil;

import java.util.List;
import java.util.Map;

import static seasonSix.chrismas.model.event.EventPriceTable.MIN_EVENT_APPLY_PRICE;

public class PricingSystemService {

    public Payment managingPrice(EventManager manager, Map<Food, Integer> orderSheet) {
        Money originalPrice = PriceManagingUtil.originalPrice(orderSheet);
        if (manager.canNotApplyEvents(originalPrice)) {
            return Payment.newOne(originalPrice, Money.zero, Money.zero);
        }
        // Events
        Event singleTypeEvent = manager.getSingleTypeEvent();
        Event prizeTypeEvent = manager.getPrizeTypeEvent();
        List<Event> events = manager.getAllEventsExceptSingleType();

        // Calculating prices
        Money benefitByEachFood = PriceManagingUtil.benefitPriceByEachFood(orderSheet, singleTypeEvent);
        Money benefitForAllFood = PriceManagingUtil.benefitPriceForAllFood(events);
        Money totalBenefitPrice = benefitByEachFood.add(benefitForAllFood);
        Money discountPrice = PriceManagingUtil.discountPrice(originalPrice, totalBenefitPrice, prizeTypeEvent);
        return Payment.newOne(originalPrice, totalBenefitPrice, discountPrice);
    }

}
