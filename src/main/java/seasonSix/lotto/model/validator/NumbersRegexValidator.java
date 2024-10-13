package seasonSix.lotto.model.validator;

import seasonSix.lotto.model.validator.exception.RegexException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seasonSix.lotto.common.message.ErrorMessage.INVALID_NUMBER;

public class NumbersRegexValidator extends InputValidator{

    @Override
    @SuppressWarnings("unchecked")
    public <T> void check(T source) {
        List<Integer> convertedSource = (List<Integer>) source;
        List<String> uniqueNumbers = convertedSource.stream()
                .map(String::valueOf)
                .toList();
        String regex = "^([1-9]|[1-3][0-9]|4[0-5])$";
        Pattern pattern = Pattern.compile(regex);
        uniqueNumbers.stream().filter(num -> {
            Matcher matcher = pattern.matcher(num);
            return !matcher.matches();
        }).findFirst()
                .ifPresent(num -> {
                    throw new RegexException(INVALID_NUMBER);
                });
        super.check(source);
    }
}
