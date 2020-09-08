package domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final String NAMES_NUMBER_IS_NOT_EQUAL_RESULTS_NUMBER_MESSAGE = "사람 수와 결과 갯수는 같아야 합니다.";
    private static final int FIRST_PERSON_POSITION = 0;

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

    public Map<Name, Result> play() {
        int personNumber = names.calculatePersonNumber();
        return IntStream.range(FIRST_PERSON_POSITION, personNumber)
                .mapToObj(Integer::new)
                .collect(Collectors.toMap(
                        position -> names.getValues().get(position),
                        position -> lines.traceLines(position))
                ).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> results.getValues().get(entry.getValue())));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines.getLines());
    }

    public Names getNames() {
        return new Names(names.getValues());
    }
}
