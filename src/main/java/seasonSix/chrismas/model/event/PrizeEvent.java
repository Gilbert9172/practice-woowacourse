package seasonSix.chrismas.model.event;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.FoodCategory;

import static seasonSix.chrismas.model.event.EventPriceTable.minPrizeReceivablePrice;

public class PrizeEvent extends Event {

    public static final Money minReceivablePrice = minPrizeReceivablePrice();

    public PrizeEvent() {
        super(
                "증정이벤트",
                EventType.PRIZE,
                FoodCategory.ALL,
                new EventDate(31),
                EventPriceTable.PRIZE.getMoney()
        );
    }
}
