package seasonSix.chrismas.infra.controller;

import seasonSix.chrismas.infra.DataFactory;
import seasonSix.chrismas.infra.view.CustomerPlanView;
import seasonSix.chrismas.model.CustomerPlan;
import seasonSix.chrismas.model.Order;
import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.event.EventManager;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.exception.NotAvailableFoodException;
import seasonSix.chrismas.model.planner.Planner;
import seasonSix.chrismas.repository.EventRepository;
import seasonSix.chrismas.repository.FoodRepository;
import seasonSix.chrismas.service.PlannerService;
import seasonSix.chrismas.utils.OutputUtil;

import java.util.List;
import java.util.Map;

public class Controller {

    private final PlannerService plannerService;
    private final FoodRepository foodRepository;
    private final EventRepository eventRepository;

    public Controller(PlannerService plannerService, FoodRepository foodRepository, EventRepository eventRepository) {
        this.plannerService = plannerService;
        this.foodRepository = foodRepository;
        this.eventRepository = eventRepository;
    }

    public void choosePlanner() {
        // Initialize
        DataFactory dataFactory = new DataFactory();
        int date = dataFactory.generateDate();
        List<Food> foods = foodRepository.initializeFoods();
        Map<Food, Integer> purchase = dataFactory.generateOderSheet(foods);

        // Generate models
        Order order = Order.newOne(purchase, date);
        List<Event> todayEvents = eventRepository.findTodayEvents(date, order);
        Food prizeFood = foodRepository.findPrizeFood().orElseThrow(NotAvailableFoodException::new);
        EventManager eventManager = EventManager.newOne(todayEvents, prizeFood);

        // Main Logic
        CustomerPlan customersPlan = plannerService.getCustomersTodayPlan(eventManager, order);

        // Generate View
        CustomerPlanView customerPlanView = CustomerPlanView.from(customersPlan);

        // Output
        OutputUtil.printResult(customerPlanView);
    }
}
