import domain.*;
import dto.Result;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGameMain {
    public static void main(String[] args) {
        Names names = InputView.inputPersonNames();
        List<Result> resultsRequest = InputView.inputResults();
        Height height = InputView.inputHeight();
        Lines lines = new Lines(new DefaultLineGenerator(), names, height);
        Ladder ladder = new Ladder(lines, resultsRequest);
        OutputView.printLadder(names, ladder, resultsRequest);

        List<Result> resultsResponse = ladder.play();

        while (true) {
            OutputView.printResult(names, InputView.inputPersonName(), resultsResponse);

            if (InputView.inputStartOrExit()) {
                break;
            }
        }
        OutputView.printEnd();
    }
}
