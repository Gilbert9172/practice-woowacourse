package seasonSix.chrismas.service;

import seasonSix.chrismas.model.CustomerPlan;
import seasonSix.chrismas.model.event.EventManager;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.exception.NotAvailableFoodException;
import seasonSix.chrismas.repository.FoodRepository;
import seasonSix.chrismas.service.dto.Payment;

import java.util.Map;

public class CustomerPlanService {

    private final FoodRepository foodRepository;

    public CustomerPlanService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public CustomerPlan generate(EventManager eventManager, Map<Food, Integer> purchase, Payment payment) {
        Food prize = foodRepository.findByName("샴페인").orElseThrow(NotAvailableFoodException::new);
        CustomerPlan customerPlan = CustomerPlan.newOne(purchase, payment);
        customerPlan.assignBadge();
        customerPlan.isPrizeReceivable(prize);
        customerPlan.assignAppliedEvents(eventManager.getEvents());
        return customerPlan;
    }

}
