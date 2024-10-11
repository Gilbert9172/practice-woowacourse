package seasonSix.lotto.model;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.common.utils.LottoGenerateUtil;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.List;

public class GameManager {

    public static Money price = Money.newOne(1000L);

    private Lotto lotto;

    public GameManager(Lotto lotto) {
        this.lotto = lotto;
    }

    public List<Lotto> generateLottos(Long purchasePrice) {
        long lottoCountBy = getLottoCount(purchasePrice);
        return LottoGenerateUtil.generate(lottoCountBy);
    }

    private long getLottoCount(Long purchasePrice) {
        long lottoPrice = GameManager.price.getVal();
        return purchasePrice / lottoPrice;
    }
}
