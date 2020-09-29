package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsResponseTest {

    @DisplayName("ResultsResponse의 객체를 생성한다")
    @Test
    void testInitLadderResults() {
        //given
        ResultRequest failResult = new ResultRequest("꽝");
        ResultRequest successResult = new ResultRequest("당첨");
        List<ResultRequest> results = Arrays.asList(failResult, successResult);


        //when
        ResultsResponse resultsResponse = new ResultsResponse(results);

        //then
        assertThat(resultsResponse.getValues())
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(failResult, successResult);
    }
}
