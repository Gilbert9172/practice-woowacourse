package seasonSix.chrismas.model.food.validator;

import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.exception.NotAvailableFoodException;
import seasonSix.chrismas.utils.ConvertingUtils;

import java.util.List;

public class AvailableValidator extends FoodValidator {
    @Override
    public void check(List<String> source, List<Food> availableFoods) {
        List<String> menus = ConvertingUtils.mapToFoodNames(source);
        List<String> availableFoodNames = availableFoods.stream()
                .map(Food::getName)
                .toList();
        menus.forEach(menu -> {
            availableFoods.stream()
                    .filter(target -> !availableFoodNames.contains(menu))
                    .findFirst()
                    .ifPresent(food -> {
                        throw new NotAvailableFoodException();
                    });
        });
    }
}
