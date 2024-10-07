package seasonSix.chrismas.model.food.beverage;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.FoodCategory;

public class ZeroCoke extends Food {
    public ZeroCoke() {
        super("제로콜라", Money.newOne(3000), FoodCategory.BEVERAGE);
    }
}
