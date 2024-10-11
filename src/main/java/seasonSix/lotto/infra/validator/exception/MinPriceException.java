package seasonSix.lotto.infra.validator.exception;

public class MinPriceException extends NumberFormatException{
    public MinPriceException(String msg) {
        super(msg);
    }
}
