package seasonSix.chrismas.model.food.validator;

import seasonSix.chrismas.model.food.Food;

import java.util.List;

public class FoodValidator {
    private FoodValidator next = null;

    public FoodValidator doChain(FoodValidator validator) {
        this.next = validator;
        return validator;
    }

    public void check(List<String> source, List<Food> availableFoods) {
        if (next != null) {
            next.check(source, availableFoods);
        }
    }
}
