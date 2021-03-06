package dto;

import java.util.ArrayList;
import java.util.List;

public class ResultsResponse {
    private final List<ResultRequest> results;

    public ResultsResponse(List<ResultRequest> resultsValues) {
        this.results = new ArrayList<>(resultsValues);
    }

    public List<ResultRequest> getValues() {
        return new ArrayList<>(results);
    }

    public String getValue(int position) {
        return results.get(position).getValue();
    }
}
