package view;

import domain.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String WHOSE_RESULT_WANT_SEE = "결과를 보고 싶은 사람은?";
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String COMMA = ",";
    private static final String INPUT_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구하세요 ";
    private static final String WANT_TO_SEE_MORE_RESULT_MESSAGE = "결과를 더 보시겠습니까? (y/n)";
    private static final String YES = "y";
    private static final String NO = "n";
    private static final boolean STOP = true;
    private static final boolean CONTINUE = false;

    private static Scanner input = new Scanner(System.in);

    public static Names inputPersonNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        try {
            return new Names(Arrays.stream(input.nextLine().split(COMMA))
                    .map(String::trim)
                    .map(Name::new)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            return inputPersonNames();
        }
    }

    public static Height inputHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        try {
            return new Height(input.nextInt());
        } catch (IllegalArgumentException e) {
            return inputHeight();
        }
    }

    public static Results inputResults() {
        System.out.println(INPUT_RESULTS_MESSAGE);
        try {
            return new Results(Arrays.stream(input.nextLine().split(COMMA))
                    .map(String::trim)
                    .map(Result::new)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            return inputResults();
        }
    }

    public static boolean inputStartOrExit() {
        System.out.println(WANT_TO_SEE_MORE_RESULT_MESSAGE);
        String result = input.nextLine();

        if (result.equals(YES)) {
            return CONTINUE;
        }

        if (result.equals(NO)) {
            return STOP;
        }

        return inputStartOrExit();
    }

    public static Name inputPersonName() {
        System.out.println(WHOSE_RESULT_WANT_SEE);
        try {
            return new Name(input.nextLine());
        } catch (IllegalArgumentException e) {
            return inputPersonName();
        }
    }
}
