package domain;

@FunctionalInterface
public interface LadderLineGenerator {
    Points generateLine(int names);
}
