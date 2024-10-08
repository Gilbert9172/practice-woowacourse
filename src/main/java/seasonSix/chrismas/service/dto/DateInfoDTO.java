package seasonSix.chrismas.service.dto;

public class DateInfoDTO {
    int date;
    boolean isWeekend;
    boolean isSpecialDay;
    boolean isOnChristmasSeason;

    public static DateInfoDTO newOne(int date, boolean isWeekend, boolean isSpecialDay, boolean isOnChristmasSeason) {
        return new DateInfoDTO(date, isWeekend, isSpecialDay, isOnChristmasSeason);
    }

    private DateInfoDTO(int date, boolean isWeekend, boolean isSpecialDay, boolean isOnChristmasSeason) {
        this.date = date;
        this.isWeekend = isWeekend;
        this.isSpecialDay = isSpecialDay;
        this.isOnChristmasSeason = isOnChristmasSeason;
    }

    public int getDate() {
        return date;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public boolean isSpecialDay() {
        return isSpecialDay;
    }

    public boolean isOnChristmasSeason() {
        return isOnChristmasSeason;
    }
}
