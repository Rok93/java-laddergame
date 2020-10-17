package dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    @DisplayName("결과 객체를 생성한다 ")
    @Test
    void testInitResult() {
        //given
        String resultValue = "결과";

        //when
        Result result = new Result(resultValue);

        //then
        assertThat(result.getValue()).isEqualTo(resultValue);
    }
}
