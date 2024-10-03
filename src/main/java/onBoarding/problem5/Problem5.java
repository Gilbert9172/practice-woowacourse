package onBoarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private final int[] currencies = Currency.getPrices();

    public List<Integer> solution(int price) {
        return exchange(price);
    }

    public List<Integer> exchange(int price) {
        List<Integer> wallet = new ArrayList<>();
        for (int currency : currencies) {
            int exchanged = price / currency;
            wallet.add(exchanged);
            price = price % currency;
        }
        return wallet;
    }
}
