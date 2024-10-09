package seasonSix.chrismas.model.food.appetizer;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.FoodCategory;

public class CaesarSalad extends Food {

    public CaesarSalad() {
        super("시저샐러드", Money.newOne(8000), FoodCategory.APPETIZER, false);
    }
}
