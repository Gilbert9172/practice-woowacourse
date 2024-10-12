package seasonSix.lotto.model.lotto;

import seasonSix.lotto.common.Money;

public enum Rank {
    FIRST(6, 0, Money.of(2000000000L)),
    SECOND(5, 1, Money.of(30000000L)),
    THIRD(5,0, Money.of(1500000L)),
    FOURTH(4,0, Money.of(50000L)),
    FIFTH(3, 0, Money.of(5000L)),
    NONE(0, 0, Money.zero)
    ;

    private final int condition;
    private final int bonusBall;
    private final Money prizeMoney;

    Rank(int condition, int bonusBall, Money prizeMoney) {
        this.condition = condition;
        this.bonusBall = bonusBall;
        this.prizeMoney = prizeMoney;
    }
}
