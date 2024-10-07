package seasonSix.chrismas.common;

public class Money {
    private long val;

    public static Money newOne(long val) {
        return new Money(val);
    }

    private Money(long val) {
        this.val = val;
    }


}
