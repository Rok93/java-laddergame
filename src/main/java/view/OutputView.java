package view;

import domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String PERSON_POINT_SYMBOL = "|";
    private static final String LADDER_LINK_SYMBOL = "-----";
    private static final String LADDER_UNLINK_SYMBOL = "     ";
    private static final String BLANK = "   ";
    private static final String ALL = "all";
    private static final String END_LADDER_GAME_MESSAGE = "사다리 게임을 종료합니다.";
    public static final String COLON = " : ";

    public static void printLadder(Ladder ladder) {
        System.out.println(LADDER_RESULT_MESSAGE);
        printNames(ladder.getNames());
        printLines(ladder.getLines());
        printResults(ladder.getResults());
        System.out.println();
    }

    private static void printResults(Results results) {
        results.getValues().stream()
                .map(Result::getValue)
                .forEach(result -> System.out.print(result + BLANK));
        System.out.println();
    }

    public static void printNames(Names names) {
        names.getValues().stream()
                .map(Name::getValue)
                .forEach(name -> System.out.print(name + BLANK));
        System.out.println();
    }

    public static void printLines(List<Line> lines) {
        for (Line line : lines) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        List<Boolean> points = line.getPoints().getValues().stream() // todo: 임시로...
                .map(Point::isConnected)
                .collect(Collectors.toList());
        StringBuilder lineResult = new StringBuilder();
        lineResult.append(BLANK);
        for (boolean point : points) {
            addLineResult(lineResult, point);
        }
        lineResult.append(PERSON_POINT_SYMBOL);
        System.out.println(lineResult.toString());
    }

    private static void addLineResult(StringBuilder lineResult, boolean point) {
        lineResult.append(PERSON_POINT_SYMBOL);
        if (point) {
            lineResult.append(LADDER_LINK_SYMBOL);
            return;
        }
        lineResult.append(LADDER_UNLINK_SYMBOL);
        return;
    }

    public static void printResult(Name name, Map<Name, Result> ladderResults) {
        System.out.println(RESULT_MESSAGE);
        if (name.getValue().equals(ALL)) {
            printAllResults(ladderResults);
            return;
        }

        Result result = ladderResults.getOrDefault(name, new Result("사용자를 찾을 수 없음"));
        System.out.println(result.getValue());
    }

    private static void printAllResults(Map<Name, Result> ladderResults) {
        for (Name name : ladderResults.keySet()) {
            System.out.println(name.getValue() + COLON + ladderResults.get(name).getValue());
        }
        System.out.println();
    }

    public static void printEnd() {
        System.out.println(END_LADDER_GAME_MESSAGE);
    }
}
