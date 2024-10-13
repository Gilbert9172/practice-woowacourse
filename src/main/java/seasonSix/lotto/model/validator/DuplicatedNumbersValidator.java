package seasonSix.lotto.model.validator;

import seasonSix.lotto.model.validator.exception.DuplicatedNumberException;

import java.util.List;

import static seasonSix.lotto.common.message.ErrorMessage.DUPLICATED_NUMBERS;

public class DuplicatedNumbersValidator extends InputValidator {

    @Override
    @SuppressWarnings("unchecked")
    public <T> void check(T source) {
        List<Integer> convertedSource = (List<Integer>) source;
        List<Integer> distincted = convertedSource.stream().distinct().toList();
        if (distincted.size() != convertedSource.size()) {
            throw new DuplicatedNumberException(DUPLICATED_NUMBERS);
        }
        super.check(source);
    }
}
