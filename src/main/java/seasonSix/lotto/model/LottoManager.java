package seasonSix.lotto.model;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.common.utils.LottoGenerateUtil;
import seasonSix.lotto.infra.validator.InputFacadeValidator;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.List;

public class LottoManager {

    public static Money price = Money.newOne(1000L);
    private Lotto lotto;
    private Integer bonusNumber;

    private LottoManager(List<Integer> numbers, Integer bonusNumber) {
        InputFacadeValidator.checkBonusNumber(bonusNumber, numbers);
        this.lotto = Lotto.newOne(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static LottoManager newOne(List<Integer> numbers, Integer bonusNumber) {
        return new LottoManager(numbers, bonusNumber);
    }

    public List<Lotto> generateLottos(Long purchasePrice) {
        long lottoCountBy = getLottoCount(purchasePrice);
        return LottoGenerateUtil.generate(lottoCountBy);
    }

    private long getLottoCount(Long purchasePrice) {
        long lottoPrice = LottoManager.price.getVal();
        return purchasePrice / lottoPrice;
    }
}
