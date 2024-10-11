package seasonSix.lotto.infra.validator;

import seasonSix.lotto.infra.validator.exception.OverRangeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seasonSix.lotto.common.message.ErrorMessage.INVALID_NUMBER;

public class NumberRangeValidator extends InputValidator {
    @Override
    public <T> void check(T source) {
        String strSource = String.valueOf(source);
        String regex = "^([1-9]|[1-3][0-9]|4[0-5])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(strSource);
        if (!matcher.matches()) {
            throw new OverRangeException(INVALID_NUMBER);
        }
        super.check(source);
    }
}
