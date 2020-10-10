package domain;

public class Line {
    private final Points points;

//    protected Line(List<Boolean> points) {
//        this.points = new Points(points.stream()
//                .map(Point::new)
//                .collect(Collectors.toList()));
//    }

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
