package domain;

@FunctionalInterface
public interface LineGenerator {
    Line generateLine(int names);
}
