package seasonSix.chrismas.model.event;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.FoodCategory;

public class Event {
    private String title;
    private EventType type;
    private FoodCategory foodCategory;
    private EventDate eventDate;
    private Money discount;

    public Event(String title, EventType type, FoodCategory foodCategory, EventDate eventDate, Money discount) {
        this.title = title;
        this.type = type;
        this.foodCategory = foodCategory;
        this.eventDate = eventDate;
        this.discount = discount;
    }

    public Money getDiscount() {
        return discount;
    }

    public EventType getType() {
        return type;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }
}
