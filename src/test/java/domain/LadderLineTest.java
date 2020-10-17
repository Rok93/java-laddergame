package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderLineTest {

    @DisplayName("LadderLine 객체를 생성한다 ")
    @Test
    void testInitLadderLine() {

        //given
        List<Point> pointsValue = Arrays.asList(true, false).stream()
                .map(Point::new)
                .collect(Collectors.toList());
        Points points = new Points(pointsValue);

        //when
        LadderLine ladderLine = new LadderLine(points);

        //then
        assertThat(ladderLine.getValues())
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(new Point(true), new Point(false));
    }

    @DisplayName("특정 위치에서 사다리 라인을 타고 이동한 다음 위치를 얻는 기능을 테스트한다 ")
    @Test
    void testMovePoint() {

        //given
        Points points = new Points(Arrays.asList(true, false).stream()
                .map(Point::new)
                .collect(Collectors.toList()));

        LadderLine ladderLine = new LadderLine(points);

        //when
        int firstMovePosition = ladderLine.movePoint(0);
        int secondMovePosition = ladderLine.movePoint(1);
        int thirdMovePosition = ladderLine.movePoint(2);

        //then
        assertAll(
                () -> assertThat(firstMovePosition).isEqualTo(1),
                () -> assertThat(secondMovePosition).isEqualTo(0),
                () -> assertThat(thirdMovePosition).isEqualTo(2)
        );
    }
}
