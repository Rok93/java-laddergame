package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final Points points;

    public LadderLine(Points points) {
        this.points = points;
    }

    public List<Point> getValues() {
        return new ArrayList<>(points.getValues());
    }

    public int movePoint(int currentPosition) {
        return points.followPoint(currentPosition);
    }
}
