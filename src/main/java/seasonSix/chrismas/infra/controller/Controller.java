package seasonSix.chrismas.infra.controller;

import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.repository.EventRepository;
import seasonSix.chrismas.utils.DataFactory;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.repository.FoodRepository;
import seasonSix.chrismas.service.PlannerService;

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
        DataFactory dataFactory = new DataFactory(foodRepository, eventRepository);
        int date = dataFactory.generateDate();
        Map<Food, Integer> orderSheet = dataFactory.generateOderSheet();
        List<Event> events = dataFactory.generateEvents(date);
        plannerService.servePlanner(date, orderSheet, events);
    }
}
