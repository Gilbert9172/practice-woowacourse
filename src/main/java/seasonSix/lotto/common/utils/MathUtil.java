package seasonSix.lotto.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtil {
    public static BigDecimal getBenefit(long money, long purchased) {
        BigDecimal result = divideAndMultiply(money, purchased);
        return result.setScale(1, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal getDamage(long money, long purchased) {
        BigDecimal temp = divideAndMultiply(money, purchased);
        BigDecimal rescaledTemp = temp.setScale(1, RoundingMode.HALF_EVEN);
        return BigDecimal.valueOf(100).subtract(rescaledTemp);
    }

    private static BigDecimal divideAndMultiply(long money, long purchased) {
        BigDecimal benefitDecimal = BigDecimal.valueOf(money);
        BigDecimal purchasedDecimal = BigDecimal.valueOf(purchased);
        BigDecimal divideResult = benefitDecimal.divide(purchasedDecimal, 5, RoundingMode.HALF_UP);
        return divideResult.multiply(BigDecimal.valueOf(100));
    }
}
