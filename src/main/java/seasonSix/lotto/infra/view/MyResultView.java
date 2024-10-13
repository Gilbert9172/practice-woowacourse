package seasonSix.lotto.infra.view;

import seasonSix.lotto.model.User;
import seasonSix.lotto.model.lotto.Rank;

import java.util.HashMap;
import java.util.Map;

public class MyResultView {
    private Map<Rank, Integer> resultTable = new HashMap<>();
    private String benefit;

    private MyResultView(Map<Rank, Integer> resultTable, String benefit) {
        this.resultTable = resultTable;
        this.benefit = benefit;
    }

    public static MyResultView from(User user) {
        Map<Rank, Integer> rankTableExceptNone = user.getRankTableExceptNone();
        String benefit = user.getBenefit();
        return new MyResultView(rankTableExceptNone, benefit);
    }

    public Map<Rank, Integer> getResultTable() {
        return resultTable;
    }

    public String getBenefit() {
        return benefit;
    }
}
