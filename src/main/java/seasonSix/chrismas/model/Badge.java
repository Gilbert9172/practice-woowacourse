package seasonSix.chrismas.model;

import com.sun.source.tree.Tree;
import seasonSix.chrismas.common.Money;

import java.util.Arrays;
import java.util.Comparator;

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
                .sorted(Comparator.comparingLong(badge -> badge.limitMoney.getVal()))
                .reduce((first, second) -> second)
                .orElse(NONE);
    }
}
