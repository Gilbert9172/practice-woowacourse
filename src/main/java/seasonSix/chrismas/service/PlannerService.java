package seasonSix.chrismas.service;

import seasonSix.chrismas.common.Money;
import seasonSix.chrismas.model.Planner;
import seasonSix.chrismas.model.event.Event;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.repository.EventRepository;
import seasonSix.chrismas.service.dto.DateInfoDTO;
import seasonSix.chrismas.utils.DateUtil;

import java.util.List;
import java.util.Map;

public class PlannerService {

    private final EventRepository eventRepository;


    public PlannerService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void servePlanner(int date, Map<Food, Integer> orderSheet, List<Event> events) {
        Planner planner = generateForToday(date);
        // order instance
        // customer instance
        // resultView
    }

    private Planner generateForToday(int date) {
        boolean isWeekend = DateUtil.isWeekend(date);
        boolean isSpecialDay = DateUtil.isSpecialDay(date);
        boolean isOnChristmasSeason = DateUtil.isOnChristmasSeason(date);
        DateInfoDTO dateInfo = DateInfoDTO.newOne(date, isWeekend, isSpecialDay, isOnChristmasSeason);
        List<Event> todayEvents = eventRepository.findTodayEvents(dateInfo);
        return Planner.newOne(date, isWeekend, isSpecialDay, todayEvents);
    }
}
