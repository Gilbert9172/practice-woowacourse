package seasonSix.lotto.infra;

import camp.nextstep.edu.missionutils.Console;
import seasonSix.lotto.common.message.InputMessage;
import seasonSix.lotto.infra.validator.NumberRegexValidator;

public class InputManager {
    public static Long enterPurchasePrice() {
        System.out.println(InputMessage.ENTER_PURCHASE_AMOUNT);
        String input = Console.readLine();
        NumberRegexValidator.check(input);
        return Long.parseLong(input);
    }
}
