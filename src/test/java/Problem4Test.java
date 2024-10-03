import org.junit.jupiter.api.Test;
import onBoarding.problem4.Problem4;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem4Test {

    private final Problem4 problem4 = new Problem4();

    @Test
    void case1() {
        String word = "I love you";
        String result = "R olev blf";
        assertThat(problem4.solution(word)).isEqualTo(result);
    }

    @Test
    void case2() {
        String word = "abcdefghijklmnopqrstuvwxyz !@#$%^&*  ";
        String result = "zyxwvutsrqponmlkjihgfedcba !@#$%^&*  ";
        assertThat(problem4.solution(word)).isEqualTo(result);
    }

    @Test
    void case3() {
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$%^&*  ";
        String result = "ZYXWVUTSRQPONMLKJIHGFEDCBA !@#$%^&*  ";
        assertThat(problem4.solution(word)).isEqualTo(result);
    }
}
