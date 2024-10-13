package seasonSix.lotto.model.validator;

import seasonSix.lotto.model.validator.exception.RegexException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seasonSix.lotto.common.message.ErrorMessage.INVALID_NUMBER;
import static seasonSix.lotto.common.message.ErrorMessage.INVALID_PRICE;

public class PriceRegexValidator extends InputValidator {

    @Override
    public <T> void check(T source) {
        String strSource = String.valueOf(source);
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(strSource);
        if (!matcher.matches()) {
            throw new RegexException(INVALID_PRICE);
        }
        super.check(source);
    }
}
