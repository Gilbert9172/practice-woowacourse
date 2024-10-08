package seasonSix.chrismas.model.event;

import seasonSix.chrismas.common.Money;

public enum DiscountTable {
    WEEKEND(Money.newOne(2023)),
    WEEKDAYS(Money.newOne(2023)),
    PRIZE(Money.newOne(120000)),
    SPECIAL(Money.newOne(1000)),
    CHRISTMAS_DEFAULT(Money.newOne(1000)),
    CHRISTMAS_DAILY(Money.newOne(100));

    private final Money money;

    DiscountTable(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }
}
