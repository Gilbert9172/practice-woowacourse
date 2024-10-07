package seasonSix.chrismas.model.food.dessert;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.FoodCategory;

public class IceCream extends Food {
    public IceCream() {
        super("아이스크림", Money.newOne(5000), FoodCategory.DESSERT);
    }
}
