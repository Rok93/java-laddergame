package domain;

import dto.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {
    @DisplayName("Ladder 객체를 생성한다 ")
    @Test
    void testInitLines() {
        //given
        Height height = new Height(2);
        Names names = new Names(Arrays.asList(new Name("철수"), new Name("영희")));
        List<Point> points = Arrays.asList(new Point(true));
        Lines lines = new Lines(number -> new Points(points), names, height);
        List<Result> resultsRequest = Arrays.asList(new Result("꽝"), new Result("당첨"));

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
        List<Result> resultsRequest = Arrays.asList(new Result("꽝"), new Result("당첨"));

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
        List<Result> resultsRequest = Arrays.asList(new Result("꽝"), new Result("당첨"));

        Ladder ladder = new Ladder(lines, resultsRequest);

        //when
        List<Result> results = ladder.play();

        //then
        assertThat(results)
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(new Result("꽝"), new Result("당첨"));
    }
}
