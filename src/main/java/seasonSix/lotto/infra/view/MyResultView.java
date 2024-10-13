package seasonSix.lotto.infra.view;

import seasonSix.lotto.model.lotto.LottoResult;

import java.math.BigDecimal;

public class MyResultView {
    private LottoResult resultTable;
    private String adjustment;

    private MyResultView(LottoResult resultTable, String adjustment) {
        this.resultTable = resultTable;
        this.adjustment = adjustment;
    }

    public static MyResultView from(LottoResult lottoResult, BigDecimal adjustment) {
        return new MyResultView(lottoResult, String.valueOf(adjustment));
    }

    public LottoResult getResultTable() {
        return resultTable;
    }

    public String getAdjustment() {
        return adjustment;
    }
}
