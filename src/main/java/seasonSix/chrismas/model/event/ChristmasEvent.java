package seasonSix.chrismas.model.event;

import seasonSix.chrismas.model.food.FoodCategory;

public class ChristmasEvent extends Event {

    public ChristmasEvent(int date) {
        super(
                "크리스마스 디데이 할인",
                EventType.CHRISTMAS,
                FoodCategory.ALL,
                new EventDate(25),
                ((long)(date - 1) * 100) + 1000);
    }
}
