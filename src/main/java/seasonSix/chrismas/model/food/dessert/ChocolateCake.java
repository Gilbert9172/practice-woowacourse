package seasonSix.chrismas.model.food.dessert;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.FoodCategory;

public class ChocolateCake extends Food {
    public ChocolateCake() {
        super("초코케이스", Money.newOne(15000), FoodCategory.DESSERT);
    }
}
