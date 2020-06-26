package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    public static final String LESS_THEN_MIN_PERSON_NUMBER_MESSAGE = "최소 2명의 참가자가 필요합니다.";
    public static final int MIN_PERSON_NUMBER = 2;
    public static final int ZERO = 0;

    private final List<Boolean> points = new ArrayList<>();
    private final Random random = new Random();

    public Line(int countOfPerson) {
        validatePersonNumber(countOfPerson);
        generatePoints(countOfPerson);
    }

    private void generatePoints(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            addPoint(i);
        }
    }

    private void addPoint(int i) {
        if (isFirstIndex(i) || isBeforeValueThatFalse(i)) {
            points.add(random.nextBoolean());
            return;
        }
        points.add(false);
    }

    private boolean isBeforeValueThatFalse(int i) {
        return !points.get(i - 1);
    }

    private boolean isFirstIndex(int i) {
        return i == ZERO;
    }

    private void validatePersonNumber(int countOfPerson) {
        if (countOfPerson < MIN_PERSON_NUMBER) {
            throw new IllegalArgumentException(LESS_THEN_MIN_PERSON_NUMBER_MESSAGE);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
