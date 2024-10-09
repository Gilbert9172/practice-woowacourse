package seasonSix.chrismas;

import seasonSix.chrismas.infra.controller.Controller;
import seasonSix.chrismas.repository.EventRepository;
import seasonSix.chrismas.repository.FoodRepository;
import seasonSix.chrismas.service.CustomerPlanService;
import seasonSix.chrismas.service.PlannerService;
import seasonSix.chrismas.service.PricingSystemService;

public class Application {
    public static void main(String[] args) {
        Controller controller = setupController();
        controller.choosePlanner();
    }

    private static Controller setupController() {
        EventRepository eventRepository = new EventRepository();
        FoodRepository foodRepository = new FoodRepository();
        PricingSystemService pricingSystemService = new PricingSystemService();
        CustomerPlanService customerPlanService = new CustomerPlanService();
        PlannerService plannerService = new PlannerService(eventRepository, pricingSystemService, customerPlanService);
        return new Controller(plannerService, foodRepository, eventRepository);
    }
}
