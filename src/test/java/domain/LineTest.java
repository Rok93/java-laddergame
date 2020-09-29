package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {
    @DisplayName("Line 객체를 생성한다")
    @Test
    void testInitLine() {
        //given
        Points points = new Points(
                Arrays.asList(true, false)
                        .stream()
                        .map(Point::new)
                        .collect(Collectors.toList()));

        //when
        Line line = new Line(points);

        //then
        assertThat(line.getPoints().getValues()).hasSize(2);
    }

    @DisplayName("특정 위치에서 사다리의 한 라인을 탄 다음 위치를 얻는 기능 ")
    @Test
    void testGetNextPosition() {
        //given
        Points points = new Points(
                Arrays.asList(true, false)
                        .stream()
                        .map(Point::new)
                        .collect(Collectors.toList()));

        Line line = new Line(points);

        //when
        int nextPositionFromFirstPosition = line.getNextPosition(0);
        int nextPositionFromSecondPosition = line.getNextPosition(1);
        int nextPositionFromThirdPosition = line.getNextPosition(2);

        //then
        assertAll(
                () -> assertThat(nextPositionFromFirstPosition).isEqualTo(1),
                () -> assertThat(nextPositionFromSecondPosition).isEqualTo(0),
                () -> assertThat(nextPositionFromThirdPosition).isEqualTo(2)
        );
    }
}
