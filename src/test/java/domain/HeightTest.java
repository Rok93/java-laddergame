package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {
    @DisplayName("Height 객체를 생성한다 ")
    @Test
    void testInitHeight() {
        //given
        int heightValue = 3;

        //when
        Height height = new Height(heightValue);

        //then
        assertThat(height.getValue()).isEqualTo(heightValue);
    }

    @DisplayName("최소 높이보다 작으면 예외를 발생시킨다 ")
    @Test
    void testHeightLessThanMinLimitHeight() {
        //given
        int heightValue = 0;

        //when //then
        assertThatThrownBy(() -> new Height(heightValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
