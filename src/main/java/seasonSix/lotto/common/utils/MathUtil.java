package seasonSix.lotto.common.utils;

import seasonSix.lotto.common.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtil {
    public static String getBenefit(long benefit, long purchased) {
        BigDecimal benefitDecimal = BigDecimal.valueOf(benefit);
        BigDecimal purchasedDecimal = BigDecimal.valueOf(purchased);
        BigDecimal divideResult = benefitDecimal.divide(purchasedDecimal, 5, RoundingMode.HALF_UP);
        BigDecimal multiplyResult = divideResult.multiply(BigDecimal.valueOf(100));
        BigDecimal result = multiplyResult.setScale(1, RoundingMode.HALF_EVEN);
        return String.valueOf(result);
    }

    public static String getDamage(long benefit, long purchased) {
        BigDecimal benefitDecimal = BigDecimal.valueOf(benefit);
        BigDecimal purchasedDecimal = BigDecimal.valueOf(purchased);
        BigDecimal divideResult = benefitDecimal.divide(purchasedDecimal, 5, RoundingMode.HALF_UP);
        BigDecimal multiplyResult = divideResult.multiply(BigDecimal.valueOf(100));
        BigDecimal result = multiplyResult.setScale(1, RoundingMode.HALF_EVEN);
        BigDecimal subtract = BigDecimal.valueOf(100).subtract(result);
        return String.valueOf(subtract);
    }
}
