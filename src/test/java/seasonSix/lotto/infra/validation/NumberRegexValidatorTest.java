package seasonSix.lotto.infra.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seasonSix.lotto.infra.validator.NumberRegexValidator;
import seasonSix.lotto.infra.validator.exception.RegexException;

import static org.junit.jupiter.api.Assertions.*;
import static seasonSix.lotto.common.message.ErrorMessage.INVALID_NUMBER;


public class NumberRegexValidatorTest {
    @Test
    @DisplayName("문자열 입력시 RegexException 발생")
    void exceptionCase1() {
        String price = "test";
        Throwable exception = assertThrowsExactly(
                RegexException.class, () -> NumberRegexValidator.check(price),
                INVALID_NUMBER
        );
        assertEquals(INVALID_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("숫자를 입력시 정상 동작 ")
    void normalCase1() {
        String price = "8900";
        assertDoesNotThrow(() -> NumberRegexValidator.check(price));
    }
}
