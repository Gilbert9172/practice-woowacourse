import onBoarding.problem1.Problem1;
import onBoarding.problem2.Problem2;
import onBoarding.problem3.Problem3;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {

    @Test
    void case1() {
        int[] pobi = new int[]{97, 98};
        int[] crong = new int[]{197, 198};
        int result = 0;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    void case2() {
        int[] pobi = new int[]{131, 132};
        int[] crong = new int[]{211, 212};
        int result = 1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    void case3() {
        int[] pobi = new int[]{99, 102};
        int[] crong = new int[]{211, 212};
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    void case4() {
        int[] pobi = new int[]{401, 402};
        int[] crong = new int[]{211, 212};
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    void case5() {
        int[] pobi = new int[]{99, 100};
        int[] crong = new int[]{-1, 0};
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    void case6() {
        int[] pobi = new int[]{399, 400};
        int[] crong = new int[]{211, 212};
        int result = 1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

}
