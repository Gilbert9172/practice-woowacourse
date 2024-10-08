package seasonSix.chrismas.infra.controller;

import seasonSix.chrismas.infra.view.PlannerView;
import seasonSix.chrismas.model.CustomerPlan;
import seasonSix.chrismas.model.event.EventManager;
import seasonSix.chrismas.model.planner.Planner;
import seasonSix.chrismas.repository.EventRepository;
import seasonSix.chrismas.infra.DataFactory;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.repository.FoodRepository;
import seasonSix.chrismas.service.PlannerService;

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
        DataFactory dataFactory = new DataFactory(foodRepository, eventRepository);
        int date = dataFactory.generateDate();
        Map<Food, Integer> orderSheet = dataFactory.generateOderSheet();

        // Main Logic
        Planner planner = plannerService.generateForToday(date);
        EventManager eventManager = planner.getEventManager();
        CustomerPlan customersPlan = plannerService.getCustomersTodayPlan(eventManager, orderSheet);

        // planner customsPlan 을 조합해서 View를 만든다.
        PlannerView plannerView = PlannerView.from(planner, customersPlan);
        plannerView.hashCode();
        System.out.println("finish");
    }
}
