package seasonSix.chrismas.model;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.utils.PriceManagingUtil;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Food, Integer> purchase = new HashMap<>();
    private Money originalPrice;

    private Order(Map<Food, Integer> purchase) {
        this.purchase = purchase;
        this.originalPrice = PriceManagingUtil.originalPrice(purchase);
    }

    public static Order newOne(Map<Food, Integer> purchase) {
        return new Order(purchase);
    }

    public Map<Food, Integer> getPurchase() {
        return purchase;
    }

    public Money getOriginalPrice() {
        return originalPrice;
    }
}
