package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class ResultsTest {
    @DisplayName("Results 객체를 생성한다 ")
    @Test
    void testInitResults() {
        //given
        List<Result> resultValues = Arrays.asList("꽝", "당첨").stream()
                .map(Result::new)
                .collect(Collectors.toList());

        //when
        Results results = new Results(resultValues);

        //then
        assertAll(
                () -> assertThat(results.getValues().get(0).getValue()).isEqualTo("꽝"),
                () -> assertThat(results.getValues().get(1).getValue()).isEqualTo("당첨")
        );
    }

    @DisplayName("Results 길이가 최소길이보다 작으면 예외를 발생한다 ")
    @Test
    void testInitWhenResultLengthLessThanMinResultNumber() {
        //given
        List<Result> resultValues = Arrays.asList(new Result("꽝"));

        //when //then
        assertThatThrownBy(() -> new Results(resultValues))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
