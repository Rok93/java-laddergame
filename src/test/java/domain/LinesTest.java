package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LinesTest {
    @DisplayName("Lines 객체를 생성한다 ")
    @Test
    void testInitLineTest() {
        //given
        Height height = new Height(2);
        Names names = new Names(Arrays.asList("철수", "영희").stream()
                .map(Name::new)
                .collect(Collectors.toList()));

        //when
        Lines lines = new Lines(number -> new Line(Arrays.asList(true)), names, height);

        //then
        assertThat(lines.getLines()).hasSize(height.getValue());
    }

    @DisplayName("특정 위치가 Lines를 타고 내려왔을 때의 위치를 찾는 기능을 테스트한다 ")
    @Test
    void testTraceLines() {
        //given
        Names names = new Names(Arrays.asList("철수", "영희", "바둑이").stream()
                .map(Name::new)
                .collect(Collectors.toList()));
        Lines lines = new Lines(number -> new Line(Arrays.asList(true, false)), names, new Height(2));

        //when
        List<Integer> resultsPositions = lines.traceResults();

        //then
        assertAll(
                () -> assertThat(resultsPositions.get(0)).isEqualTo(0),
                () -> assertThat(resultsPositions.get(1)).isEqualTo(1),
                () -> assertThat(resultsPositions.get(2)).isEqualTo(2)
        );
    }
}
