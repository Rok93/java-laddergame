package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(Height height, int countOfPerson) {
        int heightValue = height.getValue();
        for (int i = 0; i < heightValue; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
