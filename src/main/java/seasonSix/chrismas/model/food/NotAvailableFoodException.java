package seasonSix.chrismas.model.food;

public class NotAvailableFoodException extends RuntimeException {
    public NotAvailableFoodException() {
        super("[Error] 없는 메뉴");
    }
}
