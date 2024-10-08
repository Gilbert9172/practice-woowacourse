package seasonSix.chrismas.model.event.exception;

import static seasonSix.chrismas.infra.view.message.ErrorMessage.EVENT_ERROR_MESSAGE;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException() {
        super(EVENT_ERROR_MESSAGE);
    }
}
