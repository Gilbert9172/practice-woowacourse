package seasonSix.lotto.infra.validator;

import seasonSix.lotto.model.lotto.Lotto;

public class InputFacadeValidator {
    public static void checkPurchaseAmount(String source) {
        PriceRegexValidator priceRegexValidator = new PriceRegexValidator();
        MinPriceValidator minPriceValidator = new MinPriceValidator();

        priceRegexValidator.doChain(minPriceValidator);

        priceRegexValidator.check(source);
    }

    public static void checkWinningNumbers(String source) {
        DuplicatedNumbersValidator duplicatedNumberValidation = new DuplicatedNumbersValidator();
        NumbersRegexValidator numbersRegexValidator = new NumbersRegexValidator();
        NumberRangeValidator numberRangeValidator = new NumberRangeValidator();
        NumberLengthValidator numberLengthValidator = new NumberLengthValidator();

        duplicatedNumberValidation
                .doChain(numbersRegexValidator)
                .doChain(numberRangeValidator)
                .doChain(numberLengthValidator);

        duplicatedNumberValidation.check(source);
    }

    public static void checkBonusNumber(String source, Lotto lotto) {
        NumberRangeValidator numberRangeValidator = new NumberRangeValidator();
        numberRangeValidator.check(source);
        DuplicatedNumberValidator duplicatedNumberValidator = new DuplicatedNumberValidator();
        duplicatedNumberValidator.check(source, lotto);
    }
}
