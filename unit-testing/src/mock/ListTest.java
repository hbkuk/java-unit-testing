package mock;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ListTest {

    @Test
    void functionality_verification() {
        List<String> mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.add("two");

        verify(mockedList).add("one");
        verify(mockedList).add("two");
        verify(mockedList, never()).clear();
    }

    @Test
    void linkedList_stubbing() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("frist");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(999));

        verify(mockedList).get(0);
    }

    @Test
    void argument_matchers() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        when(mockedList.get(anyInt())).thenReturn("element");

        System.out.println(mockedList.get(999));

        verify(mockedList).get(anyInt());
    }

    @Test
    void times_verification() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        verify(mockedList, never()).add("never happened");

        verify(mockedList, atLeastOnce()).add("three times");
        //verify(mockedList, atLeast(2)).add("five times");
        //verify(mockedList, atMost(5)).add("three times");
    }

    @Test
    void interactions_verification() {
        LinkedList<String> mockedList = mock(LinkedList.class);
        LinkedList<String> mockTwo = mock(LinkedList.class);
        LinkedList<String> mockThree = mock(LinkedList.class);

        mockedList.add("one");

        verify(mockedList).add("one");

        verify(mockedList, never()).add("two");

        verifyNoInteractions(mockTwo, mockThree);
    }
}
