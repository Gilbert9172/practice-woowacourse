import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import problem1.Problem1;
import problem2.Problem2;
import problem3.Problem3;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {
    @Nested
    class Problem1Test {
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

    @Nested
    class Problem2Test {
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

    @Nested
    class Problem3Test {
        @Test
        void case1() {
            int input = 33;
            int expected = 14;
            Problem3 problem3 = new Problem3();
            assertThat(problem3.solution(input)).isEqualTo(expected);
        }
    }
}
