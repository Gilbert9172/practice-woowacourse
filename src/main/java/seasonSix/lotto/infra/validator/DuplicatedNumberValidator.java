package seasonSix.lotto.infra.validator;

import seasonSix.lotto.infra.validator.exception.DuplicatedNumberException;

import java.util.Arrays;
import java.util.List;

import static seasonSix.lotto.common.message.ErrorMessage.DUPLICATED_NUMBERS;

public class DuplicatedNumberValidator  {
    public void check(Integer source, List<Integer> numbers) {
        int[] winningNumbers = numbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        int result = Arrays.binarySearch(winningNumbers, source);
        if (result > 0) {
            throw new DuplicatedNumberException(DUPLICATED_NUMBERS);
        }
    }
}
