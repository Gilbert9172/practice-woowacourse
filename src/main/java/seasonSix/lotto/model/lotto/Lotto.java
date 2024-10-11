package seasonSix.lotto.model.lotto;

import seasonSix.lotto.common.Money;

import java.util.List;

public class Lotto {
    public static Money price = Money.newOne(1000L);

    private final List<Integer> numbers;


    public static Lotto newOne(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
