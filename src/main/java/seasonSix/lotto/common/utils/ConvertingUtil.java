package seasonSix.lotto.common.utils;

import seasonSix.lotto.common.CommonConstant;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConvertingUtil {
    public static Set<String> stringToStringSet(String source) {
        String[] splitArray = source.split(CommonConstant.COMMA.getSpliter());
        return Arrays.stream(splitArray)
                .map(String::strip)
                .collect(Collectors.toSet());
    }

    public static List<String> stringToStringList(String source) {
        String[] splitArray = source.split(CommonConstant.COMMA.getSpliter());
        return Arrays.stream(splitArray)
                .map(String::strip)
                .toList();
    }

    public static List<Integer> stringToIntegerList(String source) {
        String[] splitArray = source.split(CommonConstant.COMMA.getSpliter());
        return Arrays.stream(splitArray)
                .map(String::strip)
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }

    public static int[] integerListToIntArray(List<Integer> source) {
        return source.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
