package seasonSix.racingcar.service;

import seasonSix.racingcar.model.GameManager;
import seasonSix.racingcar.model.RacingCar;

import java.util.List;

public class GameService {
    public GameService() {}

    public void startGame(int phase, List<RacingCar> racingCars) {
        GameManager manager = GameManager.initiate(phase, racingCars);
        while (manager.isOnGame()) {
            manager.runPhase();
            manager.printPhaseResult();
            manager.finishPhase();
        }
        manager.finishGame();
    }
}
