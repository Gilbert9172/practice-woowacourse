package seasonSix.chrismas.model;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;

import java.util.Map;

public class Order {
    private Map<Food, Integer> menu;
    private Money originalPayment;
    private Money totalDiscount;
    private Money finalPayment;



    public Order(Map<Food, Integer> menu, Money originalPayment, Money totalDiscount, Money finalPayment) {
        this.menu = menu;
        this.originalPayment = originalPayment;
        this.totalDiscount = totalDiscount;
        this.finalPayment = finalPayment;
    }
}
