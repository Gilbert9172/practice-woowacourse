package seasonSix.lotto.common.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seasonSix.lotto.common.Money;

import static org.assertj.core.api.Assertions.assertThat;

public class MathUtilTest {

    @Test
    @DisplayName("수익률 - 200.0")
    void divideCase1() {
        //given
        Money earned = Money.of(9000);
        Money purchased = Money.of(3000);
        Money benefit = earned.minus(purchased);
        //when
        String actual = MathUtil.getBenefit(benefit.getVal(), purchased.getVal());
        //then
        assertThat(actual).isEqualTo("200.0");
    }

    @Test
    @DisplayName("수익률 - 25037462.5")
    void divideCase2() {
        //given
        Money earned = Money.of(2003005000);
        Money purchased = Money.of(8000);
        Money benefit = earned.minus(purchased);
        //when
        String actual = MathUtil.getBenefit(benefit.getVal(), purchased.getVal());
        //then
        assertThat(actual).isEqualTo("25037462.5");
    }
}
