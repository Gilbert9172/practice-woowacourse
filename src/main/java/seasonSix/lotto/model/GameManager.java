package seasonSix.lotto.model;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.common.utils.LottoGenerateUtil;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static seasonSix.lotto.common.message.ErrorMessage.SHOULD_NOT_BE_NULL;

public class GameManager {

    public static Money price = Money.newOne(1000L);
    private Lotto lotto;
    private Integer bonusNumber;

    private GameManager(Lotto lotto, Integer bonusNumber) {
        this.lotto = requireNonNull(lotto, SHOULD_NOT_BE_NULL);
        this.bonusNumber = requireNonNull(bonusNumber, SHOULD_NOT_BE_NULL);
    }

    public static GameManager newOne(Lotto lotto, Integer bonusNumber) {
        return new GameManager(lotto, bonusNumber);
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
