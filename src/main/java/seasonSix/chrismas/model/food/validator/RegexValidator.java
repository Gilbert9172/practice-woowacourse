package seasonSix.chrismas.model.food.validator;

import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.exception.NotAvailableFormatException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator extends FoodValidator {
    @Override
    public void check(List<String> source, List<Food> availableFoods) {
        String regex = "[가-힣]+-([1-9]|1[0-9]|20)";
        Pattern pattern = Pattern.compile(regex);
        source.stream()
                .filter(data -> !isAvailable(pattern, data))
                .findFirst()
                .ifPresent(data -> {
                    throw new NotAvailableFormatException();
                });
        super.check(source, availableFoods);
    }

    private boolean isAvailable(Pattern pattern, String source) {
        Matcher matcher = pattern.matcher(source);
        return matcher.matches();
    }
}
