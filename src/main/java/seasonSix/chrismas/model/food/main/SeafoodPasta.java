package seasonSix.chrismas.model.food.main;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.FoodCategory;

public class SeafoodPasta extends Food {
    public SeafoodPasta() {
        super("해산물파스타", Money.newOne(35000), FoodCategory.MAIN, false);
    }
}
