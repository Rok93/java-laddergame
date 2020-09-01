package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {
    @DisplayName("Ladder 객체를 생성한다 ")
    @Test
    void testInitLines() {
        //given
        Lines lines = new Lines(() -> new Line(Arrays.asList(true)), 2);
        Name chulsoo = new Name("철수");
        Name yeonghee = new Name("영희");
        Names names = new Names(Arrays.asList(chulsoo, yeonghee));

        //when
        Ladder ladder = new Ladder(names, lines);

        //then
        assertAll(
                () -> assertThat(ladder.getLines()).hasSize(2),
                () -> assertThat(ladder.getNames().getValues().get(0)).isEqualTo(chulsoo),
                () -> assertThat(ladder.getNames().getValues().get(1)).isEqualTo(yeonghee)
        );
    }
}
