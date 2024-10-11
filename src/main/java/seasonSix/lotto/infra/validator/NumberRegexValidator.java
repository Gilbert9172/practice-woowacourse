package seasonSix.lotto.infra.validator;

import seasonSix.lotto.infra.validator.exception.RegexException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seasonSix.lotto.common.message.ErrorMessage.INVALID_NUMBER;

public class NumberRegexValidator {
    public static void check(String source) {
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        if (!matcher.matches()) {
            throw new RegexException(INVALID_NUMBER);
        }
    }
}
