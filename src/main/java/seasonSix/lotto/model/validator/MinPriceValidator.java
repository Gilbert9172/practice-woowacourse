package seasonSix.lotto.model.validator;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.model.validator.exception.MinPriceException;

import static seasonSix.lotto.common.message.ErrorMessage.PURCHASE_LIMIT_COUNT;

public class MinPriceValidator extends InputValidator {

    @Override
    @SuppressWarnings("unchecked")
    public <T> void check(T source) {
        String strSource = (String) source;
        Money price = Money.of(Long.parseLong(strSource));
        if (price.isLowerThanMinPurchasePrice()) {
            throw new MinPriceException(PURCHASE_LIMIT_COUNT);
        }
    }
}
