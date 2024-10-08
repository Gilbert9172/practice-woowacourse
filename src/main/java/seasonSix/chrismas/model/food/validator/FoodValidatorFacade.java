package seasonSix.chrismas.model.food.validator;

import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.utils.ConvertingUtils;

import java.util.List;

public class FoodValidatorFacade {
    public static void check(String source, List<Food> availableFoods) {
        List<String> convertedSource = ConvertingUtils.stringToList(source);

        RegexValidator regexValidator = new RegexValidator();
        DuplicatedOrderValidator duplicatedOrderValidator = new DuplicatedOrderValidator();
        OverOrderValidator overOrderValidator = new OverOrderValidator();
        AvailableValidator availableValidator = new AvailableValidator();

        regexValidator.doChain(duplicatedOrderValidator)
                .doChain(overOrderValidator)
                .doChain(availableValidator);

        regexValidator.check(convertedSource, availableFoods);
    }
}
