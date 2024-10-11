package seasonSix.lotto.model;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Lotto> lottos = new ArrayList<>();
    private Money purchasePrice;

    private User(List<Lotto> lottos, Money purchasePrice) {
        this.lottos = lottos;
        this.purchasePrice = purchasePrice;
    }

    public static User newOne(List<Lotto> lottos, Money purchasePrice) {
        return new User(lottos, purchasePrice);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public double getStatistic() {
        return 0.0;
    }
}
