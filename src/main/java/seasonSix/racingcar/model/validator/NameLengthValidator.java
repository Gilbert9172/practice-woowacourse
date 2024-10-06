package seasonSix.racingcar.model.validator;

public class NameLengthValidator {
    public static void check(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
