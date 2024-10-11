package seasonSix.lotto.infra.validator.exception;

public class RegexException extends NumberFormatException{
    public RegexException(String msg) {
        super(msg);
    }
}
