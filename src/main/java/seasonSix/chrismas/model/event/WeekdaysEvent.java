package seasonSix.chrismas.model.event;

import seasonSix.chrismas.model.food.FoodCategory;

public class WeekdaysEvent extends Event {
    public WeekdaysEvent() {
        super(
                "평일할인",
                EventType.SINGLE,
                FoodCategory.DESSERT,
                new EventDate(31),
                2023
        );
    }
}
