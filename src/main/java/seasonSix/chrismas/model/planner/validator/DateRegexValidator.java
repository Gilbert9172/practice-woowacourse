package seasonSix.chrismas.model.planner.validator;

import seasonSix.chrismas.model.planner.exception.DateFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateRegexValidator extends NumberFormatException {
    // 숫자만 1 ~ 31
    public static void check(String source) {
        String regex = "(0?[1-9]|[12][0-9]|3[01])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        if (!matcher.matches()) {
            throw new DateFormatException();
        }
    }
}
