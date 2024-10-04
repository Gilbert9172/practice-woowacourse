package seasonSix.baseball.model;

import seasonSix.baseball.service.validator.input.InputValidationManager;
import seasonSix.baseball.utils.ConvertUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Pitching {
    private List<Integer> balls = new ArrayList<>();

    public Pitching() {}

    public static Pitching initiate(int num) {
        return new Pitching(num);
    }

    public static Pitching initiate(List<Integer> nums) {
        return new Pitching(nums);
    }

    public Pitching(List<Integer> balls) {
        this.balls = balls;
    }

    private Pitching(int num) {
        List<Integer> converted = ConvertUtil.intToList(num);
        InputValidationManager.validatePitches(converted);
        this.balls = converted;
    }

    public int size() {
        return balls.size();
    }


    public boolean contain(int num) {
        return balls.contains(num);
    }

    public Integer getBall(int idx) {
        return balls.get(idx);
    }
    public int countStrike(Pitching user) {
        return (int) IntStream.range(0, size())
                .filter(i -> getBall(i).equals(user.getBall(i)))
                .count();
    }

    public int countBall(Pitching user) {
        return (int) IntStream.range(0, size())
                .filter(i -> contain(user.getBall(i)))
                .filter(i -> !getBall(i).equals(user.getBall(i)))
                .count();
    }

}

