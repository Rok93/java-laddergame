package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @DisplayName("Line 객체를 선언한다")
    @Test
    void testInitLine() {
        //given
        int personNumber = 3;

        //when
        Line line = new Line(personNumber);

        //then
        assertThat(line.getPoints()).hasSize(personNumber - 1);
    }

    @DisplayName("Line객체는  최소 참가인원보다 적으면 예외를 발생시킨다")
    @Test
    void testPersonNumberLessThanMinPersonNumber() {
        //given
        int personNumber = 1;

        //when then
        assertThatThrownBy(() -> new Line(personNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
