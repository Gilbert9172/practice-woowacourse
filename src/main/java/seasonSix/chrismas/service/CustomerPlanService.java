package seasonSix.chrismas.service;

import seasonSix.chrismas.model.CustomerPlan;
import seasonSix.chrismas.model.Order;
import seasonSix.chrismas.model.event.EventManager;
import seasonSix.chrismas.model.Payment;

public class CustomerPlanService {

    public CustomerPlan generate(EventManager eventManager, Order order, Payment payment) {
        CustomerPlan customerPlan = CustomerPlan.newOne(order, payment, eventManager.getEvents());
        customerPlan.assignBadge();
        customerPlan.receivePrizeIfNecessary(eventManager.getPrize());
        return customerPlan;
    }
}
