package seasonSix.racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static int generateRandomNum() {
        return Randoms.pickNumberInRange(0,9);
    }
}
