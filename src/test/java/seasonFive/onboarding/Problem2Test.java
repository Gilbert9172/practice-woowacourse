package seasonFive.onboarding;

import seasonFive.onBoarding.problem2.Problem2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem2Test {

    @Test
    void case1() {
        String cryptogram = "browoanoommnaon";
        String result = "brown";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case2() {
        String cryptogram = "zyelleyz";
        String result = "";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case3() {
        String cryptogram = "abbaaa";
        String result = "a";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case4() {
        String cryptogram = "abbaaacaac";
        String result = "a";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }
}
