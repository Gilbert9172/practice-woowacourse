package seasonSix.racingcar.model;

import seasonSix.racingcar.model.validator.NameLengthValidator;
import seasonSix.racingcar.model.validator.RangeValidator;
import seasonSix.racingcar.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private int phase;
    private int currentPhase;
    private List<RacingCar> racingCars = new ArrayList<>();

    public static GameManager initiate(int phase, List<RacingCar> racingCars) {
        // TODO : racingCars 예외 처리
        RangeValidator.check(phase);
        return new GameManager(phase, racingCars);
    }

    private GameManager(int phase, List<RacingCar> racingCars) {
        this.phase = phase;
        this.currentPhase = phase;
        this.racingCars = racingCars;
    }

    // TODO : magic number
    public boolean isOnGame() {
        return this.currentPhase != 0;
    }

    public void finishPhase() {
        currentPhase--;
    }

    public void printPhaseResult() {
        StringBuilder phase = new StringBuilder();
        for (RacingCar racingCar : racingCars) {
            phase.append(racingCar.printCurrentPosition()).append("\n");
        }
        System.out.println(phase.toString());
    }

    public void finishGame() {
        StringBuilder result = new StringBuilder();
        List<String> winners = racingCars.stream()
                .filter(racingCar -> racingCar.finishRace(phase))
                .map(RacingCar::getName)
                .toList();
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }

    public void runPhase() {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveForward(RandomUtil.generateRandomNum());
        }
    }
}
