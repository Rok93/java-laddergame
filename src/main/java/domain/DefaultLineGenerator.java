package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultLineGenerator implements LineGenerator {
    private final int pointsNumber;

    public DefaultLineGenerator(int personNumber) {
        this.pointsNumber = personNumber - 1;
    }

    @Override
    public Line generateLine() {
        boolean beforeValue = false;
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < pointsNumber; i++) {
            boolean nextValue = generateNextValue(beforeValue);
            points.add(nextValue);
            beforeValue = nextValue;
        }

        return new Line(points);
    }

    private boolean generateNextValue(boolean beforeValue) {
        Random random = new Random();
        if (beforeValue) {
            return false;
        }

        return random.nextBoolean();
    }
}
