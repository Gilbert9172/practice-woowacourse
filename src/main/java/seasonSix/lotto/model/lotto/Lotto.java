package seasonSix.lotto.model.lotto;

import seasonSix.lotto.infra.validator.InputFacadeValidator;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;
    private boolean isChecked;
    private Rank rank;


    public static Lotto newOne(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private Lotto(List<Integer> numbers) {
        InputFacadeValidator.checkWinningNumbers(numbers);
        this.numbers = numbers;
        this.rank = Rank.NONE;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
