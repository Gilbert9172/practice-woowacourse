package seasonSix.chrismas.model.food.appetizer;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.FoodCategory;

public class MushroomSoup extends Food {
    public MushroomSoup() {
        super("양송이수프", Money.newOne(6000), FoodCategory.APPETIZER, false);

    }
}
