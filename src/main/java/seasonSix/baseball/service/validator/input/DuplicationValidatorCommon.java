package seasonSix.baseball.service.validator.input;

import java.util.List;

public class DuplicationValidatorCommon extends CommonListValidator {
    @Override
    public void check(List<Integer> input) {
        List<Integer> noduplicationList = input.stream().distinct().toList();
        if (noduplicationList.size() < 3) {
            throw new IllegalArgumentException("[Error] 중복된 숫자 ㄴㄴ");
        }
        super.check(input);
    }
}
