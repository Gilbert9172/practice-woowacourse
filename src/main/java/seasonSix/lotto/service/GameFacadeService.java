package seasonSix.lotto.service;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.model.LottoManager;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.List;

public class GameFacadeService {
    private final UserService userService;
    private final LottoService lottoService;

    public GameFacadeService(UserService userService, LottoService lottoService) {
        this.userService = userService;
        this.lottoService = lottoService;
    }

    public void startGame(List<Integer> winningNumbers, Integer bonusNumber, Money purchasePrice) {
        LottoManager lottoManager = lottoService.createManager(winningNumbers, bonusNumber);
        List<Lotto> lottos = lottoService.generateLottos(purchasePrice);
        userService.startGame(lottoManager, lottos, purchasePrice);
    }
}
