package seasonSix.chrismas.utils;

import seasonSix.chrismas.common.MagicNums;
import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.event.PrizeEvent;
import seasonSix.chrismas.model.food.Food;

import java.util.List;
import java.util.Map;

import static seasonSix.chrismas.model.event.EventPriceTable.CHRISTMAS_DAILY;
import static seasonSix.chrismas.model.event.EventPriceTable.CHRISTMAS_DEFAULT;

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

    public static Money originalPrice(Map<Food, Integer> orderSheet) {
        List<Money> moneyList = orderSheet.entrySet()
                .stream()
                .map(food -> food.getKey().getMoney().multiply(food.getValue()))
                .toList();
        return Money.addAll(moneyList);
    }

    public static Money benefitPriceByEachFood(Map<Food, Integer> orderSheet, Event event) {
        List<Money> moneyList = orderSheet.entrySet()
                .stream()
                .map(entry -> {
                    Food food = entry.getKey();
                    Integer amount = entry.getValue();
                    if (food.getFoodCategory().equals(event.getFoodCategory())) {
                        Money originalPrice = food.getMoney().multiply(amount);
                        Money discount = event.getDiscount().multiply(amount);
                        return originalPrice.minus(discount);
                    }
                    return Money.zero;
                }).toList();
        return Money.addAll(moneyList);
    }

    public static Money benefitPriceForAllFood(List<Event> events) {
        Money benefitPrice = Money.zero;
        events.forEach(event -> benefitPrice.add(event.getDiscount()));
        return benefitPrice;
    }

    public static Money discountPrice(Money originalPrice, Money benefitPrice, Event event) {
        Money prizePrice = event.getDiscount();
        if (originalPrice.boeThan(PrizeEvent.minReceivablePrice)) {
            return benefitPrice.minus(prizePrice);
        }
        return benefitPrice;
    }
}
