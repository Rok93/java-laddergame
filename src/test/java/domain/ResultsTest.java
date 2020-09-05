package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ResultsTest {
    @DisplayName("Results 일급 컬렉션의 객체를 생성한다 ")
    @Test
    void testInitResults() {
        //given
        Name name = new Name("철수");
        Result result = new Result("꽝");
        Map<Name, Result> resultsValues = new HashMap<>();
        resultsValues.put(name, result);

        //when
        Results results = new Results(resultsValues);

        //then
        assertAll(
                () -> assertThat(results.getValues().get(0)).isEqualTo(result),
                () -> assertThat(results.getKeys().contains(name)).isTrue()
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
        Results results = new Results(resultsValues);

        //then
        assertAll(
                () -> assertThat(results.getResultBy(new Name("철수"))).isEqualTo("꽝"),
                () -> assertThat(results.getResultBy(new Name("영희"))).isEqualTo("당첨")
        );
    }
}
