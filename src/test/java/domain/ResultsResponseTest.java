package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ResultsResponseTest {
    @DisplayName("LadderResults의 객체를 생성한다 ")
    @Test
    void testInitLadderResults() {
        //given
        Name name = new Name("철수");
        ResultRequest resultRequest = new ResultRequest("꽝");
        Map<Name, ResultRequest> resultsValues = new HashMap<>();
        resultsValues.put(name, resultRequest);

        //when
        ResultsResponse resultsResponse = new ResultsResponse(resultsValues);

        //then
        assertAll(
                () -> assertThat(resultsResponse.getValues().get(0).getValue()).isEqualTo("꽝"),
                () -> assertThat(resultsResponse.getKeys().contains(name)).isTrue()
        );
    }

    @DisplayName("이름으로 결과를 조회하는 기능을 테스트한다 ")
    @Test
    void testGetResultByName() {
        //given
        Map<Name, ResultRequest> resultsValues = new HashMap<>();
        resultsValues.put(new Name("철수"), new ResultRequest("꽝"));
        resultsValues.put(new Name("영희"), new ResultRequest("당첨"));

        //when
        ResultsResponse resultsResponse = new ResultsResponse(resultsValues);

        //then
        assertAll(
                () -> assertThat(resultsResponse.getResultBy(new Name("철수"))).isEqualTo("꽝"),
                () -> assertThat(resultsResponse.getResultBy(new Name("영희"))).isEqualTo("당첨")
        );
    }
}
