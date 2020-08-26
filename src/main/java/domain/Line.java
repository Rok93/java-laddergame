package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String LESS_THEN_MIN_PERSON_NUMBER_MESSAGE = "최소 2명의 참가자가 필요합니다.";
    private static final int MIN_POINT_NUMBER = 1;

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validatePersonNumber(points);
        this.points = new ArrayList<>(points);
    }

    private void validatePersonNumber(List<Boolean> points) {
        if (points.size() < MIN_POINT_NUMBER) {
            throw new IllegalArgumentException(LESS_THEN_MIN_PERSON_NUMBER_MESSAGE);
        }
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }
}
