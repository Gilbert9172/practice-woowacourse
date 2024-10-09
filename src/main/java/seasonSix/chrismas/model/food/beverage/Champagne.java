package seasonSix.chrismas.model.food.beverage;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.FoodCategory;

public class Champagne extends Food {
    public Champagne() {
        super("샴페인", Money.newOne(25000), FoodCategory.BEVERAGE, true);
    }
}
