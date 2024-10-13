package seasonSix.lotto.model.lotto;

import seasonSix.lotto.model.validator.InputFacadeValidator;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;
    private Rank rank;


    public static Lotto of(List<Integer> numbers) {
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

    public void assignRank(Rank rank) {
        this.rank = rank;
    }
}
