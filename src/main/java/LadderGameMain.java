import domain.*;
import view.InputView;
import view.OutputView;

public class LadderGameMain {
    public static void main(String[] args) {
        Names names = InputView.inputPersonNames();
        ResultsRequest resultsRequest = InputView.inputResults();
        Height height = InputView.inputHeight();
        Lines lines = new Lines(new DefaultLineGenerator(names), height);
        Ladder ladder = new Ladder(names, lines, resultsRequest);
        OutputView.printLadder(ladder);

        ResultsResponse resultsResponse = ladder.play();

        while (true) {
            OutputView.printResult(InputView.inputPersonName(), resultsResponse);

            if (InputView.inputStartOrExit()) {
                break;
            }
        }
        OutputView.printEnd();
    }
}
