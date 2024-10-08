package seasonSix.chrismas.common;

public enum MagicNums {

    YEAR(2023),
    MONTH(12),
    CHRISTMAS(25);
    ;

    final int val;

    MagicNums(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public static boolean isChristmas(int date) {
        return date == CHRISTMAS.val;
    }

    public static boolean isAfterChristmas(int date) {
        return date > CHRISTMAS.val;
    }
}
