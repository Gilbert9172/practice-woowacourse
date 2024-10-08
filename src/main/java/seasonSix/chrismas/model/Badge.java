package seasonSix.chrismas.model;

import seasonSix.chrismas.common.Money;

import java.util.Arrays;

public enum Badge {

    NONE(Money.newOne(0), "없음"),
    STAR(Money.newOne(5000), "별"),
    TREE(Money.newOne(10000), "나무"),
    SANTA(Money.newOne(20000), "산타")
    ;

    final Money limitMoney;
    final String title;

    Badge(Money limitMoney, String title) {
        this.limitMoney = limitMoney;
        this.title = title;
    }

    public static Badge assignBy(Money money) {
        return Arrays.stream(Badge.values())
                .filter(badge -> money.boeThan(badge.limitMoney))
                .findFirst()
                .orElse(NONE);
    }
}
