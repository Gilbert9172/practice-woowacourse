package seasonSix.lotto.common.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGenerateUtilTest {
    @Test
    @DisplayName("5개의 로또 생성 검증")
    void creatFiveLottos() {
        //given
        long purchaseCount = 5;

        //when
        List<Lotto> lottos = LottoGenerateUtil.generate(purchaseCount);

        //then
        assertThat(lottos.size()).isEqualTo(5);
    }
}
