package seasonSix.lotto.infra.validator;

public class InputFacadeValidator {
    public static void checkPurchaseAmount(String source) {
        NumberRegexValidator numberRegexValidator = new NumberRegexValidator();
        MinPriceValidator minPriceValidator = new MinPriceValidator();

        numberRegexValidator.doChain(minPriceValidator);

        numberRegexValidator.check(source);
    }

    public static void checkWinningNumbers(String source) {
        DuplicatedNumberValidator duplicatedNumberValidation = new DuplicatedNumberValidator();
        NumbersRegexValidator numbersRegexValidator = new NumbersRegexValidator();
        NumberRangeValidator numberRangeValidator = new NumberRangeValidator();
        NumberLengthValidator numberLengthValidator = new NumberLengthValidator();

        duplicatedNumberValidation
                .doChain(numbersRegexValidator)
                .doChain(numberRangeValidator)
                .doChain(numberLengthValidator);

        duplicatedNumberValidation.check(source);
    }
}
