package seasonSix.chrismas.common;

import java.text.DecimalFormat;
import java.util.List;

public class Money implements Comparable<Money> {

    public static Money zero = Money.newOne(0);
    private static DecimalFormat wonFormatter = new DecimalFormat("###,###");

    private long val;

    public static Money newOne(long val) {
        return new Money(val);
    }

    private Money(long val) {
        this.val = val;
    }

    public long getVal() {
        return val;
    }

    public Money add(Money money) {
        return Money.newOne(this.val + money.getVal());
    }

    public Money multiply(long value) {
        return Money.newOne(this.val * value);
    }

    public Money minus(Money money) {
        long minus = this.val - money.val;
        if (minus < 0) {
            throw new IllegalArgumentException();
        }
        return new Money(minus);
    }

    public boolean boeThan(Money money) {
        return this.val >= money.val;
    }
    public boolean lowerThen(Money money) {
        return this.val < money.val;
    }

    public static Money addAll(List<Money> monies) {
        long amount = monies.stream()
                .map(Money::getVal)
                .mapToLong(Long::longValue)
                .sum();
        return Money.newOne(amount);
    }

    public String toWon() {
        return wonFormatter.format(this.val);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Money money = (Money) obj;
        return money.getVal() == this.val;
    }

    @Override
    public int compareTo(Money o) {
        if (this.val > o.getVal()) {
            return -1;
        }
        if (this.val == o.getVal()) {
            return 0;
        }
        return 1;
    }
}
