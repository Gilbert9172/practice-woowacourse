package seasonSix.chrismas.utils;

import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.exception.NotAvailableFoodException;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertingUtils {

    public static List<String> stringToList(String source) {
        return Arrays.stream(source.split(",")).toList();
    }

    public static List<String> mapToFoodNames(List<String> source) {
        return source.stream()
                .map(s -> s.split("-")[0])
                .toList();
    }

    public static List<Integer> mapToFoodCounts(List<String> source) {
        return source.stream()
                .map(s -> mapToInteger(s.split("-")[1]))
                .toList();
    }

    public static Map<Food, Integer> mapToOrderSheet(String source, List<Food> availableFoods) {
        List<String> convertedSource = ConvertingUtils.stringToList(source);
        Map<Food, Integer> foodMap = new HashMap<>();
        convertedSource.forEach(menu -> {
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

    public static Integer mapToInteger(String source) {
        return Integer.parseInt(source);
    }

    public static Set<String> mapToUniqueFoodNames(List<String> source) {
        return source.stream()
                .map(s -> s.split("-")[0])
                .collect(Collectors.toSet());
    }
}
