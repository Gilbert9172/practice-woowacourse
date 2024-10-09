package seasonSix.chrismas.model.food;

import seasonSix.chrismas.common.Money;

public class Food {

    private String name;
    private Money money;

    private FoodCategory foodCategory;

    private boolean isPrize;

    public Food() {}

    public Food(String name, Money money, FoodCategory foodCategory, boolean isPrize) {
        this.name = name;
        this.money = money;
        this.foodCategory = foodCategory;
        this.isPrize = isPrize;
    }

    public boolean isEqualTo(String name) {
        return this.name.equals(name);
    }

    public Money getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public boolean isPrize() {
        return isPrize;
    }
}
