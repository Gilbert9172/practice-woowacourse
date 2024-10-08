package seasonSix.chrismas.model.food.validator;

import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.FoodCategory;
import seasonSix.chrismas.model.food.exception.OnlyBeverageException;
import seasonSix.chrismas.utils.ConvertingUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static seasonSix.chrismas.model.food.FoodCategory.BEVERAGE;

public class OnlyBeverageValidator extends FoodValidator{
    @Override
    public void check(List<String> source, List<Food> availableFoods) {
        Set<String> uniqueFoodNames = ConvertingUtils.mapToUniqueFoodNames(source);
        Set<FoodCategory> uniqueFoodCategory = availableFoods.stream()
            .filter(food -> uniqueFoodNames.contains(food.getName()))
            .map(Food::getFoodCategory)
            .collect(Collectors.toSet());
        if (uniqueFoodCategory.size() == 1 && uniqueFoodCategory.contains(BEVERAGE)) {
            throw new OnlyBeverageException();
        }
        super.check(source, availableFoods);
    }
}
