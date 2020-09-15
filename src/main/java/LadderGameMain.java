import domain.*;
import view.InputView;
import view.OutputView;

public class LadderGameMain {
    public static void main(String[] args) {
        Names names = InputView.inputPersonNames();
        ResultsRequest resultsRequest = InputView.inputResults();
        Height height = InputView.inputHeight();
        Lines lines = new Lines(new DefaultLineGenerator(names), height);
        Ladder ladder = new Ladder(lines, resultsRequest);
        OutputView.printLadder(names, ladder);

        ResultsResponse resultsResponse = ladder.play();

        while (true) {
            Name findName = InputView.inputPersonName();
            OutputView.printResult(names, findName, resultsResponse);

            if (InputView.inputStartOrExit()) {
                break;
            }
        }
        OutputView.printEnd();
    }
}
