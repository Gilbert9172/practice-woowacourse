package seasonSix.lotto;

import seasonSix.lotto.infra.controller.GameController;
import seasonSix.lotto.service.LottoService;
import seasonSix.lotto.service.UserService;

public class Application {
    public static void main(String[] args) {
        GameController gameController = setupController();
        gameController.startGame();
    }

    private static GameController setupController() {
        UserService userService = new UserService();
        LottoService lottoService = new LottoService();
        return new GameController(lottoService, userService);
    }
}
