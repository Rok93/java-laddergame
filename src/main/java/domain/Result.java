package domain;

public class Result {
    private final String resultValue;

    public Result(String resultValue) {
        validateResult(resultValue);
        this.resultValue = resultValue;
    }

    private void validateResult(String resultValue) {
        if (resultValue.isEmpty()) {
            throw new IllegalArgumentException("결괏값은 최소 1자이상 입력해야 합니다. ");
        }
    }

    public String getValue() {
        return resultValue;
    }
}
