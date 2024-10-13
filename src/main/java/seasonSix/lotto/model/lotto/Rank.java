package seasonSix.lotto.model.lotto;

import seasonSix.lotto.common.Money;

import java.util.Arrays;
import java.util.Comparator;

public enum Rank {
    FIRST(6, 0, Money.of(2000000000L)),
    SECOND(5, 1, Money.of(30000000L)),
    THIRD(5, 0, Money.of(1500000L)),
    FOURTH(4, 0, Money.of(50000L)),
    FIFTH(3, 0, Money.of(5000L)),
    NONE(0, 0, Money.zero),
    ;

    private final int condition;
    private final int bonusNumber;
    private final Money prizeMoney;

    Rank(int condition, int bonusNumber, Money prizeMoney) {
        this.condition = condition;
        this.bonusNumber = bonusNumber;
        this.prizeMoney = prizeMoney;
    }
    public static Rank calculateRank(int matchedCount, int matchedBonusCount) {
        Comparator<Rank> comparator = Comparator.comparingInt(Rank::getCondition)
                .reversed()
                .thenComparing(Rank::getBonusNumber);
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.condition <= matchedCount)
                .filter(rank -> rank.bonusNumber == matchedBonusCount)
                .sorted(comparator)
                .reduce((high, low) -> high)
                .orElse(NONE);
    }

    public static boolean isNotNone(Rank rank) {
        return rank != NONE;
    }

    public int getCondition() {
        return condition;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }
}
