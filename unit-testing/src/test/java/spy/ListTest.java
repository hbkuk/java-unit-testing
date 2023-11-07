package spy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void spyList_1() {
        ArrayList<String> spyList = spy(ArrayList.class);

        // 1차 검증
        assertThat(spyList.size()).isZero();

        // 데이터 추가
        spyList.add("data 1");
        spyList.add("data 2");

        // 2차 검증
        assertThat(spyList.get(0)).isEqualTo("data 1");
        assertThat(spyList.get(1)).isEqualTo("data 2");
        assertThat(spyList.size()).isEqualTo(2);

        // 행동 재정의 or 응답 반환 설정(stbbing)
        when(spyList.get(0)).thenReturn("data 10");
        when(spyList.size()).thenReturn(50);

        // 재 검증
        assertThat(spyList.get(0)).isEqualTo("data 10");
        assertThat(spyList.size()).isEqualTo(50);
    }

    @Test
    void listSpy() {
        List<String> spy = spy(new ArrayList<>()); // main.java.spy 객체 생성

        // spy를 이용해서 메서드 호출 기록
        spy.add("item 1");
        spy.add("item 2");

        // 메서드 호출 횟수 확인(add 메서드 2번 호출되었는지 검증)
        Mockito.verify(spy, Mockito.times(2)).add(Mockito.anyString());

        // 스파이 리스트는 실제 리스트와 동일한 데이터 유지
        assertEquals(2, spy.size());
        assertEquals("item 1", spy.get(0)); // 실제 데이터 접근 가능
        assertEquals("item 2", spy.get(1));
    }
}
