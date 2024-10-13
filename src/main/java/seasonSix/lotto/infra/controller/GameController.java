package seasonSix.lotto.infra.controller;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.infra.InputManager;
import seasonSix.lotto.infra.view.InputDTO;
import seasonSix.lotto.service.GameFacadeService;

import java.util.List;

public class GameController {

    private final GameFacadeService gameFacadeService;

    public GameController(GameFacadeService gameFacadeService) {
        this.gameFacadeService = gameFacadeService;
    }

    public void startGame() {
        InputDTO inputs = enterInputs();
        List<Integer> winningNumbers = inputs.getWinningNumbers();
        Integer bonusNumber = inputs.getBonusNumber();
        Money purchasePrice = inputs.getPurchasePrice();
        gameFacadeService.startGame(winningNumbers, bonusNumber, purchasePrice);
    }

    private InputDTO enterInputs() {
        Money purchasePrice = Money.of(InputManager.enterPurchasePrice());
        // TODO : 구매 내역 출력
        List<Integer> winningNumbers = InputManager.enterWinningNumbers();
        Integer bonusNumber = InputManager.enterBonusNumber(winningNumbers);
        return InputDTO.of(purchasePrice, winningNumbers, bonusNumber);
    }
}
