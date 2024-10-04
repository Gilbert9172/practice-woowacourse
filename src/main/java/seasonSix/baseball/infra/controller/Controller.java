package seasonSix.baseball.infra.controller;

import seasonSix.baseball.service.GameService;
import seasonSix.baseball.service.message.ServiceMessage;

public class Controller {

    private GameService gameService;

    public Controller(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        ServiceMessage.gameStart();
        gameService.playBall();
    }
}
