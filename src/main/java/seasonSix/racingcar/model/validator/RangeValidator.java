package seasonSix.racingcar.model.validator;

public class RangeValidator {
    public static void check(int input) {
        if (input < 0 || input > 10) {
            throw new IllegalArgumentException();
        }
    }
}
