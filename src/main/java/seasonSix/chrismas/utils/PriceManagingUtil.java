package seasonSix.chrismas.utils;

import seasonSix.chrismas.common.MagicNums;
import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.food.Food;

import java.util.List;
import java.util.Map;

import static seasonSix.chrismas.model.event.EventPriceTable.CHRISTMAS_DAILY;
import static seasonSix.chrismas.model.event.EventPriceTable.CHRISTMAS_DEFAULT;
import static seasonSix.chrismas.model.event.EventType.isPrizeType;

public class PriceManagingUtil {

    public static Money christmasEventDiscount(int date) {
        if (MagicNums.isAfterChristmas(date)) {
            return Money.zero;
        }
        Money dailyDiscount = CHRISTMAS_DAILY.getMoney()
                .multiply(date - 1);
        Money defaultDiscount = CHRISTMAS_DEFAULT.getMoney();
        return  dailyDiscount.add(defaultDiscount);
    }

    public static Money originalPrice(Map<Food, Integer> purchase) {
        List<Money> moneyList = purchase.entrySet()
                .stream()
                .map(food -> food.getKey().getMoney().multiply(food.getValue()))
                .toList();
        return Money.addAll(moneyList);
    }

    public static Map<Event, Money> benefitPriceByEachFood(Map<Food, Integer> purchase, Event event) {
        List<Money> moneyList = purchase.entrySet()
                .stream()
                .map(entry -> {
                    Food food = entry.getKey();
                    Integer amount = entry.getValue();
                    if (food.getFoodCategory().equals(event.getFoodCategory())) {
                        return event.getDiscount().multiply(amount);
                    }
                    return Money.zero;
                }).toList();
        Money totalPrice = Money.addAll(moneyList);
        return Map.of(event, totalPrice);
    }

    public static Money totalBenefitPrice(Map<Event, Money> eventPrices) {
        List<Money> moneyList = eventPrices.values()
                .stream()
                .toList();
        return Money.addAll(moneyList);
    }

    public static Money totalDiscountPrice(Map<Event, Money> eventPrices) {
        List<Money> moneyList = eventPrices.entrySet()
                .stream()
                .filter(entry -> !isPrizeType(entry.getKey().getType()))
                .map(Map.Entry::getValue)
                .toList();
        return Money.addAll(moneyList);
    }

    public static Money getFinalPrice(Money originalPrice, Map<Event, Money> eventPrices) {
        List<Money> moneyList = eventPrices.entrySet()
                .stream()
                .filter(entry -> !isPrizeType(entry.getKey().getType()))
                .map(Map.Entry::getValue)
                .toList();
        return originalPrice.minus(Money.addAll(moneyList));
    }
}