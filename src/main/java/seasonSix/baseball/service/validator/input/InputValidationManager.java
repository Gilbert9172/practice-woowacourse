package seasonSix.baseball.service.validator.input;

import java.util.List;

public class InputValidationManager {

    public static void validatePitches(List<Integer> input) {
        LengthValidatorCommon lengthValidator = new LengthValidatorCommon();
        DuplicationValidatorCommon duplicationValidator = new DuplicationValidatorCommon();
        lengthValidator
                .doChain(duplicationValidator);
        lengthValidator.check(input);
    }

    public static void validateRestartFlag(int inptut) {
        RestartFlagValidator.validateInput(inptut);
    }
}
