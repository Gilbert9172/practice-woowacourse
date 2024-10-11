package seasonSix.lotto.infra.validator;

import seasonSix.lotto.infra.validator.exception.DuplicatedNumberException;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.Arrays;

import static seasonSix.lotto.common.message.ErrorMessage.DUPLICATED_NUMBERS;

public class DuplicatedNumberValidator  {
    public void check(String source, Lotto lotto) {
        int[] winningNumbers = lotto.getNumbers()
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        int bonusNumber = Integer.parseInt(source.strip());
        int result = Arrays.binarySearch(winningNumbers, bonusNumber);
        if (result > 0) {
            throw new DuplicatedNumberException(DUPLICATED_NUMBERS);
        }
    }
}
