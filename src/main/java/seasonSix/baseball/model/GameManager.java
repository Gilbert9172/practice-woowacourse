package seasonSix.baseball.model;

import seasonSix.baseball.service.validator.input.InputValidationManager;
import seasonSix.baseball.utils.RandomUtil;

public class GameManager {

    private final int THREE_STRIKE = 3;

    private GameStatus status;
    private Pitching cpu;
    private int strike;
    private int ball;

    private GameManager() {
        this.status = GameStatus.PLAY_BALL;
        this.cpu = RandomUtil.generateIntegerList();;
    }

    public static GameManager initiate() {
        return new GameManager();
    }

    public int countStrike(Pitching user) {
        strike = cpu.countStrike(user);
        return strike;
    }

    public int countBall(Pitching user) {
        ball = cpu.countBall(user);
        return ball;
    }

    public void remanaging(int flag) {
        InputValidationManager.validateRestartFlag(flag);
        status = GameStatus.valueOf(flag);
        if (playBall()) {
            cpu = RandomUtil.generateIntegerList();
        }
    }

    public boolean playBall() {
        return GameStatus.isPlayBall(status);
    }

    public boolean isFinishable() {
        return strike == THREE_STRIKE;
    }
}
