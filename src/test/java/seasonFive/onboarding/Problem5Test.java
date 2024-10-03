package seasonFive.onboarding;

import seasonFive.onBoarding.problem5.Problem5;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem5Test {

    private final Problem5 problem5 = new Problem5();

    @Test
    void case1() {
        int money = 50_237;
        List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
        assertThat(problem5.solution(money)).isEqualTo(result);
    }

    @Test
    void case2() {
        int money = 15_000;
        List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
        assertThat(problem5.solution(money)).isEqualTo(result);
    }
}
