package domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(LineGenerator lineGenerator, Height height) {
        lines = new ArrayList<>();
        int heightValue = height.getValue();
        for (int i = 0; i < heightValue; i++) {
            lines.add(lineGenerator.generateLine());
        }
    }

    public int traceLines(int position) {
        for (Line line : lines) {
            position = line.getNextPosition(position);
        }

        return position;
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
