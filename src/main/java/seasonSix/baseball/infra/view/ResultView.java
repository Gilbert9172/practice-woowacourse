package seasonSix.baseball.infra.view;

public class ResultView {
    private int strikeCnt;
    private int ballCnt;

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void printResult() {
        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        }
        if (strikeCnt > 0 && ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
        }
        if (strikeCnt == 0 && ballCnt > 0) {
            System.out.println(ballCnt + "볼");
        }
        if (strikeCnt > 0 && ballCnt > 0) {
            System.out.println(ballCnt + "볼" + " " + strikeCnt + "스트라이크");
        }
    }

    public static ResultView initiate(int strike, int ball) {
        return new ResultView(strike, ball);
    }

    private ResultView(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }
}
