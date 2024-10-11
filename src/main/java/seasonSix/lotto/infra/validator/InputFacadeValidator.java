package seasonSix.lotto.infra.validator;

public class InputFacadeValidator {
    public static void check(String source) {
        NumberRegexValidator numberRegexValidator = new NumberRegexValidator();
        MinPriceValidator minPriceValidator = new MinPriceValidator();
        numberRegexValidator.doChain(minPriceValidator);
        numberRegexValidator.check(source);
    }
}
