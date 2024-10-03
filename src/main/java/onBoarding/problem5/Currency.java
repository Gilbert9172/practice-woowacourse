package onBoarding.problem5;

import java.util.Arrays;

public enum Currency {
    MONEY_50000(50000),
    MONEY_10000(10000),
    MONEY_5000(5000),
    MONEY_1000(1000),
    MONEY_500(500),
    MONEY_100(100),
    MONEY_50(50),
    MONEY_10(10),
    MONEY_1(1);

    private final int price;

    Currency(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static int[] getPrices() {
        return Arrays.stream(Currency.values()).mapToInt(Currency::getPrice).toArray();
    }
}
