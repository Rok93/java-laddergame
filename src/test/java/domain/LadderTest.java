package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @DisplayName("Ladder 객체를 생성한다 ")
    @Test
    void testInitLines() {
        //given
        Height height = new Height(3);
        int personNumber = 2;

        //when
        Ladder ladder = new Ladder(height, personNumber);

        //then
        assertThat(ladder.getLines()).hasSize(height.getValue());
    }
}
