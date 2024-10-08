package seasonSix.chrismas.model.event;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.FoodCategory;

public class WeekendsEvent extends Event{
    public WeekendsEvent() {
        super(
                "주말할인",
                EventType.SINGLE,
                FoodCategory.MAIN,
                new EventDate(31),
                DiscountTable.WEEKEND.getMoney()
        );
    }
}
