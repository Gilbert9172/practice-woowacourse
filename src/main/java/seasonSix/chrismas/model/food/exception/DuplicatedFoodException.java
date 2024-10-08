package seasonSix.chrismas.model.food.exception;

import seasonSix.chrismas.common.exception.InputException;

import static seasonSix.chrismas.infra.view.message.ErrorMessage.FOOD_ERROR_MESSAGE;


public class DuplicatedFoodException extends InputException {
    public DuplicatedFoodException() {
        super(FOOD_ERROR_MESSAGE);
    }
}
