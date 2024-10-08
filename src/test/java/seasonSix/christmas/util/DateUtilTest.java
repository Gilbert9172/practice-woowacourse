package seasonSix.christmas.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seasonSix.chrismas.utils.DateUtil;

public class DateUtilTest {

    @Test
    @DisplayName("2023년 12월 5일은 공휴일이 아니다.")
    void checkIsNotWeekend() {
        //given
        int date = 5;
        //when
        boolean isWeekend = DateUtil.isWeekend(date);
        //then
        Assertions.assertThat(isWeekend).isEqualTo(false);
    }
    
    @Test
    @DisplayName("2023년 12월 1일은 공휴일이다.")
    void checkIsWeekend() {
        //given
        int date = 1;
        //when
        boolean isWeekend = DateUtil.isWeekend(date);
        //then
        Assertions.assertThat(isWeekend).isEqualTo(true);
    }

    @Test
    @DisplayName("2023년 12월 3일은 별표시가 있는 날이다.")
    void checkIsSpecialDay() {
        //given
        int date = 3;
        //when
        boolean isSpecialDay = DateUtil.isSpecialDay(date);
        //then
        Assertions.assertThat(isSpecialDay).isEqualTo(true);
    }

    @Test
    @DisplayName("2023년 12월 1일은 별표시가 없는 날이다.")
    void checkIsNotSpecialDay() {
        //given
        int date = 1;
        //when
        boolean isSpecialDay = DateUtil.isSpecialDay(date);
        //then
        Assertions.assertThat(isSpecialDay).isEqualTo(false);
    }
}
