package seasonSix.chrismas.service;

import seasonSix.chrismas.model.CustomerPlan;
import seasonSix.chrismas.model.Order;
import seasonSix.chrismas.model.Payment;
import seasonSix.chrismas.model.event.EventManager;

public class PlannerService {

    private final PricingSystemService pricingSystemService;
    private final CustomerPlanService customerPlanService;

    public PlannerService(PricingSystemService pricingSystemService,
                          CustomerPlanService customerPlanService) {
        this.pricingSystemService = pricingSystemService;
        this.customerPlanService = customerPlanService;
    }

    public CustomerPlan getCustomersTodayPlan(EventManager eventManager, Order order) {
        Payment eventPrices = pricingSystemService.managingPrice(eventManager, order);
        return customerPlanService.generate(eventManager, order, eventPrices);
    }
}
