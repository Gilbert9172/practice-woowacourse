package seasonSix.lotto.common.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoGenerateUtilTest {
    @Test
    @DisplayName("5개의 로또 생성 검증")
    void creatFiveLottos() {
        //given
        int purchaseCount = 5;

        //when
        List<Lotto> lottos = LottoGenerateUtil.generate(purchaseCount);

        //then
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 오름차순 검증")
    void lottoAscTest() {
        //given
        int purchaseCount = 5;

        //when
        List<Lotto> lottos = LottoGenerateUtil.generate(purchaseCount);

        //then
        lottos.forEach(lotto -> assertThat(lotto.getNumbers()).isSorted());
    }
}
