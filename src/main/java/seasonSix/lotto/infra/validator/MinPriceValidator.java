package seasonSix.lotto.infra.validator;

import seasonSix.lotto.common.Money;
import seasonSix.lotto.infra.validator.exception.MinPriceException;
import seasonSix.lotto.model.GameManager;

import static seasonSix.lotto.common.message.ErrorMessage.PURCHASE_LIMIT_COUNT;

public class MinPriceValidator extends InputValidator {

    @Override
    public <T> void check(T source) {
        Money price = Money.newOne((Long) source);
        if (price.lowerThan(GameManager.price)) {
            throw new MinPriceException(PURCHASE_LIMIT_COUNT);
        }
    }
}
