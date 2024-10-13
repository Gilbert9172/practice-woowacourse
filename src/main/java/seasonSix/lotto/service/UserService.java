package seasonSix.lotto.service;

import seasonSix.baseball.infra.view.ResultView;
import seasonSix.lotto.common.Money;
import seasonSix.lotto.common.utils.ConvertingUtil;
import seasonSix.lotto.common.utils.MathUtil;
import seasonSix.lotto.infra.view.MyResultView;
import seasonSix.lotto.model.LottoManager;
import seasonSix.lotto.model.User;
import seasonSix.lotto.model.lotto.Lotto;
import seasonSix.lotto.model.lotto.Rank;

import java.util.*;

public class UserService {

    private final LottoService lottoService;

    public UserService(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public MyResultView startGame(LottoManager manager, List<Lotto> lottos, Money purchasePrice) {
        User user = createUser(lottos, purchasePrice);
        matchingNumbers(manager, user);
        calculateAdjustment(user);
        return MyResultView.from(user);
    }

    public User createUser(List<Lotto> lottos, Money purchasePrice) {
        return User.of(lottos, purchasePrice);
    }

    public void matchingNumbers(LottoManager manager, User user) {
        Map<Rank, Integer> rankTable = new HashMap<>();
        user.getLottos().forEach(lotto -> {
            Rank rank = lottoService.assignRank(manager, lotto);
            putOrUpdate(rankTable, rank);
        });
        user.finishMatchingNumbers(rankTable);
    }

    private void putOrUpdate(Map<Rank, Integer> rankTable, Rank rank) {
        rankTable.put(rank, rankTable.getOrDefault(rank, 0) + 1);
    }

    public void calculateAdjustment(User user) {
        List<Money> moneyList = ConvertingUtil.rankMapToMoneyList(user.getRankTable());
        Money earned = Money.addAll(moneyList);
        Money purchased = user.getPurchasePrice();
        if (!earned.lowerThan(purchased)) {
            Money benefit = earned.minus(purchased);
            String divideResult = MathUtil.divide(benefit.getVal(), purchased.getVal());
            user.finishAdjustment(divideResult);
        }
    }
}
