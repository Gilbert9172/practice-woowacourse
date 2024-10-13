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
        List<Integer> userLottoNumbers = userLotto.getNumbers();
        int[] winningNumbers = ConvertingUtil.integerListToIntArray(manager.getWinningNumbers());
        int bonusNumber = manager.getBonusNumber();

        int matchedCount = (int) userLottoNumbers.stream()
                .filter(num -> isMatched(winningNumbers, num))
                .count();

        int matchedBonusCount = 0;
        if (matchedCount == 5) {
            matchedBonusCount = bonusMatchedCount(userLottoNumbers, bonusNumber);
        }

        Rank rank = Rank.calculateRank(matchedCount, matchedBonusCount);
        userLotto.assignRank(rank);
        return rank;
    }

    private int bonusMatchedCount(List<Integer> numbers, int bonusNumber) {
        int[] userNumbersArray = ConvertingUtil.integerListToIntArray(numbers);
        if (isMatched(userNumbersArray, bonusNumber)) {
            return 1;
        }
        return 0;
    }

    private boolean isMatched(int[] winningNumbers, int num) {
        return Arrays.binarySearch(winningNumbers, num) >= 0;
    }
}
