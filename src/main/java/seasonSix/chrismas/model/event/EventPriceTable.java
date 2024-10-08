package seasonSix.chrismas.model.event;

import seasonSix.chrismas.common.Money;

public enum EventPriceTable {
    WEEKEND(Money.newOne(2023)),
    WEEKDAYS(Money.newOne(2023)),
    PRIZE(Money.newOne(25000)),
    SPECIAL(Money.newOne(1000)),
    CHRISTMAS_DEFAULT(Money.newOne(1000)),
    CHRISTMAS_DAILY(Money.newOne(100)),
    MIN_EVENT_APPLY_PRICE(Money.newOne(10000)),
    MIN_RECEIVABLE_PRICE(Money.newOne(120000));
    ;

    private final Money money;

    EventPriceTable(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }
}
