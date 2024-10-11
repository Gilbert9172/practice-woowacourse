package seasonSix.lotto.model.lotto;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;
    private boolean isChecked;
    private Rank rank;


    public static Lotto newOne(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.rank = Rank.NONE;
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
