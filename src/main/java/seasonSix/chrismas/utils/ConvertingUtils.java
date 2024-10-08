package seasonSix.chrismas.utils;

import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.NotAvailableFoodException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertingUtils {

    public static List<String> stringToList(String source) {
        return Arrays.stream(source.split(",")).toList();
    }

    public static List<String> mapToFoodNames(List<String> source) {
        return source.stream()
                .map(s -> s.split("-")[0])
                .toList();
    }

    public static Map<Food, Integer> mapToOrderSheet(String source, List<Food> availableFoods) {
        List<String> convertedSource = ConvertingUtils.stringToList(source);
        Map<Food, Integer> foodMap = new HashMap<>();
        mapToFoodNames(convertedSource).forEach(menu -> {
            String name = menu.split("-")[0];
            Integer amount = Integer.parseInt(menu.split("-")[1]);
            Food food = availableFoods.stream()
                .filter(target -> target.isEqualTo(name))
                .findFirst()
                .orElseThrow(NotAvailableFoodException::new);
            foodMap.put(food, amount);
        });
        return foodMap;
    }
}
