package seasonSix.chrismas.model.event;

import seasonSix.chrismas.model.food.FoodCategory;

public class PrizeEvent extends Event {
    public PrizeEvent() {
        super(
                "증정이벤트",
                EventType.PRIZE,
                FoodCategory.ALL,
                new EventDate(31),
                DiscountTable.PRIZE.getMoney()
        );
    }
}
