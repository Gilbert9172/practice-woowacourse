package seasonSix.chrismas.model.food.validator;

import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.exception.NotAvailableOrderException;
import seasonSix.chrismas.utils.ConvertingUtils;

import java.util.List;

public class OverOrderValidator extends FoodValidator{

    @Override
    public void check(List<String> source, List<Food> availableFoods) {
        List<Integer> foodNames = ConvertingUtils.mapToFoodCounts(source);
        int totalCount = foodNames.stream().mapToInt(Integer::intValue).sum();
        if (totalCount > 20) {
            throw new NotAvailableOrderException();
        }
        super.check(source, availableFoods);
    }
}
