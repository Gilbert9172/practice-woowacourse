package seasonSix.chrismas.model.event;

public enum EventType {
    SINGLE,
    TOTAL,
    PRIZE,
    CHRISTMAS
    ;
    public static boolean isSingleType(EventType type) {
        return type == SINGLE;
    }

    public static boolean isPrizeType(EventType type) {
        return type == PRIZE;
    }
}
