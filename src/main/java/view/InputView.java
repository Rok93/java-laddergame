package view;

import domain.Height;
import domain.Name;
import domain.Names;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ";
    public static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String COMMA = ",";

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
}
