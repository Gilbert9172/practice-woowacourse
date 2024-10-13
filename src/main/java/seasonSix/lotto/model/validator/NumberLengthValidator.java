package seasonSix.lotto.model.validator;

import seasonSix.lotto.model.validator.exception.OverLengthException;

import java.util.List;

import static seasonSix.lotto.common.message.ErrorMessage.OVER_LENGTH;

public class NumberLengthValidator extends InputValidator {

    @Override
    @SuppressWarnings("unchecked")
    public <T> void check(T source) {
        List<Integer> convertedSource = (List<Integer>) source;
        if (convertedSource.size() != 6) {
            throw new OverLengthException(OVER_LENGTH);
        }
        super.check(source);
    }
}
