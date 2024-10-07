package seasonSix.chrismas.infra.controller;

import seasonSix.chrismas.repository.EventRepository;

public class Controller {

    private final EventRepository eventRepository;

    public Controller(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void choosePlanner() {
    }
}
