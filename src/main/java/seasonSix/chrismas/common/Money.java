package seasonSix.chrismas.common;

public class Money {

    public static Money zero = Money.newOne(0);

    private final long val;

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
}
