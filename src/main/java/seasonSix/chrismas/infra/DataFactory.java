package seasonSix.chrismas.infra;

import camp.nextstep.edu.missionutils.Console;
import seasonSix.chrismas.infra.view.message.InputMessage;
import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.validator.FoodValidatorFacade;
import seasonSix.chrismas.model.planner.validator.DateRegexValidator;
import seasonSix.chrismas.repository.EventRepository;
import seasonSix.chrismas.repository.FoodRepository;
import seasonSix.chrismas.service.dto.DateInfoDTO;
import seasonSix.chrismas.utils.ConvertingUtils;
import seasonSix.chrismas.utils.DateUtil;

import java.util.List;
import java.util.Map;

public class DataFactory {

    private final FoodRepository foodRepository;
    private final EventRepository eventRepository;

    public DataFactory(FoodRepository foodRepository, EventRepository eventRepository) {
        this.foodRepository = foodRepository;
        this.eventRepository = eventRepository;
    }

    public int generateDate() {
        while (true) {
            try {
                System.out.println(InputMessage.INPUT_DATE);
                String input = Console.readLine();
                DateRegexValidator.check(input);
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("[ERROR]");
            }
        }
    }

    public Map<Food, Integer> generateOderSheet() {
        List<Food> availableFoods = this.generateFoods();
        while (true) {
            try {
                System.out.println(InputMessage.INPUT_MENU);
                String menus = Console.readLine();
                FoodValidatorFacade.check(menus, availableFoods);
                return ConvertingUtils.mapToOrderSheet(menus, availableFoods);
            } catch (Exception e) {
                System.out.println("[ERROR]");
            }
        }
    }

    public List<Food> generateFoods() {
        return foodRepository.initializeFoods();
    }

    public List<Event> generateEvents(int date) {
        boolean isWeekend = DateUtil.isWeekend(date);
        boolean isSpecialDay = DateUtil.isSpecialDay(date);
        boolean isOnChristmasSeason = DateUtil.isOnChristmasSeason(date);
        DateInfoDTO dateInfo = DateInfoDTO.newOne(date, isWeekend, isSpecialDay, isOnChristmasSeason);
        return eventRepository.findTodayEvents(dateInfo);
    }
}
