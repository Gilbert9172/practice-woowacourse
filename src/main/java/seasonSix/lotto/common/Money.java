package seasonSix.lotto.common;

public class Money {

    public static Money zero = new Money(0L);

    private Long money;

    private Money(Long money) {
        this.money = money;
    }

    public static Money newOne(Long money) {
        return new Money(money);
    }
}
