package domain;

public class Line {
    private final Points points;

    public Line(Points points) {
        this.points = new Points(points.getValues());
    }

    public Points getPoints() {
        return new Points(points.getValues());
    }

    public int getNextPosition(int currentPosition) {
        return points.followPoint(currentPosition);
    }
}
