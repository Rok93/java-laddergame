package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @DisplayName("Line 객체를 생성한다")
    @Test
    void testInitLine() {
        //given
        List<Boolean> points = Arrays.asList(true, false, true);

        //when
        Line line = new Line(points);

        //then
        assertThat(line.getPoints()).hasSize(points.size());
    }

    @DisplayName("포인트가 하나도 없으면 예외를 발생시킨다")
    @Test
    void testPersonNumberLessThanMinPersonNumber() {
        //given
        List<Boolean> points = Collections.EMPTY_LIST;

        //when then
        assertThatThrownBy(() -> new Line(points))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
