package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("Point 객체를 생성한다 ")
    @Test
    void testInitPoint() {
        //given
        boolean connected = true;
        boolean unconnected = false;

        //when
        Point connectedPoint = new Point(connected);
        Point unconnectedPoint = new Point(unconnected);

        //then
        assertThat(connectedPoint.isConnected()).isTrue();
        assertThat(unconnectedPoint.isConnected()).isFalse();
    }
}
