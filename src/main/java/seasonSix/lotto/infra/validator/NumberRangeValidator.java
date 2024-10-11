package seasonSix.lotto.infra.validator;

import seasonSix.lotto.common.utils.ConvertingUtil;
import seasonSix.lotto.infra.validator.exception.OverRangeException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seasonSix.lotto.common.message.ErrorMessage.INVALID_NUMBER;

public class NumberRangeValidator extends InputValidator {
    @Override
    public <T> void check(T source) {
        String strSource = (String) source;
        List<String> uniqueNumbers = ConvertingUtil.stringToStringList(strSource);
        String regex = "^([1-9]|[1-3][0-9]|4[0-5])$";
        Pattern pattern = Pattern.compile(regex);
        uniqueNumbers.stream().filter(num -> {
                    Matcher matcher = pattern.matcher(num);
                    return !matcher.matches();
                })
                .findFirst()
                .ifPresent(num -> {
                    throw new OverRangeException(INVALID_NUMBER);
                });
        super.check(source);
    }
}
