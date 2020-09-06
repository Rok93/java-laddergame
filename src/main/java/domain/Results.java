package domain;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private static final int RESULTS_MIN_NUMBER = 2;
    private static final String RESULTS_NUMBER_LESS_THAN_MIN_NUMBER_MESSAGE = "결과는 최소 2개이상은 작성되어야 합니다. ";

    private final List<Result> results;

    public Results(List<Result> results) {
        validateResults(results);
        this.results = new ArrayList<>(results);
    }

    private void validateResults(List<Result> results) {
        if (results.size() < RESULTS_MIN_NUMBER) {
            throw new IllegalArgumentException(RESULTS_NUMBER_LESS_THAN_MIN_NUMBER_MESSAGE);
        }
    }

    public List<Result> getValues() {
        return results;
    }
}
