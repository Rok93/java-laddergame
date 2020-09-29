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
        String name1 = "참가자1";
        String name2 = "참가자2";
        List<Name> lines = Arrays.asList(new Name(name1), new Name(name2));

        //when
        Names names = new Names(lines);

        //then
        assertThat(names.getValues())
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(new Name(name1), new Name(name2));
    }

    @DisplayName("사람 수를 계산하는 기능을 테스트한다 ")
    @Test
    void testCalculatePersonNumberFunction() {
        //given
        List<Name> lines = Arrays.asList(new Name("참가자1"), new Name("참가자2"));
        Names names = new Names(lines);

        //when
        int personNumber = names.calculatePersonNumber();

        //then
        assertThat(personNumber).isEqualTo(lines.size());
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
