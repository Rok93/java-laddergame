package view;

import domain.*;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String PERSON_POINT_SYMBOL = "|";
    private static final String LADDER_LINK_SYMBOL = "-----";
    private static final String LADDER_UNLINK_SYMBOL = "     ";
    private static final String BLANK = "   ";
    private static final String ALL = "all";
    private static final String END_LADDER_GAME_MESSAGE = "사다리 게임을 종료합니다.";
    private static final String NOT_FOUND_NAME_MESSAGE = "없는 참가자입니다. ";

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
        List<Point> points = line.getPoints()
                .getValues();

        StringBuilder lineResult = new StringBuilder();
        lineResult.append(BLANK);
        for (Point point : points) {
            addLineResult(lineResult, point);
        }
        lineResult.append(PERSON_POINT_SYMBOL);
        System.out.println(lineResult.toString());
    }

    private static void addLineResult(StringBuilder lineResult, Point point) {
        lineResult.append(PERSON_POINT_SYMBOL);
        lineResult.append(point.isConnected() ? LADDER_LINK_SYMBOL : LADDER_UNLINK_SYMBOL);
    }

    public static void printResult(Name name, Map<Name, Result> ladderResults) {
        System.out.println(RESULT_MESSAGE);
        if (name.isEqualTo(ALL)) {
            printAllResults(ladderResults);
            return;
        }

        Result result = ladderResults.getOrDefault(name, new Result(NOT_FOUND_NAME_MESSAGE));
        System.out.println(result.getValue());
    }

    private static void printAllResults(Map<Name, Result> ladderResults) {
        for (Name name : ladderResults.keySet()) {
            System.out.println(name.getValue() + " : " + ladderResults.get(name).getValue());
        }
        System.out.println();
    }

    public static void printEnd() {
        System.out.println(END_LADDER_GAME_MESSAGE);
    }
}
