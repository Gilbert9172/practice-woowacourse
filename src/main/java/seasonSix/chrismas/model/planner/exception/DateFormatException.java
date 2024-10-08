package seasonSix.chrismas.model.planner.exception;

import seasonSix.chrismas.common.exception.InputException;

import static seasonSix.chrismas.infra.view.message.ErrorMessage.DATE_ERROR_MESSAGE;

public class DateFormatException extends InputException {
    public DateFormatException() {
        super(DATE_ERROR_MESSAGE);
    }
}
