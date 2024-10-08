package seasonSix.chrismas.utils;

import seasonSix.chrismas.common.MagicNums;
import seasonSix.chrismas.common.Money;

import static seasonSix.chrismas.model.event.DiscountTable.CHRISTMAS_DAILY;
import static seasonSix.chrismas.model.event.DiscountTable.CHRISTMAS_DEFAULT;

public class PriceManagingSystem {

    public static Money christmasEventDiscount(int date) {
        if (MagicNums.isAfterChristmas(date)) {
            return Money.zero;
        }
        Money dailyDiscount = CHRISTMAS_DAILY.getMoney()
                .multiply(date - 1);
        Money defaultDiscount = CHRISTMAS_DEFAULT.getMoney();
        return  dailyDiscount.add(dailyDiscount);
    }
}
