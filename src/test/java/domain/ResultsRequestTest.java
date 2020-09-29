package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsRequestTest {
    @DisplayName("Results 객체를 생성한다 ")
    @Test
    void testInitResults() {
        //given
        List<ResultRequest> resultRequestValues = Arrays.asList("꽝", "당첨").stream()
                .map(ResultRequest::new)
                .collect(Collectors.toList());

        //when
        ResultsRequest resultsRequest = new ResultsRequest(resultRequestValues);

        //then
        assertThat(resultsRequest.getValues())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(new ResultRequest("꽝"), new ResultRequest("당첨"));
    }

    @DisplayName("Results 길이가 최소길이보다 작으면 예외를 발생한다 ")
    @Test
    void testInitWhenResultLengthLessThanMinResultNumber() {
        //given
        List<ResultRequest> resultRequestValues = Arrays.asList(new ResultRequest("꽝"));

        //when //then
        assertThatThrownBy(() -> new ResultsRequest(resultRequestValues))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
