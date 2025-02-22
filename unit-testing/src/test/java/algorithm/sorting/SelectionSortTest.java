package algorithm.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SelectionSortTest {
    
    @Test
    void testBubbleSort() {
        // 테스트 1: 정상적인 배열 정렬
        int[] input = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};
        assertArrayEquals(expected, selectionSort(input));
        
        // 테스트 2: 이미 정렬된 배열
        int[] input2 = {1, 2, 3, 4, 5};
        int[] expected2 = {1, 2, 3, 4, 5};
        assertArrayEquals(expected2, selectionSort(input2));

        // 테스트 3: 빈 배열
        int[] input3 = {};
        int[] expected3 = {};
        assertArrayEquals(expected3, selectionSort(input3));

        // 테스트 4: 하나의 요소만 있는 배열
        int[] input4 = {10};
        int[] expected4 = {10};
        assertArrayEquals(expected4, selectionSort(input4));

        // 테스트 5: 음수 포함된 배열
        int[] input5 = {3, -2, -1, 5, 0};
        int[] expected5 = {-2, -1, 0, 3, 5};
        assertArrayEquals(expected5, selectionSort(input5));
    }
    
    public static int[] selectionSort(int[] input) {
        // 1. 배열에서 가장 작은 값을 찾아서, 맨 앞의 값과 교환
        // TODO 1.
        return null;
    }
    
}

