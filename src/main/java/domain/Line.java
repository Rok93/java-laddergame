package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final int FIRST_POSITION = 0;

    private final Points points;

    protected Line(List<Boolean> points) {
        this.points = new Points(points.stream()
                .map(Point::new)
                .collect(Collectors.toList()));
    }

    public Line(Points points) {
        this.points = new Points(points.getValues());
    }

    public Points getPoints() {
        return new Points(points.getValues());
    }

    public int getNextPosition(int currentPosition) {
        List<Point> lineValues = points.getValues();
        if (currentPosition == FIRST_POSITION) {
            return lineValues.get(currentPosition).isConnected() ? currentPosition + 1 : currentPosition;
        }

        int lastPosition = points.getSize();
        if (currentPosition == lastPosition) {
            return lineValues.get(currentPosition - 1).isConnected() ? currentPosition - 1 : currentPosition;
        }

        if (lineValues.get(currentPosition - 1).isConnected()) {
            return currentPosition - 1;
        }

        if (lineValues.get(currentPosition).isConnected()) {
            return currentPosition + 1;
        }

        return currentPosition;
    }
}
