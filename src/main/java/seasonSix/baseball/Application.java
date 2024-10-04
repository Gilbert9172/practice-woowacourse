package seasonSix.baseball;

import seasonSix.baseball.infra.controller.Controller;
import seasonSix.baseball.service.GameService;

public class Application {

    public static void main(String[] args) {
        GameService service = new GameService();
        Controller controller = new Controller(service);
        controller.startGame();
    }
}
