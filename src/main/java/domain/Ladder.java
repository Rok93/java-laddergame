package domain;

import dto.ResultRequest;
import dto.ResultsRequest;
import dto.ResultsResponse;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final String RESULTS_NUMBER_IS_NOT_MATCH_LINE_LENGTH_MESSAGE = "결과의 수와 Line의 길이가 매칭되지 않습니다. ";

    private final Lines lines;
    private final ResultsRequest resultsRequest;

    public Ladder(Lines lines, ResultsRequest resultsRequest) {
        validateLadder(lines, resultsRequest);
        this.lines = lines;
        this.resultsRequest = resultsRequest;
    }

    private void validateLadder(Lines lines, ResultsRequest resultsRequest) {
        if (lines.getPersonNumber() != resultsRequest.getSize()) {
            throw new IllegalArgumentException(RESULTS_NUMBER_IS_NOT_MATCH_LINE_LENGTH_MESSAGE);
        }
    }

    public ResultsResponse play() {
        List<ResultRequest> answers = lines.traceResults().stream()
                .map(position -> resultsRequest.getValue(position))
                .collect(Collectors.toList());

        return new ResultsResponse(answers);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines.getLines());
    }
}
