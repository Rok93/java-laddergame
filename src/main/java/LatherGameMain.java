import domain.*;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class LatherGameMain {
    public static void main(String[] args) {
        Names names = InputView.inputPersonNames();
        Results results = InputView.inputResults();
        Height height = InputView.inputHeight();
        Lines lines = new Lines(new DefaultLineGenerator(names), height);
        Ladder ladder = new Ladder(names, lines, results);
        OutputView.printLadder(ladder, names, results);
        Map<Name, Result> ladderResults = ladder.play();

        while (true) {
            Name name = InputView.inputPersonName();
            OutputView.printResult(name, ladderResults);

            if (InputView.inputStartOrExit()) {
                break;
            }
        }

        OutputView.printEnd();
    }
}
