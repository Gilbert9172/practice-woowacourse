package seasonSix.chrismas.service;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.Order;
import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.event.EventManager;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.Payment;
import seasonSix.chrismas.utils.ConvertingUtils;
import seasonSix.chrismas.utils.PriceManagingUtil;

import java.util.List;
import java.util.Map;

public class PricingSystemService {

    public Payment managingPrice(EventManager manager, Order order) {
        Money originalPrice = order.getOriginalPrice();
        if (!EventManager.canApplyEvents(originalPrice)) {
            return Payment.noEventApplied(originalPrice);
        }
        Map<Food, Integer> purchase = order.getPurchase();
        Map<Event, Money> weekTargetEventPrice = weekTargetEventPrice(manager, purchase);
        Map<Event, Money> allTargetEventPrice = allTargetEventPrice(manager);
        Map<Event, Money> eventPrices = ConvertingUtils.mergeMap(weekTargetEventPrice, allTargetEventPrice);
        return Payment.newOne(originalPrice, eventPrices);
    }

    public Map<Event, Money> weekTargetEventPrice(EventManager manager, Map<Food, Integer> purchase) {
        Event event = manager.getSingleTypeEvent();
        return PriceManagingUtil.benefitPriceByEachFood(purchase, event);
    }

    public Map<Event, Money> allTargetEventPrice(EventManager manager) {
        List<Event> events = manager.getAllEventsExceptSingleType();
        return ConvertingUtils.mapToMap(events);
    }
}
