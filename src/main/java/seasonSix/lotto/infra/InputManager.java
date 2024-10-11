package seasonSix.lotto.infra;

import camp.nextstep.edu.missionutils.Console;
import seasonSix.lotto.common.utils.ConvertingUtil;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.List;

import static seasonSix.lotto.common.message.InputMessage.*;
import static seasonSix.lotto.infra.validator.InputFacadeValidator.*;

public class InputManager {
    public static long enterPurchasePrice() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        String input = Console.readLine();
        checkPurchaseAmount(input);
        return Long.parseLong(input);
    }

    public static Lotto enterWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS);
        String input = Console.readLine();
        checkWinningNumbers(input);
        List<Integer> converted = ConvertingUtil.stringToIntegerList(input);
        return Lotto.newOne(converted);
    }

    public static long enterBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
        String input = Console.readLine();
        // TODO : 예외처리
        return Long.parseLong(input);
    }
}
