package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @DisplayName("Line 객체를 생성한다")
    @Test
    void testInitLine() {
        //given
        List<Point> ts = Arrays.asList(true, false).stream()
                .map(Point::new)
                .collect(Collectors.toList());
        Points points = new Points(ts);

        //when
        Line line = new Line(points);

        //then
        assertThat(line.getPoints().getValues()).hasSize(ts.size());
    }
}
