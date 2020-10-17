package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLines {
    private static final int FIRST_INDEX = 0;

    private final List<LadderLine> lines;
    private final int personNumber;

    public LadderLines(LadderLineGenerator ladderLineGenerator, Names names, Height height) {
        this.personNumber = names.calculatePersonNumber();

        lines = new ArrayList<>();
        int heightValue = height.getValue();
        for (int i = 0; i < heightValue; i++) {
            lines.add(new LadderLine(ladderLineGenerator.generateLine(personNumber)));
        }
    }

    public List<Integer> traceResults() {
        return IntStream.range(FIRST_INDEX, personNumber)
                .mapToObj(Integer::new)
                .map(this::traceLines)
                .collect(Collectors.toList());
    }

    private int traceLines(int position) {
        for (LadderLine ladderLine : lines) {
            position = ladderLine.movePoint(position);
        }

        return position;
    }

    public List<LadderLine> getLines() {
        return new ArrayList<>(lines);
    }

    public int getPersonNumber() {
        return personNumber;
    }
}
