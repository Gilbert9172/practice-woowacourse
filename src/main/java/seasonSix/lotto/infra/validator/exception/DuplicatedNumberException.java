package seasonSix.lotto.infra.validator.exception;

public class DuplicatedNumberException extends RuntimeException{
    public DuplicatedNumberException(String message) {
        super(message);
    }
}
