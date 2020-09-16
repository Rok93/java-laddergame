package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultLineGenerator implements LineGenerator {

    @Override
    public Line generateLine(int personNumber) {
        int pointsNumber = personNumber - 1;
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
