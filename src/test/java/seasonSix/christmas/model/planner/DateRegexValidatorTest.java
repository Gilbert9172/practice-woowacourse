package seasonSix.christmas.model.planner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seasonSix.chrismas.model.planner.exception.DateFormatException;
import seasonSix.chrismas.model.planner.validator.DateRegexValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DateRegexValidatorTest {
    @Test
    @DisplayName("1 ~ 31 숫자 입력")
    void case1() {
        //given
        String date = "31";
        //then
        DateRegexValidator.check(date);
    }

    @Test
    @DisplayName("31 보다 큰 숫자 입력")
    void case2() {
        //given
        String date = "32";
        //then
        assertThatThrownBy(() -> {
            DateRegexValidator.check(date);
        }).isInstanceOf(DateFormatException.class);
    }

    @Test
    @DisplayName("01 이런식으로 입력")
    void case3() {
        //given
        String date = "01";
        //then
        DateRegexValidator.check(date);
    }

    @Test
    @DisplayName("문자열 입력")
    void case4() {
        //given
        String date = "a";
        //then
        assertThatThrownBy(() -> {
            DateRegexValidator.check(date);
        }).isInstanceOf(DateFormatException.class);
    }
}
