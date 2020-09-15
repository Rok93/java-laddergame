package domain;

import java.util.*;

public class ResultsResponse {
    private static final String NOT_FOUND_NAME_MESSAGE = "없는 참가자입니다. ";

    private final Map<Name, ResultRequest> results;

    public ResultsResponse(Map<Name, ResultRequest> resultsValues) {
        this.results = resultsValues;
    }

    public List<ResultRequest> getValues() {
        return new ArrayList<>(results.values());
    }

    public Set<Name> getKeys() {
        return new HashSet<>(results.keySet());
    }

    public String getResultBy(Name name) {
        return results.get(name).getValue();
    }

    public String findResult(Name name) {
        return results.getOrDefault(name, new ResultRequest(NOT_FOUND_NAME_MESSAGE)).getValue();
    }
}
