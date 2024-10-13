package seasonSix.lotto.model.lotto;

import seasonSix.lotto.common.CommonConstant;
import seasonSix.lotto.common.utils.ConvertingUtil;
import seasonSix.lotto.model.validator.InputFacadeValidator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private Lotto(List<Integer> numbers) {
        InputFacadeValidator.checkWinningNumbers(numbers);
        this.numbers = numbers;
    }

    public int getMatchedCount(Lotto winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(int num) {
        int[] lottoNumbers = ConvertingUtil.integerListToIntArray(this.numbers);
        return Arrays.binarySearch(lottoNumbers, num) >= 0;
    }

    public String toString() {
        List<String> strNumbers = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .map(String::valueOf)
                .toList();
        return String.join(CommonConstant.COMMA.getSpliter() + " ", strNumbers);
    }
}
