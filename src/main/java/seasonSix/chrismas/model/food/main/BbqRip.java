package seasonSix.chrismas.model.food.main;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.FoodCategory;

public class BbqRip extends Food {
    public BbqRip() {
        super("바비큐립", Money.newOne(54000), FoodCategory.MAIN, false);
    }
}
