package seasonSix.chrismas.model.event;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.FoodCategory;

public class SpecialEvent extends Event{
    public SpecialEvent() {
        super(
                "특별할인",
                EventType.TOTAL,
                FoodCategory.ALL,
                new EventDate(31),
                DiscountTable.SPECIAL.getMoney()
        );
    }
}
