package seasonSix.lotto.infra.controller;

import seasonSix.lotto.infra.InputManager;
import seasonSix.lotto.model.lotto.Lotto;
import seasonSix.lotto.service.LottoService;
import seasonSix.lotto.service.UserService;

import java.util.List;

public class GameController {

    private final LottoService lottoService;
    private final UserService userService;

    public GameController(LottoService lottoService, UserService userService) {
        this.lottoService = lottoService;
        this.userService = userService;
    }

    public void startGame() {
        long purchasePrice = InputManager.enterPurchasePrice();
        List<Lotto> lottos = lottoService.generateLottos(purchasePrice);
    }
}
