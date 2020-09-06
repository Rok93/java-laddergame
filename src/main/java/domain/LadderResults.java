package domain;

import java.util.*;

public class LadderResults {
    private final Map<Name, Result> results;

    public LadderResults(Map<Name, Result> resultsValues) {
        this.results = resultsValues;
    }

    public List<Result> getValues() {
        return new ArrayList<>(results.values());
    }

    public Set<Name> getKeys() {
        return new HashSet<>(results.keySet());
    }

    public String getResultBy(Name name) {
        return results.get(name).getValue();
    }
}
