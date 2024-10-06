package seasonSix.racingcar.model;

import seasonSix.racingcar.model.validator.NameLengthValidator;

import java.util.Arrays;
import java.util.List;

public class RacingCar {
    private String name;
    private String position;
    private int moveCount;

    public static RacingCar initiate(String name) {
        return new RacingCar(name);
    }

    private RacingCar(String name) {
        this.name = name;
        this.position = "";
        this.moveCount = 0;
    }

    public static List<RacingCar> generateRacingCars(String input) {
        List<String> names = Arrays.stream(input.strip().split(",")).map(String::strip).toList();
        for (String name : names) {
            NameLengthValidator.check(name);
        }
        return names.stream().map(RacingCar::initiate).toList();
    }

    public void moveForward(int movementCheckValue) {
        if (movementCheckValue >= 4) {
            position = position + "-";
            moveCount++;
        }
        if (movementCheckValue < 4) {
            position = position;
        }
    }

    public String printCurrentPosition() {
        return name + " : " + position;
    }

    public boolean finishRace(int phase) {
        return moveCount == phase;
    }

    public String getName() {
        return name;
    }
}
