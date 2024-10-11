package seasonSix.lotto.infra;

import camp.nextstep.edu.missionutils.Console;
import seasonSix.lotto.common.message.InputMessage;
import seasonSix.lotto.infra.validator.InputFacadeValidator;

public class InputManager {
    public static long enterPurchasePrice() {
        System.out.println(InputMessage.ENTER_PURCHASE_AMOUNT);
        String input = Console.readLine();
        InputFacadeValidator.check(input);
        return Long.parseLong(input);
    }
}
