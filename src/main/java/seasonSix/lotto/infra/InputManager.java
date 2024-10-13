package seasonSix.lotto.infra;

import camp.nextstep.edu.missionutils.Console;
import seasonSix.lotto.common.utils.ConvertingUtil;
import seasonSix.lotto.model.validator.InputFacadeValidator;

import java.util.List;

import static seasonSix.lotto.common.message.InputMessage.*;
import static seasonSix.lotto.model.validator.InputFacadeValidator.checkPurchaseAmount;
import static seasonSix.lotto.model.validator.InputFacadeValidator.checkWinningNumbers;

public class InputManager {
    public static long enterPurchasePrice() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        String input = Console.readLine();
        long converted = Long.parseLong(input);
        checkPurchaseAmount(converted);
        return converted;
    }

    public static List<Integer> enterWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS);
        String input = Console.readLine();
        List<Integer> converted = ConvertingUtil.stringToIntegerList(input);
        checkWinningNumbers(converted);
        System.out.println();
        return converted;
    }

    public static Integer enterBonusNumber(List<Integer> numbers) {
        System.out.println(ENTER_BONUS_NUMBER);
        String input = Console.readLine();
        int source = Integer.parseInt(input.strip());
        InputFacadeValidator.checkBonusNumber(source, numbers);
        System.out.println();
        return source;
    }
}
