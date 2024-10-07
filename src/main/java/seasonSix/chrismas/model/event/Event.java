package seasonSix.chrismas.model.event;

import seasonSix.chrismas.model.food.FoodCategory;

public class Event {
    private String title;
    private EventType type;
    private FoodCategory foodCategory;
    private EventDate eventDate;
    private long discountAmount;

    public Event(String title, EventType type, FoodCategory foodCategory, EventDate eventDate, long discountAmount) {
        this.title = title;
        this.type = type;
        this.foodCategory = foodCategory;
        this.eventDate = eventDate;
        this.discountAmount = discountAmount;
    }
}
