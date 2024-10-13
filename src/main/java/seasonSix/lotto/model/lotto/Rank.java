package seasonSix.lotto.model.lotto;

import seasonSix.lotto.common.Money;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Rank {
    FIRST(6, false, Money.of(2000000000L)),
    SECOND(5, true, Money.of(30000000L)),
    THIRD(5, false, Money.of(1500000L)),
    FOURTH(4, false, Money.of(50000L)),
    FIFTH(3, false, Money.of(5000L)),
    NONE(0, false, Money.zero),
    ;

    private final int minMatchedCount;
    private final boolean bonusCondition;
    private final Money prizeMoney;

    Rank(int minMatchedCount, boolean bonusCondition, Money prizeMoney) {
        this.minMatchedCount = minMatchedCount;
        this.bonusCondition = bonusCondition;
        this.prizeMoney = prizeMoney;
    }
    public static Rank calculateRank(int matchedCount, boolean bonusCondition) {
        Comparator<Rank> comparator = Comparator.comparingInt(Rank::getCondition)
                .reversed();
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.minMatchedCount <= matchedCount)
                .filter(rank -> rank.bonusCondition == bonusCondition)
                .sorted(comparator)
                .reduce((high, low) -> high)
                .orElse(NONE);
    }

    public static List<Rank> sortedValuesExceptNone() {
        return Arrays.stream(Rank.values())
                .sorted(Comparator.comparing(Rank::getPrizeMoney))
                .filter(Rank::isNotNone)
                .toList();
    }

    public static boolean isNotNone(Rank rank) {
        return rank != NONE;
    }

    public int getCondition() {
        return minMatchedCount;
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }
}
