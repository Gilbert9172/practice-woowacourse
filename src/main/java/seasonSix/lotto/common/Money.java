package seasonSix.lotto.common;

import seasonSix.lotto.common.validator.exception.LowerThanZeroException;

import java.text.DecimalFormat;
import java.util.List;

import static seasonSix.lotto.common.message.ErrorMessage.LOWER_THAN_ZERO;

public class Money implements Comparable<Money> {

    public static final Money zero = new Money(0);
    public static final Money lottoPrice = Money.of(1000L);
    private static DecimalFormat wonFormatter = new DecimalFormat("###,###");

    private long val;

    private Money(long val) {
        this.val = val;
    }

    public static Money of(long val) {
        if (val < 0) {
            throw new LowerThanZeroException(LOWER_THAN_ZERO);
        }
        return new Money(val);
    }

    public static Money addAll(List<Money> moneyList) {
        long amount = moneyList.stream()
                .map(Money::getVal)
                .mapToLong(Long::longValue)
                .sum();
        return Money.of(amount);
    }

    public boolean lowerThan(Money money) {
        return getVal() < money.getVal();
    }

    public boolean boeThan(Money money) {
        return getVal() >= money.getVal();
    }

    public Money minus(Money money) {
        long minus = this.val - money.val;
        if (minus < 0) {
            throw new IllegalArgumentException();
        }
        return Money.of(minus);
    }

    public Money multiply(long value) {
        return Money.of(this.val * value);
    }

    public long getVal() {
        return val;
    }

    public String toWon() {
        return wonFormatter.format(this.val);
    }

    public long getLottoCount() {
        return this.val / lottoPrice.getVal();
    }

    public boolean isLowerThanMinPurchasePrice() {
        return this.lowerThan(lottoPrice);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public int compareTo(Money o) {
        return Long.compare(this.val, o.val);
    }
}
