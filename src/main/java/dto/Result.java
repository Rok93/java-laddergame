package dto;

public class Result {
    private final String resultValue;

    public Result(String resultValue) {
        this.resultValue = resultValue;
    }

    public String getValue() {
        return resultValue;
    }
}
