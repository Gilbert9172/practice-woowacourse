package seasonSix.lotto.common;

public enum CommonConstant {
    COMMA(",")
    ;
    private final String spliter;

    CommonConstant(String spliter) {
        this.spliter = spliter;
    }

    public String getSpliter() {
        return spliter;
    }
}
