package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @DisplayName("특정위치에서 연결되어있는 포인트를 따라 이동한 다음 위치를 찾는 기능을 테스트한다")
    @Test
    void testFollowPoint() {
        //given
        Points points = new Points(Arrays.asList(new Point(false), new Point(true)));

        //when
        int firstPosition = points.followPoint(0);
        int secondPosition = points.followPoint(1);
        int thirdPosition = points.followPoint(2);

        //then
        assertAll(
                () -> assertThat(firstPosition).isEqualTo(0),
                () -> assertThat(secondPosition).isEqualTo(2),
                () -> assertThat(thirdPosition).isEqualTo(1)
        );
    }
}
