package seasonSix.chrismas.model;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.utils.PriceManagingUtil;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Food, Integer> purchase = new HashMap<>();
    private Money originalPrice;
    private int date;

    private Order(Map<Food, Integer> purchase, int date) {
        this.purchase = purchase;
        this.originalPrice = PriceManagingUtil.originalPrice(purchase);
        this.date = date;
    }

    public static Order newOne(Map<Food, Integer> purchase, int date) {
        return new Order(purchase, date);
    }

    public Map<Food, Integer> getPurchase() {
        return purchase;
    }

    public Money getOriginalPrice() {
        return originalPrice;
    }

    public int getDate() {
        return date;
    }
}
