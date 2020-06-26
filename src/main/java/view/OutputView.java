package view;

import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Names;

import java.util.List;

public class OutputView {

    public static final String RESULT_MESSAGE = "실행결과";
    public static final String PERSON_POINT_SYMBOL = "|";
    public static final String LADDER_LINK_SYMBOL = "-----";
    public static final String LADDER_UNLINK_SYMBOL = "     ";

    public static void printResult(Ladder ladder, Names names) {
        System.out.println(RESULT_MESSAGE);
        printNames(names);
        printLadder(ladder);
    }

    public static void printNames(Names names) {
        names.getValues().stream()
                .map(Name::getValue)
                .forEach(name -> System.out.print(name + "  "));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        List<Boolean> points = line.getPoints();
        StringBuilder result = new StringBuilder();
        for (boolean b : points) {
            addLineResult(result, b);
        }
        result.append(PERSON_POINT_SYMBOL);
        System.out.println(result.toString());
    }

    private static void addLineResult(StringBuilder result, boolean b) {
        result.append(PERSON_POINT_SYMBOL);
        if (b) {
            result.append(LADDER_LINK_SYMBOL);
            return;
        }
        result.append(LADDER_UNLINK_SYMBOL);
        return;
    }
}
