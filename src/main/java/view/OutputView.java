package view;

import domain.*;
import dto.Result;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String PERSON_POINT_SYMBOL = "|";
    private static final String LADDER_LINK_SYMBOL = "-----";
    private static final String LADDER_UNLINK_SYMBOL = "     ";
    private static final String BLANK = "   ";
    private static final String ALL = "all";
    private static final String END_LADDER_GAME_MESSAGE = "사다리 게임을 종료합니다.";

    public static void printLadder(Names names, Ladder ladder, List<Result> resultsRequest) {
        System.out.println(LADDER_RESULT_MESSAGE);
        printNames(names);
        printLines(ladder.getLines());
        printResults(resultsRequest);
        System.out.println();
    }

    private static void printResults(List<Result> resultsRequest) {
        resultsRequest.stream()
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

    public static void printResult(Names names, Name findName, List<Result> resultsResponse) {
        System.out.println(RESULT_MESSAGE);
        if (findName.isEqualTo(ALL)) {
            printAllResults(names, resultsResponse);
            return;
        }

        System.out.println(resultsResponse.get(names.findPositionNumber(findName)).getValue());
    }

    private static void printAllResults(Names names, List<Result> resultsResponse) {
        int size = names.getValues().size();
        IntStream.range(0, size)
                .forEach(position -> System.out.println(
                        names.getValue(position)
                                + " : "
                                + resultsResponse.get(position).getValue())
                );
    }

    public static void printEnd() {
        System.out.println(END_LADDER_GAME_MESSAGE);
    }
}
