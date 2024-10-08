package seasonSix.chrismas.model.food.exception;

import seasonSix.chrismas.common.exception.InputException;
import seasonSix.chrismas.infra.view.message.ErrorMessage;

public class NotAvailableFoodException extends InputException {
    public NotAvailableFoodException() {
        super(ErrorMessage.FOOD_ERROR_MESSAGE);
    }
}
