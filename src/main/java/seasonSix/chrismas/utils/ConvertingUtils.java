package seasonSix.chrismas.utils;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.exception.NotAvailableFoodException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static Map<Event, Money> mapToMap(List<Event> events) {
        return events.stream()
                .collect(Collectors.toMap(
                        event -> event,
                        Event::getDiscount
                ));
    }

    public static Map<Event, Money> mergeMap(Map<Event, Money> left, Map<Event, Money> right) {
        return Stream.concat(
                left.entrySet().stream(),
                right.entrySet().stream()
        ).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
        ));
    }

    public static Map<String, String> mapToStringMap(Map<Event, Money> source) {
        return source.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getTitle(),
                        entry -> entry.getValue().toWon()
                ));
    }
}
