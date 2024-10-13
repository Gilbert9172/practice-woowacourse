package seasonSix.lotto.infra.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import seasonSix.lotto.model.validator.InputFacadeValidator;
import seasonSix.lotto.model.validator.exception.DuplicatedNumberException;
import seasonSix.lotto.model.validator.exception.MinPriceException;
import seasonSix.lotto.model.validator.exception.OverLengthException;
import seasonSix.lotto.model.validator.exception.OverRangeException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static seasonSix.lotto.common.message.ErrorMessage.*;


@Nested
public class InputFacadeValidatorTest {

    @Nested
    @DisplayName("구매 금액 입력 Test")
    class InputPurchaseTest {

        @Test
        @DisplayName("1000원 이상인 경우 정상 동작")
        void inputPurchaseAmountV1() {
            //given
            String input = "1000";
            //when
            assertDoesNotThrow(() -> InputFacadeValidator.checkPurchaseAmount(input));
        }

        @Test
        @DisplayName("1000원 미만인 경우 MinPriceException 발생")
        void inputPurchaseAmountV2() {
            //given
            String input = "900";
            //when
            Throwable exception = assertThrowsExactly(
                    MinPriceException.class, () -> InputFacadeValidator.checkPurchaseAmount(input),
                    PURCHASE_LIMIT_COUNT
            );
            //then
            assertEquals(PURCHASE_LIMIT_COUNT, exception.getMessage());
        }
    }

    @Nested
    @DisplayName("당첨 번호 입력 Test")
    class InputWinningNumbersTest {

        @Test
        @DisplayName("중복된 숫자 입력할 경우 DuplicatedNumberException")
        void checkWinningNumbersV1() {
            //given
            List<Integer> input = List.of(1, 2, 3, 4, 4, 5);
            //when
            Throwable exception = assertThrowsExactly(
                    DuplicatedNumberException.class, () -> InputFacadeValidator.checkWinningNumbers(input),
                    DUPLICATED_NUMBERS
            );
            //then
            assertEquals(DUPLICATED_NUMBERS, exception.getMessage());
        }

        @Test
        @DisplayName("7개 이상 입력한 경우 OverLengthException")
        void checkWinningNumbersV4() {
            //given
            List<Integer> input = List.of(1,2,3,4,5,6,7);
            //when
            Throwable exception = assertThrowsExactly(
                    OverLengthException.class, () -> InputFacadeValidator.checkWinningNumbers(input),
                    OVER_LENGTH
            );
            //then
            assertEquals(OVER_LENGTH, exception.getMessage());
        }

        @Test
        @DisplayName("5개 이상 입력한 경우 OverLengthException")
        void checkWinningNumbersV5() {
            //given
            List<Integer> input = List.of(1,2,3,4,5);
            //when
            Throwable exception = assertThrowsExactly(
                    OverLengthException.class, () -> InputFacadeValidator.checkWinningNumbers(input),
                    OVER_LENGTH
            );
            //then
            assertEquals(OVER_LENGTH, exception.getMessage());
        }
    }

    @Nested
    @DisplayName("보너스 번호 입력 Test")
    class InputBonusNumber {

        @Test
        @DisplayName("정상 동작")
        void checkBonusNumberV1() {
            //given
            Integer input = 7;
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            //when & then
            assertDoesNotThrow(() -> InputFacadeValidator.checkBonusNumber(input, winningNumbers));
        }

        @Test
        @DisplayName("당첨 번호와 중복되는 번호가 있을 경우 DuplicatedNumberException")
        void checkBonusNumberV2() {
            //given
            Integer input = 6;
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            //when
            Throwable exception = assertThrowsExactly(
                    DuplicatedNumberException.class, () -> InputFacadeValidator.checkBonusNumber(input, winningNumbers),
                    DUPLICATED_NUMBERS
            );
            //then
            assertEquals(DUPLICATED_NUMBERS, exception.getMessage());
        }

        @Test
        @DisplayName("1~45 이외의 숫자 입력시 RegexException")
        void checkBonusNumberV3() {
            //given
            Integer input = 47;
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            //when
            Throwable exception = assertThrowsExactly(
                    OverRangeException.class, () -> InputFacadeValidator.checkBonusNumber(input, winningNumbers),
                    INVALID_NUMBER
            );
            //then
            assertEquals(INVALID_NUMBER, exception.getMessage());
        }
    }
}
