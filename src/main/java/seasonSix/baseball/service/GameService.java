package seasonSix.baseball.service;

import seasonSix.baseball.model.GameManager;
import seasonSix.baseball.model.Pitching;
import seasonSix.baseball.infra.view.ResultView;
import seasonSix.baseball.service.message.ServiceMessage;

public class GameService {

    public void playBall() {
        GameManager manager = GameManager.initiate();
        while (manager.playBall()) {
            int userInput = ServiceMessage.plzEnterNumber();
            Pitching user = Pitching.initiate(userInput);
            int strike = manager.countStrike(user);
            int ball = manager.countBall(user);
            ResultView resultView = ResultView.initiate(strike, ball);
            resultView.printResult();
            manageGameProcess(manager);
        }
    }

    private void manageGameProcess(GameManager manager) {
        if (manager.isFinishable()) {
            int userInput = ServiceMessage.plzEnterFlag();
            manager.remanaging(userInput);
        }
    }
}
