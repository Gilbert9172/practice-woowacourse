package seasonSix.chrismas.infra.view.message;


import java.util.Map;
import java.util.Objects;

public class OutputMessage {

    public static void none() {
        System.out.println("없음");
    }

    public static void emptyLine() {
        System.out.println();
    }

    public static void notice(int date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n", date);
        emptyLine();
    }

    public static void purchase(Map<String, Integer> purchase) {
        System.out.println("<주문 메뉴>");
        purchase.forEach((foodName, amount) -> System.out.printf("%s %d개\n", foodName, amount));
        emptyLine();
    }

    public static void originalPrice(String price) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%s원\n", price);
        emptyLine();
    }

    public static void receivedPrize(String foodName, int amount) {
        System.out.println("<증정 메뉴>");
        if (amount == 0) {
            none();
        }
        if (amount > 0) {
            System.out.printf("%s %d개\n", foodName, amount);
        }
        emptyLine();
    }

    public static void events(Map<String, String> eventPrices) {
        System.out.println("<혜택 내역>");
        if (eventPrices.isEmpty()) {
            none();
        }
        if (!eventPrices.isEmpty()) {
            eventPrices.forEach((eventName, price) -> System.out.printf("%s -%s원\n", eventName, price));
        }
        emptyLine();
    }

    public static void totalBenefitPrice(String price) {
        System.out.println("<총혜택 금액>");
        if (Objects.equals(price, "0")) {
            System.out.printf("%s원\n", price);
        }
        if (!Objects.equals(price, "0")) {
            System.out.printf("-%s원\n", price);
        }
        emptyLine();
    }

    public static void finalPrice(String price) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%s원\n", price);
        emptyLine();
    }

    public static void assignedBadge(String badgeName) {
        System.out.println("<12월 이벤트 배지>");
        if (badgeName.isEmpty()) {
            none();
        }
        System.out.println(badgeName);
    }
}
