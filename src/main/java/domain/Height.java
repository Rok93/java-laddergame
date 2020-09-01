package domain;

public class Height {
    private static final int MIN_HEIGHT_LIMIT = 1;
    private static final String LESS_THAN_MIN_LIMIT_HEIGHT_MESSAGE = "최소 1이상의 높이를 입력하세요! ";

    private final int value;

    public Height(int heightValue) {
        validateHeight(heightValue);
        this.value = heightValue;
    }

    private void validateHeight(int heightValue) {
        if (heightValue < MIN_HEIGHT_LIMIT) {
            throw new IllegalArgumentException(LESS_THAN_MIN_LIMIT_HEIGHT_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}
