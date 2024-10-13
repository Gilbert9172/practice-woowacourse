package seasonSix.lotto.infra.controller;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.infra.InputManager;
import seasonSix.lotto.model.LottoManager;
import seasonSix.lotto.model.User;
import seasonSix.lotto.model.lotto.Lotto;
import seasonSix.lotto.model.lotto.Rank;
import seasonSix.lotto.service.LottoService;
import seasonSix.lotto.service.UserService;

import java.util.List;
import java.util.Map;

public class GameController {

    private final UserService userService;
    private final LottoService lottoService;

    public GameController(UserService userService, LottoService lottoService) {
        this.userService = userService;
        this.lottoService = lottoService;
    }

    public void startGame() {
        Money purchasePrice = Money.of(InputManager.enterPurchasePrice());
        // TODO : 구매 내역 출력
        List<Integer> winningNumbers = InputManager.enterWinningNumbers();
        Integer bonusNumber = InputManager.enterBonusNumber(winningNumbers);

        LottoManager lottoManager = lottoService.createManager(winningNumbers, bonusNumber);
        List<Lotto> lottos = lottoService.generateLottos(purchasePrice);
        userService.startGame(lottoManager, lottos, purchasePrice);
    }
}
