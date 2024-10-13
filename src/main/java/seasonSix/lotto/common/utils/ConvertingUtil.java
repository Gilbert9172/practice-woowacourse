package seasonSix.lotto.common.utils;

import seasonSix.lotto.common.CommonConstant;
import seasonSix.lotto.common.Money;
import seasonSix.lotto.model.lotto.LottoResult;
import seasonSix.lotto.model.lotto.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ConvertingUtil {
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
