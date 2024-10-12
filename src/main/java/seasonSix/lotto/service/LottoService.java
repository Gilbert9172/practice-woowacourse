package seasonSix.lotto.service;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.common.utils.LottoGenerateUtil;
import seasonSix.lotto.model.LottoManager;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.List;

public class LottoService {

    public LottoManager createManager(List<Integer> numbers, Integer bonusNumber) {
        return LottoManager.of(numbers, bonusNumber);
    }

    public List<Lotto> generateLottos(Money purchasePrice) {
        long lottoCountBy = purchasePrice.getLottoCount();
        return LottoGenerateUtil.generate(lottoCountBy);
    }
}
