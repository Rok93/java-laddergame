package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(LineGenerator lineGenerator, Height height) {
        lines = new ArrayList<>();
        int heightValue = height.getValue();
        for (int i = 0; i < heightValue; i++) {
            lines.add(lineGenerator.generateLine());
        }
    }

    public List<Integer> traceResults() {
        return IntStream.range(0,2) //todo: 2는 임시로 할당 사람 수를 저기서 받자!
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
