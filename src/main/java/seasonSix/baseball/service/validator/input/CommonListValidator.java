package seasonSix.baseball.service.validator.input;

import java.util.List;

abstract class CommonListValidator {
    protected CommonListValidator next = null;

    public CommonListValidator doChain(CommonListValidator validator) {
        this.next = validator;
        return validator;
    }

    public void check(List<Integer> input) {
        if (next != null) {
            next.check(input);
        }
    }
}
