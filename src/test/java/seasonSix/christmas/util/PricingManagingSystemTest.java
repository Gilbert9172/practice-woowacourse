package seasonSix.christmas.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.utils.PriceManagingUtil;

public class PricingManagingSystemTest {

    @Test
    @DisplayName("1일은 할인 금액 1000원")
    void christmasEventDiscountCase1() {
        //given
        int date = 1;

        //when
        Money money = PriceManagingUtil.christmasEventDiscount(date);

        //then
        Assertions.assertThat(money.equals(Money.newOne(1000))).isEqualTo(true);
    }

    @Test
    @DisplayName("25일은 할인 금액 3400원")
    void christmasEventDiscountCase2() {
        //given
        int date = 25;

        //when
        Money money = PriceManagingUtil.christmasEventDiscount(date);

        //then
        Assertions.assertThat(money.equals(Money.newOne(3400))).isEqualTo(true);
    }

    @Test
    @DisplayName("26일은 이벤트 기간이 아니기 때문에 할인 금액 0원")
    void christmasEventDiscountCase3() {
        //given
        int date = 26;

        //when
        Money money = PriceManagingUtil.christmasEventDiscount(date);

        //then
        Assertions.assertThat(money.equals(Money.zero)).isEqualTo(true);
    }
}
