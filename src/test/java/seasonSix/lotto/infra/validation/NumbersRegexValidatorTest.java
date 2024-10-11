package seasonSix.lotto.infra.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seasonSix.lotto.infra.validator.NumbersRegexValidator;
import seasonSix.lotto.infra.validator.exception.RegexException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static seasonSix.lotto.common.message.ErrorMessage.INVALID_NUMBER;

public class NumbersRegexValidatorTest {

    private final NumbersRegexValidator validator = new NumbersRegexValidator();

    @Test
    @DisplayName("중복된 숫자 입력시 DuplicatedNumberException 발생")
    void duplicatedCase1() {
        //given
        String nums = "1,2,3,4,a,5";
        //when
        Throwable exception = assertThrowsExactly(
                RegexException.class, () -> validator.check(nums),
                INVALID_NUMBER
        );
        //then
        assertEquals(INVALID_NUMBER, exception.getMessage());
    }
}
