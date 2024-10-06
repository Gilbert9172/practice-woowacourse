package seasonSix.racingcar;

import seasonSix.racingcar.infra.controller.GameController;
import seasonSix.racingcar.service.GameService;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        GameController gameController = new GameController(gameService);
        gameController.initiateGame();
    }
}
