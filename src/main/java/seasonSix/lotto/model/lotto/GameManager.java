package seasonSix.lotto.model.lotto;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.common.utils.LottoGenerateUtil;

import java.util.List;

public class GameManager {

    public static Money price = Money.newOne(1000L);

    public static GameManager newOne() {
        return new GameManager();
    }

    public GameManager() {
    }

    public List<Lotto> generateLottos(Long purchasePrice) {
        long lottoCountBy = getLottoCount(purchasePrice);
        return LottoGenerateUtil.generate(lottoCountBy);
    }

    private long getLottoCount(Long purchasePrice) {
        return purchasePrice / price.getVal();
    }
}
