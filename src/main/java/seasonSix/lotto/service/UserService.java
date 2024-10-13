package seasonSix.lotto.service;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.common.utils.MathUtil;
import seasonSix.lotto.infra.view.MyResultView;
import seasonSix.lotto.model.LottoManager;
import seasonSix.lotto.model.lotto.Lotto;
import seasonSix.lotto.model.lotto.LottoResult;
import seasonSix.lotto.model.lotto.Rank;

import java.math.BigDecimal;
import java.util.List;

public class UserService {

    private final LottoService lottoService;

    public UserService(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public MyResultView startGame(LottoManager manager, List<Lotto> lottos, Money purchasePrice) {
        LottoResult lottoResult = matchingNumbers(manager, lottos);
        BigDecimal adjustment = calculateAdjustment(lottoResult, purchasePrice);
        return MyResultView.from(lottoResult, adjustment);
    }

    public LottoResult matchingNumbers(LottoManager manager, List<Lotto> lottos) {
        LottoResult lottoResult = LottoResult.of();
        lottos.forEach(lotto -> {
            Rank rank = lottoService.assignRank(manager, lotto);
            lottoResult.updateIfNecessary(rank);
        });
        return lottoResult;
    }

    public BigDecimal calculateAdjustment(LottoResult lottoResult, Money purchased) {
        Money earned = lottoResult.getTotalAwards();
        if (earned.boeThan(purchased)) {
            Money benefit = earned.minus(purchased);
            return MathUtil.getBenefit(benefit.getVal(), purchased.getVal());
        }
        Money damage = purchased.minus(earned);
        return MathUtil.getDamage(damage.getVal(), purchased.getVal());
    }
}
