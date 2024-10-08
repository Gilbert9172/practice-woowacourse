package seasonSix.chrismas.model.food.validator;

import seasonSix.chrismas.model.food.Food;

import java.util.List;

public class FoodValidator {
    private FoodValidator validator = null;

    public FoodValidator doChain(FoodValidator validator) {
        this.validator = validator;
        return this;
    }

    public void check(List<String> source) {

    }
}
