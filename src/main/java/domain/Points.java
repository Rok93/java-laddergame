package domain;

import java.util.ArrayList;
import java.util.List;

public class Points {
    public static final String POINT_NOT_CONTINUITY_CONNECTED_MESSAGE = "Point는 연속해서 연결될 수 없습니다.";
    private static final String LESS_THEN_MIN_PERSON_NUMBER_MESSAGE = "최소 2명의 참가자가 필요합니다.";
    private static final int MIN_POINT_NUMBER = 1;

    private final List<Point> points;

    public Points(List<Point> points) {
        validatePoints(points);
        this.points = new ArrayList<>(points);
    }

    private void validatePoints(List<Point> points) {
        validatePointsSize(points);
        validatePointsConnectionStatus(points);
    }

    private void validatePointsSize(List<Point> points) {
        if (points.size() < MIN_POINT_NUMBER) {
            throw new IllegalArgumentException(LESS_THEN_MIN_PERSON_NUMBER_MESSAGE);
        }
    }

    private void validatePointsConnectionStatus(List<Point> points) {
        Point beforePoints = new Point(false);
        for (Point currentPoint : points) {
            validateFrontAndRearPoints(beforePoints, currentPoint);

            beforePoints = currentPoint;
        }
    }

    private void validateFrontAndRearPoints(Point beforePoints, Point currentPoint) {
        if (beforePoints.isConnected() && currentPoint.isConnected()) {
            throw new IllegalArgumentException(POINT_NOT_CONTINUITY_CONNECTED_MESSAGE);
        }
    }

    public int getSize() {
        return points.size();
    }

    public List<Point> getValues() {
        return new ArrayList<>(points);
    }
}
