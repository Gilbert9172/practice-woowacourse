package seasonSix.baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class ConvertUtil {
    public static List<Integer> intToList(int num) {
        List<Integer> convertedResult = new ArrayList<>();
        String intToString = String.valueOf(num);
        for (char digit : intToString.toCharArray()) {
            convertedResult.add(Character.getNumericValue(digit));
        }
        return convertedResult;
    }
}
