package seasonSix.chrismas.service;

import seasonSix.chrismas.model.CustomerPlan;
import seasonSix.chrismas.model.Order;
import seasonSix.chrismas.model.event.EventManager;
import seasonSix.chrismas.repository.EventRepository;
import seasonSix.chrismas.model.Payment;

public class PlannerService {

    private final EventRepository eventRepository;
    private final PricingSystemService pricingSystemService;
    private final CustomerPlanService customerPlanService;

    public PlannerService(EventRepository eventRepository,
                          PricingSystemService pricingSystemService,
                          CustomerPlanService customerPlanService) {
        this.eventRepository = eventRepository;
        this.pricingSystemService = pricingSystemService;
        this.customerPlanService = customerPlanService;
    }

    public CustomerPlan getCustomersTodayPlan(EventManager eventManager, Order order) {
        Payment eventPrices = pricingSystemService.managingPrice(eventManager, order);
        return customerPlanService.generate(eventManager, order, eventPrices);
    }
}
