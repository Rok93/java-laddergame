package domain;

import dto.Result;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final String RESULTS_NUMBER_IS_NOT_MATCH_LINE_LENGTH_MESSAGE = "결과의 수와 Line의 길이가 매칭되지 않습니다. ";

    private final Lines lines;
    private final List<Result> resultsRequest;

    public Ladder(Lines lines, List<Result> resultsRequest) {
        validateLadder(lines, resultsRequest);
        this.lines = lines;
        this.resultsRequest = resultsRequest;
    }

    private void validateLadder(Lines lines, List<Result> resultsRequest) {
        if (lines.getPersonNumber() != resultsRequest.size()) {
            throw new IllegalArgumentException(RESULTS_NUMBER_IS_NOT_MATCH_LINE_LENGTH_MESSAGE);
        }
    }

    public List<Result> play() {
        return lines.traceResults().stream()
                .map(position -> resultsRequest.get(position))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines.getLines());
    }
}
