package seasonSix.chrismas.model.food;

import seasonSix.chrismas.common.Money;

public class Food {

    private String name;
    private Money money;

    private FoodCategory foodCategory;

    public Food() {}

    public Food(String name, Money money, FoodCategory foodCategory) {
        this.name = name;
        this.money = money;
        this.foodCategory = foodCategory;
    }

    public boolean isEqualTo(String name) {
        return this.name.equals(name);
    }
}
