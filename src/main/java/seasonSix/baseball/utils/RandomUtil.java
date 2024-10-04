package seasonSix.baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import seasonSix.baseball.model.Pitching;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {
    public static Pitching generateIntegerList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return Pitching.initiate(computer);
    }
}
