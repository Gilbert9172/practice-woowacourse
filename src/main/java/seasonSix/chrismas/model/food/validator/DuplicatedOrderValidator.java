package seasonSix.chrismas.model.food.validator;

import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.exception.DuplicatedFoodException;
import seasonSix.chrismas.utils.ConvertingUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicatedOrderValidator extends FoodValidator {

    @Override
    public void check(List<String> source, List<Food> availableFoods) {
        List<String> foodNames = ConvertingUtils.mapToFoodNames(source);
        foodNames.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(food -> food.getValue() > 1)
            .findFirst()
            .ifPresent(food -> {
                throw new DuplicatedFoodException();
            });
        super.check(source, availableFoods);
    }
}
