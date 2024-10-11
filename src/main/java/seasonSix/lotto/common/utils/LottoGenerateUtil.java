package seasonSix.lotto.common.utils;

import camp.nextstep.edu.missionutils.Randoms;
import seasonSix.lotto.model.lotto.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.LongStream;

public class LottoGenerateUtil {
    public static List<Lotto> generate(long purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        LongStream.range(0, purchaseCount).forEach((i) -> {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Comparator.naturalOrder());
            lottos.add(Lotto.newOne(numbers));
        });
        return lottos;
    }
}
