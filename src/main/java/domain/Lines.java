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
}
