package seasonSix.baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputUtil {
    public static int enterInteger() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
