package seasonSix.baseball.model;

public enum GameStatus {
    PLAY_BALL(1),
    FINISH(2);

    private final int val;

    GameStatus(int val) {
        this.val = val;
    }

    public static boolean isPlayBall(GameStatus status) {
        return status == PLAY_BALL;
    }

    public static GameStatus valueOf(int val) {
        for (GameStatus status : GameStatus.values()) {
            if (status.val == val) {
                return status;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + val);
    }
}
