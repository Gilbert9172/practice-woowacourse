package seasonFive.onboarding;

import seasonFive.onBoarding.problem3.Problem3;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @Test
    void case1() {
        int input = 33;
        int expected = 14;

        Problem3 problem3 = new Problem3();
        assertThat(problem3.solution(input)).isEqualTo(expected);
    }
}
