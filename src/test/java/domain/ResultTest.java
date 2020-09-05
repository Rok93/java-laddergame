package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {
    @DisplayName("결과 객체를 생성한다 ")
    @Test
    void testInitResult() {
        //given
        String resultValue = "결과1";

        //when
        Result result = new Result(resultValue);

        //then
        assertThat(result.getValue()).isEqualTo(resultValue);
    }

    @DisplayName("비어있는 결괏 값을 가진 결과 객체를 생성하면 예외를 발생한다 ")
    @Test
    void testInitResultWhenEmptyResultValue() {
        //given
        String emptyResultValue = "";

        //when //then
        assertThatThrownBy(() -> new Result(emptyResultValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
