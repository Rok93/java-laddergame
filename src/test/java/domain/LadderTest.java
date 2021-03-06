package domain;

import dto.ResultRequest;
import dto.ResultsRequest;
import dto.ResultsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {
    @DisplayName("Ladder 객체를 생성한다 ")
    @Test
    void testInitLines() {
        //given
        Height height = new Height(2);
        Names names = new Names(Arrays.asList(new Name("철수"), new Name("영희")));
        List<Point> points = Arrays.asList(new Point(true));
        Lines lines = new Lines(number -> new Points(points), names, height);
        ResultsRequest resultsRequest = new ResultsRequest(Arrays.asList(new ResultRequest("꽝"), new ResultRequest("당첨")));

        //when
        Ladder ladder = new Ladder(lines, resultsRequest);

        //then
        assertThat(ladder.getLines()).hasSize(height.getValue());
    }

    @DisplayName("Results 갯수가 Line 길이와 매치되지 않으면 오류를 발생한다 ")
    @Test
    void testInitWhenResultsNumberIsNotMatchToLineLength() {
        //given
        Height height = new Height(2);
        Names names = new Names(Arrays.asList(new Name("철수"), new Name("영희"), new Name("바둑이")));
        List<Point> points = Arrays.asList(new Point(true));
        Lines lines = new Lines(number -> new Points(points), names, height);
        ResultsRequest resultsRequest = new ResultsRequest(Arrays.asList(new ResultRequest("꽝"), new ResultRequest("당첨")));

        //when // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Ladder(lines, resultsRequest));
    }

    @DisplayName("사다리 게임을 실행한 결괏값을 얻는 기능 ")
    @Test
    void testPlayLadderGame() {
        //given
        Height height = new Height(2);
        Names names = new Names(Arrays.asList(new Name("철수"), new Name("영희")));
        List<Point> points = Arrays.asList(new Point(true));
        Lines lines = new Lines(number -> new Points(points), names, height);
        ResultsRequest resultsRequest = new ResultsRequest(
                Arrays.asList(new ResultRequest("꽝"), new ResultRequest("당첨"))
        );

        Ladder ladder = new Ladder(lines, resultsRequest);

        //when
        ResultsResponse results = ladder.play();

        //then
        assertThat(results.getValues())
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(new ResultRequest("꽝"), new ResultRequest("당첨"));
    }
}
