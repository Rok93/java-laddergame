package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LinesTest {
    @DisplayName("Lines 객체를 생성한다 ")
    @Test
    void testInitLineTest() {
        //given
        LineGenerator lineGenerator = () -> new Line(Arrays.asList(true));
        Height height = new Height(2);

        //when
        Lines lines = new Lines(lineGenerator, height);

        //then
        assertThat(lines.getLines()).hasSize(height.getValue());
    }

    @DisplayName("특정 위치가 Lines를 타고 내려왔을 때의 위치를 찾는 기능을 테스트한다 ")
    @Test
    void testTraceLines() {
        //given
        Lines lines = new Lines(() -> new Line(Arrays.asList(true, false)), new Height(2));

        //when
        List<Integer> resultsPositions = lines.traceResults();

        //then
        assertAll( //todo: 현재 traceResults() 기능에 Names 길이를 임시적으로 상수로 지정해놨기 때문에, 오류가 난다.
                () -> assertThat(resultsPositions.get(0)).isEqualTo(0),
                () -> assertThat(resultsPositions.get(1)).isEqualTo(1),
                () -> assertThat(resultsPositions.get(2)).isEqualTo(2)
        );
    }
}
