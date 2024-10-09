package seasonSix.christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.Badge;

import static org.assertj.core.api.Assertions.*;

public class BadgeTest {

    @Test
    @DisplayName("NONE")
    void case1() {
        //given
        Money money = Money.newOne(1000L);
        //when
        Badge badge = Badge.assignBy(money);
        //then
        assertThat(badge.name()).isEqualTo("NONE");
    }

    @Test
    @DisplayName("STAR")
    void case2() {
        //given
        Money money = Money.newOne(9000L);
        //when
        Badge badge = Badge.assignBy(money);
        //then
        assertThat(badge.name()).isEqualTo("STAR");
    }

    @Test
    @DisplayName("TREE")
    void case3() {
        //given
        Money money = Money.newOne(12000L);
        //when
        Badge badge = Badge.assignBy(money);
        //then
        assertThat(badge.name()).isEqualTo("TREE");
    }

    @Test
    @DisplayName("SANTA")
    void case4() {
        //given
        Money money = Money.newOne(21000L);
        //when
        Badge badge = Badge.assignBy(money);
        //then
        assertThat(badge.name()).isEqualTo("SANTA");
    }
}
