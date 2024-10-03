import onBoarding.problem6.Problem6;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6Test {

    Problem6 problem6 = new Problem6();

    @Test
    void case1() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        assertThat(problem6.solution(forms)).isEqualTo(result);
    }

    @Test
    void case2() {
        List<List<String>> forms = List.of(
                List.of("100@email.com", "백"),
                List.of("200@email.com", "이백"),
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("jm100@email.com", "제이엠백"),
                List.of("mj@email.com", "엠제이"),
                List.of("mj200@email.com", "엠제이이백"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> result = List.of("200@email.com", "jason@email.com", "jm100@email.com", "jm@email.com", "mj200@email.com", "mj@email.com");
        assertThat(problem6.solution(forms)).isEqualTo(result);
    }
}
