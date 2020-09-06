package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderResultsTest {
    @DisplayName("LadderResults의 객체를 생성한다 ")
    @Test
    void testInitResults() {
        //given
        Name name = new Name("철수");
        Result result = new Result("꽝");
        Map<Name, Result> resultsValues = new HashMap<>();
        resultsValues.put(name, result);

        //when
        LadderResults ladderResults = new LadderResults(resultsValues);

        //then
        assertAll(
                () -> assertThat(ladderResults.getValues().get(0)).isEqualTo(result),
                () -> assertThat(ladderResults.getKeys().contains(name)).isTrue()
        );
    }

    @DisplayName("이름으로 결과를 조회하는 기능을 테스트한다 ")
    @Test
    void testGetResultByName() {
        //given
        Map<Name, Result> resultsValues = new HashMap<>();
        resultsValues.put(new Name("철수"), new Result("꽝"));
        resultsValues.put(new Name("영희"), new Result("당첨"));

        //when
        LadderResults ladderResults = new LadderResults(resultsValues);

        //then
        assertAll(
                () -> assertThat(ladderResults.getResultBy(new Name("철수"))).isEqualTo("꽝"),
                () -> assertThat(ladderResults.getResultBy(new Name("영희"))).isEqualTo("당첨")
        );
    }
}
