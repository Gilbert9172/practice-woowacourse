package seasonSix.lotto.service;

import seasonSix.lotto.common.utils.LottoGenerateUtil;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.List;

public class LottoService {

    public List<Lotto> generateLottos(Long purchasePrice) {
        long lottoCountBy = getLottoCount(purchasePrice);
        return LottoGenerateUtil.generate(lottoCountBy);
    }

    private long getLottoCount(Long purchasePrice) {
        long lottoPrice = Lotto.price.getVal();
        return purchasePrice / lottoPrice;
    }
}
