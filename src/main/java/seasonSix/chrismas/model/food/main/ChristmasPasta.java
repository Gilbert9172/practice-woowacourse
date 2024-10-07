package seasonSix.chrismas.model.food.main;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.FoodCategory;

public class ChristmasPasta extends Food {
    public ChristmasPasta() {
        super("크리스마스파스타", Money.newOne(25000), FoodCategory.MAIN);
    }
}
