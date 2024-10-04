package seasonSix.baseball.service.validator.input;

public class RestartFlagValidator {

    public static void validateInput(int flag) {
        if (flag > 3 || flag < 1) {
            throw new IllegalArgumentException("flag 값 다시 ㄱㄱ");
        }
    }
}
