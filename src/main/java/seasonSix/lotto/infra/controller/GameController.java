package seasonSix.lotto.infra.controller;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.common.utils.OutputUtil;
import seasonSix.lotto.infra.InputManager;
import seasonSix.lotto.infra.view.MyResultView;
import seasonSix.lotto.model.LottoManager;
import seasonSix.lotto.model.lotto.Lotto;
import seasonSix.lotto.service.LottoService;
import seasonSix.lotto.service.UserService;

import java.util.List;

public class GameController {

    private final UserService userService;
    private final LottoService lottoService;

    public GameController(UserService userService, LottoService lottoService) {
        this.userService = userService;
        this.lottoService = lottoService;
    }

    public void startGame() {
        Money purchasePrice = Money.of(InputManager.enterPurchasePrice());
        List<Lotto> lottos = lottoService.generateLottos(purchasePrice);
        OutputUtil.printPurchase(lottos, purchasePrice);
        List<Integer> winningNumbers = InputManager.enterWinningNumbers();
        Integer bonusNumber = InputManager.enterBonusNumber(winningNumbers);

        LottoManager lottoManager = lottoService.createManager(winningNumbers, bonusNumber);
        MyResultView myResultView = userService.startGame(lottoManager, lottos, purchasePrice);
        OutputUtil.printResult(myResultView);
    }
}
