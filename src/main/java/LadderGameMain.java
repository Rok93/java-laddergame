import domain.*;
import dto.ResultsRequest;
import dto.ResultsResponse;
import view.InputView;
import view.OutputView;

public class LadderGameMain {
    public static void main(String[] args) {
        Names names = InputView.inputPersonNames();
        ResultsRequest resultsRequest = InputView.inputResults();
        Height height = InputView.inputHeight();
        Lines lines = new Lines(new DefaultLineGenerator(), names, height);
        Ladder ladder = new Ladder(lines, resultsRequest);
        OutputView.printLadder(names, ladder, resultsRequest);

        ResultsResponse resultsResponse = ladder.play();

        while (true) {
            OutputView.printResult(names, InputView.inputPersonName(), resultsResponse);

            if (InputView.inputStartOrExit()) {
                break;
            }
        }
        OutputView.printEnd();
    }
}
