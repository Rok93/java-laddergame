package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @DisplayName("Name 객체를 생성한다 ")
    @Test
    void testInitName() {
        //given
        String nameValue = "참가자1";

        //when
        Name name = new Name(nameValue);

        //then
        assertThat(name.getValue()).isEqualTo(nameValue);
    }

    @DisplayName("최대 이름 길이를 넘으면 예외를 발생시킨다 ")
    @Test
    void testNameLengthOverThanMaxNameLengthLimit() {
        //given
        String nameValue = "이브라히모비치";

        //when //then
        assertThatThrownBy(() -> new Name(nameValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소 이름 길이보다 작으면 예외를 발생시킨다")
    @Test
    void testNameLengthLessThanMinNameLenghtLimit() {
        //given
        String nameValue = "";

        //when //then
        assertThatThrownBy(() -> new Name(nameValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
