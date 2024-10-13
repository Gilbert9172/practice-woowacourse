package seasonSix.lotto.common.utils;

import seasonSix.lotto.common.CommonConstant;
import seasonSix.lotto.common.Money;
import seasonSix.lotto.infra.view.MyResultView;
import seasonSix.lotto.model.lotto.Lotto;
import seasonSix.lotto.model.lotto.LottoResult;
import seasonSix.lotto.model.lotto.Rank;

import java.util.Comparator;
import java.util.List;

import static seasonSix.lotto.common.message.OutputMessage.*;

public class OutputUtil {

    public static void emptyLine() {
        System.out.println();
    }

    public static void printPurchase(List<Lotto> lottos, Money purchasePrice) {
        System.out.println(String.format(PURCHASED, purchasePrice.getLottoCount()));
        lottos.forEach(lotto -> {
            String message = String.format(BRACKETS, lotto.toString());
            System.out.println(message);
        });
        emptyLine();
    }


    public static void printResult(MyResultView resultView) {
        System.out.println(STATISTIC);
        System.out.println(STATISTIC_DIVIDER);

        LottoResult resultTable = resultView.getResultTable();
        List<Rank> ranks = Rank.sortedValuesExceptNone();
        buildRankSummary(resultTable, ranks);

        String benefitResult = String.format(STATISTICS, resultView.getAdjustment());
        System.out.println(benefitResult);
    }

    private static void buildRankSummary(LottoResult resultTable, List<Rank> ranks) {
        ranks.forEach(rank ->{
            StringBuilder message = new StringBuilder();
            Integer matchedCount = resultTable.getBy(rank);
            String minCondition = String.format(MATCHED_CONDITION, rank.getMinMatchedCount());
            String rewardPrice = String.format(AWARD_PRICE, rank.getPrizeMoney().toWon());
            String matchedResult = String.format(MATCHED_RESULT, matchedCount);
            if (rank == Rank.SECOND) {
                String bonus = BONUS_BALL;
                message.append(minCondition).append(bonus).append(rewardPrice).append(matchedResult);
            }
            if (rank != Rank.SECOND) {
                message.append(minCondition).append(rewardPrice).append(matchedResult);;
            }
            System.out.println(message);
        });
    }
}
