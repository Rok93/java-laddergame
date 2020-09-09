package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {
    @DisplayName("Ladder 객체를 생성한다 ")
    @Test
    void testInitLines() {
        //given
        Height height = new Height(2);
        Lines lines = new Lines(() -> new Line(Arrays.asList(true)), height);
        Names names = new Names(Arrays.asList(new Name("철수"), new Name("영희")));
        Results results = new Results(Arrays.asList(new Result("꽝"), new Result("당첨")));

        //when
        Ladder ladder = new Ladder(names, lines, results);

        //then
        assertAll(
                () -> assertThat(ladder.getLines()).hasSize(height.getValue()),
                () -> assertThat(ladder.getNames().getValues().contains(new Name("철수"))).isTrue(),
                () -> assertThat(ladder.getNames().getValues().contains(new Name("영희"))).isTrue()
                // Results 관련 테스트 추가해야할까??
        );
    }

    @DisplayName("Names 길이와 Results 길이가 다르면 예외를 발생한다 ")
    @Test
    void testInitWhenNamesNumberIsNotEqualToResultsNumber() {
        //given
        Height height = new Height(2);
        Lines lines = new Lines(() -> new Line(Arrays.asList(true)), height);
        Names names = new Names(Arrays.asList(new Name("철수"), new Name("영희"), new Name("바둑이")));
        Results results = new Results(Arrays.asList(new Result("꽝"), new Result("당첨")));

        //when // then
        assertThatThrownBy(() -> new Ladder(names, lines, results))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 게임을 실행한 결괏값을 얻는 기능 ")
    @Test
    void testPlayLadderGame() {
        //given
        Height height = new Height(2);
        Lines lines = new Lines(() -> new Line(Arrays.asList(true)), height);
        Names names = new Names(Arrays.asList(new Name("철수"), new Name("영희")));
        Results results = new Results(Arrays.asList(new Result("꽝"), new Result("당첨")));

        Ladder ladder = new Ladder(names, lines, results);

        //when
        LadderResults resultsByName = ladder.play();

        //then
        assertAll(
                () -> assertThat(resultsByName.findResult(new Name("철수"))).isEqualTo("꽝"),
                () -> assertThat(resultsByName.findResult(new Name("영희"))).isEqualTo("당첨")
        );
    }
}
