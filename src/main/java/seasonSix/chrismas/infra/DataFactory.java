package seasonSix.chrismas.infra;

import camp.nextstep.edu.missionutils.Console;
import seasonSix.chrismas.common.exception.InputException;
import seasonSix.chrismas.infra.view.message.InputMessage;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.validator.FoodValidatorFacade;
import seasonSix.chrismas.model.planner.validator.DateRegexValidator;
import seasonSix.chrismas.utils.ConvertingUtils;

import java.util.List;
import java.util.Map;

import static seasonSix.chrismas.infra.view.message.ErrorMessage.DATE_ERROR_MESSAGE;
import static seasonSix.chrismas.infra.view.message.ErrorMessage.FOOD_ERROR_MESSAGE;

public class DataFactory {

    public int generateDate() {
        while (true) {
            try {
                System.out.println(InputMessage.INPUT_DATE);
                String input = Console.readLine();
                DateRegexValidator.check(input);
                return Integer.parseInt(input);
            } catch (InputException e) {
                System.out.println(DATE_ERROR_MESSAGE);
            }
        }
    }

    public Map<Food, Integer> generateOderSheet(List<Food> availableFoods) {
        while (true) {
            try {
                System.out.println(InputMessage.INPUT_MENU);
                String menus = Console.readLine();
                FoodValidatorFacade.check(menus, availableFoods);
                return ConvertingUtils.mapToOrderSheet(menus, availableFoods);
            } catch (InputException e) {
                System.out.println(FOOD_ERROR_MESSAGE);
            }
        }
    }
}
