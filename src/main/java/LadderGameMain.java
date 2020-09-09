import domain.*;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class LadderGameMain {
    public static void main(String[] args) {
        Names names = InputView.inputPersonNames();
        Results results = InputView.inputResults();
        Height height = InputView.inputHeight();
        Lines lines = new Lines(new DefaultLineGenerator(names), height);
        Ladder ladder = new Ladder(names, lines, results);
        OutputView.printLadder(ladder);

        LadderResults ladderResults = ladder.play();

        while (true) {
            OutputView.printResult(InputView.inputPersonName(), ladderResults);

            if (InputView.inputStartOrExit()) {
                break;
            }
        }
        OutputView.printEnd();
    }
}
