import domain.Ladder;
import domain.Names;
import view.InputView;
import view.OutputView;

public class LatherGameMain {
    public static void main(String[] args) {
        Names names = InputView.inputPersonNames();
        Ladder ladder = new Ladder(InputView.inputHeight(), names.calculatePersonNumber());
        OutputView.printResult(ladder, names);
    }
}
