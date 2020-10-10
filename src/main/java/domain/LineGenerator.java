package domain;

@FunctionalInterface
public interface LineGenerator {
    Points generateLine(int names);
}
