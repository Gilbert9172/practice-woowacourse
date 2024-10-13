package seasonSix.lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seasonSix.lotto.model.LottoManager;
import seasonSix.lotto.model.lotto.Lotto;
import seasonSix.lotto.model.lotto.Rank;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {

    private final LottoService sut = new LottoService();

    @Test
    @DisplayName("1등 - 6개 일치")
    void firstRank() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoManager lottoManager = LottoManager.of(winningNumbers, bonusNumber);
        Lotto userLotto = Lotto.of(userNumbers);
        //when
        Rank actual = sut.assignRank(lottoManager, userLotto);
        //then
        assertThat(actual.name()).isEqualTo(Rank.FIRST.name());
    }

    @Test
    @DisplayName("2등 - 5개 일치 (보너스 숫자 O)")
    void secondRank() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoManager lottoManager = LottoManager.of(winningNumbers, bonusNumber);
        Lotto userLotto = Lotto.of(userNumbers);
        //when
        Rank actual = sut.assignRank(lottoManager, userLotto);
        //then
        assertThat(actual.name()).isEqualTo(Rank.SECOND.name());
    }


    @Test
    @DisplayName("3등 - 5개 일치 (보너스 숫자 X)")
    void thirdRank() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 45);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoManager lottoManager = LottoManager.of(winningNumbers, bonusNumber);
        Lotto userLotto = Lotto.of(userNumbers);
        //when
        Rank actual = sut.assignRank(lottoManager, userLotto);
        //then
        assertThat(actual.name()).isEqualTo(Rank.THIRD.name());
    }

    @Test
    @DisplayName("4등 - 4개 일치")
    void fourthRank() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 44, 45);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoManager lottoManager = LottoManager.of(winningNumbers, bonusNumber);
        Lotto userLotto = Lotto.of(userNumbers);
        //when
        Rank actual = sut.assignRank(lottoManager, userLotto);
        //then
        assertThat(actual.name()).isEqualTo(Rank.FOURTH.name());
    }

    @Test
    @DisplayName("5등 - 3개 일치")
    void fifthRank() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 43, 44, 45);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoManager lottoManager = LottoManager.of(winningNumbers, bonusNumber);
        Lotto userLotto = Lotto.of(userNumbers);
        //when
        Rank actual = sut.assignRank(lottoManager, userLotto);
        //then
        assertThat(actual.name()).isEqualTo(Rank.FIFTH.name());
    }
}
