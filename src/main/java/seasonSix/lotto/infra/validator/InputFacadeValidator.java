package seasonSix.lotto.infra.validator;

import java.util.List;

public class InputFacadeValidator {

    public static void checkPurchaseAmount(Long source) {
        PriceRegexValidator priceRegexValidator = new PriceRegexValidator();
        MinPriceValidator minPriceValidator = new MinPriceValidator();

        priceRegexValidator.doChain(minPriceValidator);

        priceRegexValidator.check(source);
    }

    public static void checkWinningNumbers(List<Integer> source) {
        DuplicatedNumbersValidator duplicatedNumberValidation = new DuplicatedNumbersValidator();
        NumbersRegexValidator numbersRegexValidator = new NumbersRegexValidator();
        NumberLengthValidator numberLengthValidator = new NumberLengthValidator();

        duplicatedNumberValidation
                .doChain(numbersRegexValidator)
                .doChain(numberLengthValidator);

        duplicatedNumberValidation.check(source);
    }

    public static void checkBonusNumber(Integer source, List<Integer> numbers) {
        NumberRangeValidator numberRangeValidator = new NumberRangeValidator();
        numberRangeValidator.check(source);
        DuplicatedNumberValidator duplicatedNumberValidator = new DuplicatedNumberValidator();
        duplicatedNumberValidator.check(source, numbers);
    }
}
