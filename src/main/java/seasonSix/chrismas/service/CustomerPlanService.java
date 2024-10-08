package seasonSix.chrismas.service;

import seasonSix.chrismas.model.CustomerPlan;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.service.dto.Payment;

import java.util.Map;

public class CustomerPlanService {

    public CustomerPlan generate(Map<Food, Integer> purchase, Payment payment) {
        CustomerPlan customerPlan = CustomerPlan.newOne(purchase, payment);
        customerPlan.assignBadge();
        customerPlan.isPrizeReceivable();
        return customerPlan;
    }

}
