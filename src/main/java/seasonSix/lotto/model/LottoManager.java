package seasonSix.lotto.model;

import seasonSix.lotto.infra.validator.InputFacadeValidator;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.List;

public class LottoManager {
    private Lotto winningNumbers;
    private Integer bonusNumber;

    private LottoManager(List<Integer> numbers, Integer bonusNumber) {
        InputFacadeValidator.checkBonusNumber(bonusNumber, numbers);
        this.winningNumbers = Lotto.of(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static LottoManager of(List<Integer> numbers, Integer bonusNumber) {
        return new LottoManager(numbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
