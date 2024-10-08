package seasonSix.chrismas.service;

import seasonSix.chrismas.model.CustomerPlan;
import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.event.EventManager;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.planner.Planner;
import seasonSix.chrismas.repository.EventRepository;
import seasonSix.chrismas.service.dto.DateInfoDTO;
import seasonSix.chrismas.service.dto.Payment;
import seasonSix.chrismas.utils.DateUtil;

import java.util.List;
import java.util.Map;

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

    public Planner generateForToday(int date) {
        boolean isWeekend = DateUtil.isWeekend(date);
        boolean isSpecialDay = DateUtil.isSpecialDay(date);
        boolean isOnChristmasSeason = DateUtil.isOnChristmasSeason(date);
        DateInfoDTO dateInfo = DateInfoDTO.newOne(date, isWeekend, isSpecialDay, isOnChristmasSeason);
        List<Event> todayEvents = eventRepository.findTodayEvents(dateInfo);
        return Planner.newOne(date, isWeekend, isSpecialDay, todayEvents);
    }

    public CustomerPlan getCustomersTodayPlan(EventManager eventManager, Map<Food, Integer> purchase) {
        Payment payment = pricingSystemService.managingPrice(eventManager, purchase);
        return customerPlanService.generate(purchase, payment);
    }
}
