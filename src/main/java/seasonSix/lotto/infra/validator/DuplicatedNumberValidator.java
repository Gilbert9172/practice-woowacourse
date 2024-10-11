package seasonSix.lotto.infra.validator;

import seasonSix.lotto.common.utils.ConvertingUtil;
import seasonSix.lotto.infra.validator.exception.DuplicatedNumberException;

import java.util.List;
import java.util.Set;

import static seasonSix.lotto.common.message.ErrorMessage.DUPLICATED_NUMBERS;

public class DuplicatedNumberValidator extends InputValidator {

    @Override
    public <T> void check(T source) {
        String strSource = (String) source;
        Set<String> unique = ConvertingUtil.stringToStringSet(strSource);
        List<String> nonUnique = ConvertingUtil.stringToStringList(strSource);
        if (unique.size() != nonUnique.size()) {
            throw new DuplicatedNumberException(DUPLICATED_NUMBERS);
        }
        super.check(source);
    }
}
