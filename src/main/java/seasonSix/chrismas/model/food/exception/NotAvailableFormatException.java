package seasonSix.chrismas.model.food.exception;

import seasonSix.chrismas.common.exception.InputException;

import static seasonSix.chrismas.infra.view.message.ErrorMessage.FOOD_ERROR_MESSAGE;

public class NotAvailableFormatException extends InputException {
    public NotAvailableFormatException() {
        super(FOOD_ERROR_MESSAGE);
    }
}
