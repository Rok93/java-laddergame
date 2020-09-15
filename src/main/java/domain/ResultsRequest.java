package domain;

import java.util.ArrayList;
import java.util.List;

public class ResultsRequest {
    private static final int RESULTS_MIN_NUMBER = 2;
    private static final String RESULTS_NUMBER_LESS_THAN_MIN_NUMBER_MESSAGE = "결과는 최소 2개이상은 작성되어야 합니다. ";

    private final List<ResultRequest> resultRequests;

    public ResultsRequest(List<ResultRequest> resultRequests) {
        validateResults(resultRequests);
        this.resultRequests = new ArrayList<>(resultRequests);
    }

    private void validateResults(List<ResultRequest> resultRequests) {
        if (resultRequests.size() < RESULTS_MIN_NUMBER) {
            throw new IllegalArgumentException(RESULTS_NUMBER_LESS_THAN_MIN_NUMBER_MESSAGE);
        }
    }

    public ResultRequest getValue(int position) {
        return resultRequests.get(position);
    }

    public List<ResultRequest> getValues() {
        return resultRequests;
    }

    public int getSize() {
        return resultRequests.size();
    }
}
