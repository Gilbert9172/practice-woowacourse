package seasonSix.lotto.model;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.model.validator.InputFacadeValidator;
import seasonSix.lotto.model.lotto.Lotto;
import seasonSix.lotto.model.lotto.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private List<Lotto> lottos = new ArrayList<>();
    private Money purchasePrice;
    private Map<Rank, Integer> rankTable = new HashMap<>();
    private String benefit;

    private User(List<Lotto> lottos, Money purchasePrice) {
        InputFacadeValidator.checkPurchaseAmount(purchasePrice.toString());
        this.lottos = lottos;
        this.purchasePrice = purchasePrice;
        this.benefit = "0.0";
        this.rankTable = initiateRankTable();
    }

    private Map<Rank, Integer> initiateRankTable() {
        Map<Rank, Integer> rankTable = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> rankTable.put(rank, 0));
        return rankTable;
    }

    public static User of(List<Lotto> lottos, Money purchasePrice) {
        return new User(lottos, purchasePrice);
    }

    public void finishAdjustment(String benefit) {
        this.benefit = benefit;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Money getPurchasePrice() {
        return purchasePrice;
    }

    public Map<Rank, Integer> getRankTable() {
        return rankTable;
    }

    public String getBenefit() {
        return benefit;
    }

    public Map<Rank, Integer> getRankTableExceptNone() {
        return rankTable.entrySet()
                .stream()
                .filter(entry -> Rank.isNotNone(entry.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }
}
