package seasonSix.lotto.model.lotto;

import seasonSix.lotto.common.Money;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankTable;

    private LottoResult() {
        Map<Rank, Integer> rankTable = new EnumMap<>(Rank.class);
        Rank.sortedValuesExceptNone()
                .forEach(rank -> rankTable.put(rank, 0));
        this.rankTable = rankTable;
    }

    public static LottoResult of() {
        return new LottoResult();
    }

    public void updateIfNecessary(Rank rank) {
        if (Rank.isNotNone(rank)) {
            rankTable.put(rank, rankTable.get(rank) + 1);
        }
    }

    public Integer getBy(Rank rank) {
        return rankTable.get(rank);
    }

    public Money getTotalAwards() {
        List<Money> monies = rankTable.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .map(entry -> {
                    Money rewardPrice = entry.getKey().getPrizeMoney();
                    int rewardCount = entry.getValue();
                    return rewardPrice.multiply(rewardCount);
                })
                .toList();
        return Money.addAll(monies);
    }
}
