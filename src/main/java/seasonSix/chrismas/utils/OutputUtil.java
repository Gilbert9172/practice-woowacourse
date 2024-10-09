package seasonSix.chrismas.utils;

import seasonSix.chrismas.infra.view.CustomerPlanView;
import seasonSix.chrismas.infra.view.message.OutputMessage;

public class OutputUtil {

    public static void printResult(CustomerPlanView view) {
        OutputMessage.notice(view.getDate());
        OutputMessage.purchase(view.getPurchase());
        OutputMessage.originalPrice(view.getOriginalPrice());
        OutputMessage.receivedPrize(view.getPrizeName(), view.getPrizeCount());
        OutputMessage.events(view.getEvents());
        OutputMessage.totalBenefitPrice(view.getBenefitPrice());
        OutputMessage.finalPrice(view.getFinalPrice());
        OutputMessage.assignedBadge(view.getBadge());
    }
}
