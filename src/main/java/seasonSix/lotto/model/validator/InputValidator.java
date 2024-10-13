package seasonSix.lotto.model.validator;

public class InputValidator {
    private InputValidator next = null;

    public InputValidator doChain(InputValidator validator) {
        this.next = validator;
        return validator;
    }

    public <T> void check(T source) {
        if (next != null) {
            next.check(source);
        }
    }
}
