package seasonSix.lotto.infra.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seasonSix.lotto.infra.validator.DuplicatedNumberValidator;
import seasonSix.lotto.infra.validator.exception.DuplicatedNumberException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static seasonSix.lotto.common.message.ErrorMessage.DUPLICATED_NUMBERS;

public class DuplicatedNumberValidatorTest {

    private final DuplicatedNumberValidator validator = new DuplicatedNumberValidator();

    @Test
    @DisplayName("중복된 숫자 입력시 DuplicatedNumberException 발생")
    void duplicatedCase1() {
        //given
        String nums = "1,2,3,4,4,5";
        //when
        Throwable exception = assertThrowsExactly(
                DuplicatedNumberException.class, () -> validator.check(nums),
                DUPLICATED_NUMBERS
        );
        //then
        assertEquals(DUPLICATED_NUMBERS, exception.getMessage());
    }
}
