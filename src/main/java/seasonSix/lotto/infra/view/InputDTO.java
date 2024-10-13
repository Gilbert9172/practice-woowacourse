package seasonSix.lotto.infra.view;

import seasonSix.lotto.common.Money;

import java.util.List;

public class InputDTO {
    private Money purchasePrice;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    private InputDTO(Money purchasePrice, List<Integer> winningNumbers, Integer bonusNumber) {
        this.purchasePrice = purchasePrice;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static InputDTO of(Money purchasePrice, List<Integer> winningNumbers, Integer bonusNumber) {
        return new InputDTO(purchasePrice, winningNumbers, bonusNumber);
    }

    public Money getPurchasePrice() {
        return purchasePrice;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
