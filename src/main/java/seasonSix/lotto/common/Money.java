package seasonSix.lotto.common;

public class Money {

    public static Money zero = new Money(0);

    private long val;

    private Money(long val) {
        this.val = val;
    }

    public static Money newOne(long val) {
        return new Money(val);
    }

    public boolean lowerThan(Money money) {
        return getVal() < money.getVal();
    }

    public long getVal() {
        return val;
    }
}
