package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointsTest {

    @DisplayName("Points 객체를 생성한다 ")
    @Test
    void testInitPoints() {
        //given
        List<Point> pointGroup = Arrays.asList(new Point(true));

        //when
        Points points = new Points(pointGroup);

        //then
        assertThat(points.getSize()).isEqualTo(1);
    }

    @DisplayName("포인트가 최소 포인트 갯수보다 적으면 예외를 발생한다 ")
    @Test
    void testInitPointsWhenPointNumberLessThanMinPointNumber() {
        //given
        List<Point> points = Collections.EMPTY_LIST;

        //when //then
        assertThatThrownBy(() -> new Points(points))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("포인트가 연속으로 연결되어 있으면 예외를 발생한다 ")
    @Test
    void testInitPointIsConnectedContinuously() {
        //given
        List<Point> continuouslyConnectedPoints = Arrays.asList(new Point(true), new Point(true));

        //when //then
        assertThatThrownBy(() -> new Points(continuouslyConnectedPoints))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
