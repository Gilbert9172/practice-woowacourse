package seasonSix.chrismas.model.food.beverage;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.FoodCategory;

public class RedWine extends Food {
    public RedWine() {
        super("레드와인", Money.newOne(60000), FoodCategory.BEVERAGE, false);
    }
}
