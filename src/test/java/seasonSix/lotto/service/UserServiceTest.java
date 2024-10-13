package seasonSix.lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import seasonSix.lotto.common.Money;
import seasonSix.lotto.model.LottoManager;
import seasonSix.lotto.model.User;
import seasonSix.lotto.model.lotto.Lotto;
import seasonSix.lotto.model.lotto.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static seasonSix.lotto.model.lotto.Rank.*;

@Nested
public class UserServiceTest {
    private final LottoService lottoService = new LottoService();
    private final UserService sut = new UserService(lottoService);

    @Nested
    class RankTableTest {

        @Test
        @DisplayName("Rank Table")
        void case1() {
            //given
            List<Lotto> lottos = List.of(
                    Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                    Lotto.of(List.of(1, 2, 3, 4, 5, 25)),
                    Lotto.of(List.of(1, 2, 3, 4, 5, 44)),
                    Lotto.of(List.of(1, 2, 3, 4, 41, 42)),
                    Lotto.of(List.of(1, 2, 3, 4, 42, 45)),
                    Lotto.of(List.of(1, 2, 3, 32, 38, 45)),
                    Lotto.of(List.of(1, 3, 11, 14, 22, 45)),
                    Lotto.of(List.of(7, 11, 30, 40, 42, 43))
            );
            Money purchasePrice = Money.of(8000);
            User user = User.of(lottos, purchasePrice);

            List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 25;
            LottoManager lottoManager = LottoManager.of(winningLotto, bonusNumber);
            //when
            sut.matchingNumbers(lottoManager, user);
            //then
            Map<Rank, Integer> rankTable = user.getRankTable();
            assertThat(rankTable.get(FIRST)).isEqualTo(1);
            assertThat(rankTable.get(SECOND)).isEqualTo(1);
            assertThat(rankTable.get(THIRD)).isEqualTo(1);
            assertThat(rankTable.get(FOURTH)).isEqualTo(2);
            assertThat(rankTable.get(FIFTH)).isEqualTo(1);
            assertThat(rankTable.get(NONE)).isEqualTo(2);

        }
    }

    @Nested
    class CalculateBenefitTest {

        @Test
        @DisplayName("")
        void case1() {
            //given
            Map<Rank, Integer> rankTable = new HashMap<>();
            rankTable.put(FIRST, 0);
            rankTable.put(SECOND, 0);
            rankTable.put(THIRD, 0);
            rankTable.put(FOURTH, 0);
            rankTable.put(FIFTH, 2);
            rankTable.put(NONE, 4);

            List<Lotto> lottos = List.of(
                    Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                    Lotto.of(List.of(1, 2, 3, 4, 5, 25)),
                    Lotto.of(List.of(1, 2, 3, 4, 5, 44)),
                    Lotto.of(List.of(1, 2, 3, 4, 41, 42)),
                    Lotto.of(List.of(1, 2, 3, 4, 42, 45)),
                    Lotto.of(List.of(1, 2, 3, 32, 38, 45)),
                    Lotto.of(List.of(1, 3, 11, 14, 22, 45)),
                    Lotto.of(List.of(7, 11, 30, 40, 42, 43))
            );
            Money purchasePrice = Money.of(8000);
            User user = User.of(lottos, purchasePrice);
            user.finishMatchingNumbers(rankTable);
            //when
            sut.calculateAdjustment(user);
            //then
            assertThat(user.getBenefit()).isEqualTo("25.0");
        }
    }

}
