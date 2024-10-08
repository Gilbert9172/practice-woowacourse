package seasonSix.chrismas.model;

import seasonSix.chrismas.common.Money;

import java.util.Arrays;

public enum Badge {

    NONE(Money.newOne(0)),
    STAR(Money.newOne(5000)),
    TREE(Money.newOne(10000)),
    SANTA(Money.newOne(20000))
    ;

    final Money limitMoney;

    Badge(Money limitMoney) {
        this.limitMoney = limitMoney;
    }

    public static Badge assignBy(Money money) {
        return Arrays.stream(Badge.values())
                .filter(badge -> money.boeThan(badge.limitMoney))
                .findFirst()
                .orElse(NONE);
    }
}
