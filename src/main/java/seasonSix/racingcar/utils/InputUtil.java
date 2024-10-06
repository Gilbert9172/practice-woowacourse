package seasonSix.racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
    private static String enterInput() {
        return Console.readLine();
    }

    public static String enterString() {
        return enterInput();
    }
    public static int enterInteger() {
        return Integer.parseInt(enterInput());
    }
}