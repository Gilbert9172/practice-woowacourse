package seasonFive.onboarding;

import org.junit.jupiter.api.Test;
import seasonFive.onBoarding.problem7.Problem7;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7Test {


    @Test
    void case1() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case2() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko", "jun"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "bedi");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case3() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko", "jun"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("jun", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "bedi");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case4() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko", "jun"),
                List.of("bedi", "jun"),
                List.of("bedi", "donut"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("jun", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("donut", "shakevan");
        List<String> result = List.of("andole", "bedi");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case5() {
        String user = "hello";
        List<List<String>> friends = List.of(
                List.of("andole", "jun"),
                List.of("andole", "bedi"),
                List.of("jun", "shakevan"),
                List.of("jun", "kane"),
                List.of("jun", "sam"),
                List.of("bedi", "shakevan"),
                List.of("bedi", "anne"),
                List.of("bedi", "sam"),
                List.of("anne", "mrko")
        );
        List<String> visitors = List.of("donut", "anne", "mrko", "mrko", "sam");
        List<String> result = List.of("mrko", "anne", "donut", "sam");

        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }
}
