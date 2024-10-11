package seasonSix.lotto.infra.validator;

import seasonSix.lotto.common.utils.ConvertingUtil;
import seasonSix.lotto.infra.validator.exception.OverLengthException;

import java.util.List;

import static seasonSix.lotto.common.message.ErrorMessage.OVER_LENGTH;

public class NumberLengthValidator extends InputValidator {
    @Override
    public <T> void check(T source) {
        String strSource = (String) source;
        List<String> uniqueNumbers = ConvertingUtil.stringToStringList(strSource);
        if (uniqueNumbers.size() != 6) {
            throw new OverLengthException(OVER_LENGTH);
        }
        super.check(source);
    }
}
