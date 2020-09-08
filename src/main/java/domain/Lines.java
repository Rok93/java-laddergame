package domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(LineGenerator lineGenerator, Height height) {
        lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(lineGenerator.generateLine());
        }
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    public int traceLines(int point) {
        System.out.println("traceLines에 들어온 값:" + point);
        for (Line line : lines) {
            point = line.getNextPosition(point);
        }

        return point;
    }
}
