package seasonSix.lotto;

import seasonSix.lotto.infra.controller.GameController;
import seasonSix.lotto.service.GameFacadeService;
import seasonSix.lotto.service.LottoService;
import seasonSix.lotto.service.UserService;

public class Application {
    public static void main(String[] args) {
        GameController gameController = setupController();
        gameController.startGame();
    }

    private static GameController setupController() {
        LottoService lottoService = new LottoService();
        UserService userService = new UserService(lottoService);
        GameFacadeService gameFacadeService = new GameFacadeService(userService, lottoService);
        return new GameController(gameFacadeService);
    }
}
