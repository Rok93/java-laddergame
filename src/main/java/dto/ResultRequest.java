package dto;

public class ResultRequest {
    private static final String LESS_THAN_MIN_LETTER_NUMBER_MESSAGE = "결괏값은 최소 1자이상 입력해야 합니다. ";

    private final String resultValue;

    public ResultRequest(String resultValue) {
        validateResult(resultValue);
        this.resultValue = resultValue;
    }

    private void validateResult(String resultValue) {
        if (resultValue.isEmpty()) {
            throw new IllegalArgumentException(LESS_THAN_MIN_LETTER_NUMBER_MESSAGE);
        }
    }

    public String getValue() {
        return resultValue;
    }
}
