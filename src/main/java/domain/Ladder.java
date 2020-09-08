package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private static final String NAMES_NUMBER_IS_NOT_EQUAL_RESULTS_NUMBER_MESSAGE = "사람 수와 결과 갯수는 같아야 합니다.";

    private final Names names;
    private final Lines lines;
    private final Results results;

    public Ladder(Names names, Lines lines, Results results) {
        validateLadder(names, results);
        this.names = names;
        this.lines = lines;
        this.results = results;
    }

    private void validateLadder(Names names, Results results) {
        if (names.calculatePersonNumber() != results.getSize()) {
            throw new IllegalArgumentException(NAMES_NUMBER_IS_NOT_EQUAL_RESULTS_NUMBER_MESSAGE);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines.getLines());
    }

    public Names getNames() {
        return new Names(names.getValues());
    }

    public Map<Name, Result> play() {
        Map<Name, Result> results = new HashMap<>();
        int personNumber = names.calculatePersonNumber();
        for (int startPoint = 0; startPoint < personNumber; startPoint++) {
            results.put(names.getValues().get(startPoint), traceLadder(startPoint)); // todo: traceLadder는 Lines의 기능으로 !
        }

        return results;
    }

    public Result traceLadder(int currentPoint) {
        List<Line> lines = this.lines.getLines();
        for (Line line : lines) {
            currentPoint = line.getNextPosition(currentPoint);
        }

        return results.getValues().get(currentPoint);
    }
}
