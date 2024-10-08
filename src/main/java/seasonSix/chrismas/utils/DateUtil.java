package seasonSix.chrismas.utils;

import seasonSix.chrismas.common.MagicNums;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtil {

    public static boolean isWeekend(int date) {
        DayOfWeek dayOfWeek = calculateDayOfWeek(date);
        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY);
    }

    public static boolean isSpecialDay(int date) {
        if (MagicNums.isChristmas(date)) {
            return true;
        }
        DayOfWeek dayOfWeek = calculateDayOfWeek(date);
        return dayOfWeek.equals(DayOfWeek.SUNDAY);
    }

    public static boolean isOnChristmasSeason(int date) {
        return date <= MagicNums.CHRISTMAS.getVal();
    }

    private static DayOfWeek calculateDayOfWeek(int date) {
        int year = MagicNums.YEAR.getVal();
        int month = MagicNums.MONTH.getVal();
        LocalDate localDate = LocalDate.of(year, month, date);
        return localDate.getDayOfWeek();
    }

}
