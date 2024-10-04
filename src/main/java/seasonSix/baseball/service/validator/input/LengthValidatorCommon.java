package seasonSix.baseball.service.validator.input;

import java.util.List;

public class LengthValidatorCommon extends CommonListValidator {


    @Override
    public void check(List<Integer> input) {
        if (input.size() != 3) {
            throw new IllegalArgumentException("길이 3으로 ㄱㄱ");
        }
        super.check(input);
    }
}
