package seasonSix.lotto.service;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.common.utils.ConvertingUtil;
import seasonSix.lotto.common.utils.LottoGenerateUtil;
import seasonSix.lotto.model.LottoManager;
import seasonSix.lotto.model.lotto.Lotto;
import seasonSix.lotto.model.lotto.Rank;

import java.util.Arrays;
import java.util.List;

public class LottoService {

    public LottoManager createManager(List<Integer> numbers, Integer bonusNumber) {
        return LottoManager.of(numbers, bonusNumber);
    }

    public List<Lotto> generateLottos(Money purchasePrice) {
        long lottoCountBy = purchasePrice.getLottoCount();
        return LottoGenerateUtil.generate(lottoCountBy);
    }

    public Rank assignRank(LottoManager manager, Lotto userLotto) {
        Lotto winningLotto = manager.getWinningNumbers();
        int bonusNumber = manager.getBonusNumber();

        int matchedCount = userLotto.getMatchedCount(winningLotto);
        boolean bonusCondition = false;
        if (matchedCount == 5) {
            bonusCondition = userLotto.contains(bonusNumber);
        }

        return Rank.calculateRank(matchedCount, bonusCondition);
    }
}
