package seasonSix.lotto.model;

import seasonSix.lotto.model.lotto.Lotto;
import seasonSix.lotto.model.validator.InputFacadeValidator;

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

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
