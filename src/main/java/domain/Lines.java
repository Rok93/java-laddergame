package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private static final int FIRST_INDEX = 0;

    private final List<Line> lines;
    private final int personNumber;

    public Lines(LineGenerator lineGenerator, Names names, Height height) {
        this.personNumber = names.calculatePersonNumber();

        lines = new ArrayList<>();
        int heightValue = height.getValue();
        for (int i = 0; i < heightValue; i++) {
            lines.add(lineGenerator.generateLine(personNumber));
        }
    }

    public List<Integer> traceResults() {
        return IntStream.range(FIRST_INDEX, personNumber)
                .mapToObj(Integer::new)
                .map(this::traceLines)
                .collect(Collectors.toList());
    }

    private int traceLines(int position) {
        for (Line line : lines) {
            position = line.getNextPosition(position);
        }

        return position;
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
