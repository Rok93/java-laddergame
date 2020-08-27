package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {
    @DisplayName("Name 객체를 생성한다 ")
    @Test
    void testInitNames() {
        //given
        Name name1 = new Name("참가자1");
        Name name2 = new Name("참가자2");
        List<Name> lines = Arrays.asList(name1, name2);

        //when
        Names names = new Names(lines);

        //then
        assertThat(names.getValues()).contains(name1, name2);
    }

    @DisplayName("사람 수를 계산하는 기능을 테스트한다 ")
    @Test
    void testCalculatePersonNumberFunction() {
        //given
        List<Name> lines = Arrays.asList(new Name("참가자1"), new Name("참가자2"));

        //when
        Names names = new Names(lines);

        //then
        assertThat(names.calculatePersonNumber()).isEqualTo(lines.size());
    }

    @DisplayName("참가자 수가 최소 참가인원 수 보다 작으면 예외를 발생시킨다 ")
    @Test
    void testNamesNumberLessThanMinNameNumber() {
        //given
        List<Name> names = Arrays.asList(new Name("참가자1"));

        //when //then
        assertThatThrownBy(() -> new Names(names))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
