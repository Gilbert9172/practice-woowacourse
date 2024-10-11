package seasonSix.lotto.infra.controller;

import seasonSix.lotto.infra.InputManager;
import seasonSix.lotto.service.UserService;

public class GameController {

    private final UserService userService;

    public GameController(UserService userService) {
        this.userService = userService;
    }

    public void startGame() {
        long purchasePrice = InputManager.enterPurchasePrice();
    }
}
