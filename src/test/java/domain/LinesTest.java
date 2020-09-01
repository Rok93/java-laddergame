package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

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
}
