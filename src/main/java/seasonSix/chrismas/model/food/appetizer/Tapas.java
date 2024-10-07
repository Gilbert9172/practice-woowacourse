package seasonSix.chrismas.model.food.appetizer;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.FoodCategory;

public class Tapas extends Food {
    public Tapas() {
        super("타파스", Money.newOne(5500), FoodCategory.APPETIZER);
    }
}
