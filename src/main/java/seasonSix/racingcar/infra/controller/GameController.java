package seasonSix.racingcar.infra.controller;

import seasonSix.racingcar.model.RacingCar;
import seasonSix.racingcar.service.GameService;
import seasonSix.racingcar.utils.InputUtil;

import java.util.List;

public class GameController {
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void initiateGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCarsInput = InputUtil.enterString();
        System.out.println("시도할 회수는 몇회인가요?");
        int phase = InputUtil.enterInteger();
        List<RacingCar> racingCars = RacingCar.generateRacingCars(racingCarsInput);
        gameService.startGame(phase, racingCars);
    }
}
