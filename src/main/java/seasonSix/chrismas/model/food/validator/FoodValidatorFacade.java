package seasonSix.chrismas.model.food.validator;

import seasonSix.chrismas.utils.ConvertingUtils;

import java.util.List;

public class FoodValidatorFacade {
    public static void check(String source) {
        List<String> convertedSource = ConvertingUtils.stringToList(source);
        RegexValidator regexValidator = new RegexValidator();
        DuplicatedOrderValidator duplicatedOrderValidator = new DuplicatedOrderValidator();
        OverOrderValidator overOrderValidator = new OverOrderValidator();
        regexValidator.doChain(duplicatedOrderValidator)
                .doChain(overOrderValidator);
        regexValidator.check(convertedSource);
    }
}
