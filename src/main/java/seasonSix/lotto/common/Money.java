package seasonSix.lotto.common;

import seasonSix.lotto.common.validator.exception.LowerThanZeroException;

import static seasonSix.lotto.common.message.ErrorMessage.LOWER_THAN_ZERO;

public class Money {

    public static final Money zero = new Money(0);
    public static final Money lottoPrice = Money.of(1000L);

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

    public boolean lowerThan(Money money) {
        return getVal() < money.getVal();
    }

    public long getVal() {
        return val;
    }

    public long getLottoCount() {
        return this.val / lottoPrice.getVal();
    }

    public boolean isLowerThanMinPurchasePrice() {
        return this.lowerThan(lottoPrice);
    }
}
