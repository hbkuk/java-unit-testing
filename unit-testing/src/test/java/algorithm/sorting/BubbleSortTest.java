package algorithm.sorting;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    
    @Test
    void testBubbleSort() {
        // 테스트 1: 정상적인 배열 정렬
        int[] input = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};
        assertArrayEquals(expected, bubbleSort(input));
        
        // 테스트 2: 이미 정렬된 배열
        int[] input2 = {1, 2, 3, 4, 5};
        int[] expected2 = {1, 2, 3, 4, 5};
        assertArrayEquals(expected2, bubbleSort(input2));

        // 테스트 3: 빈 배열
        int[] input3 = {};
        int[] expected3 = {};
        assertArrayEquals(expected3, bubbleSort(input3));

        // 테스트 4: 하나의 요소만 있는 배열
        int[] input4 = {10};
        int[] expected4 = {10};
        assertArrayEquals(expected4, bubbleSort(input4));

        // 테스트 5: 음수 포함된 배열
        int[] input5 = {3, -2, -1, 5, 0};
        int[] expected5 = {-2, -1, 0, 3, 5};
        assertArrayEquals(expected5, bubbleSort(input5));
    }
    
    public static int[] bubbleSort(int[] input) {
        // TODO: 배열의 인덱스 0번 부터 배열의 크기 - 1 까지 순회한다.
        //  - 단, 회전 당 맨 마지막 번호는 정렬되어있음이 보장된다.
        int[] arr = Arrays.copyOfRange(input, 0, input.length);
        int temp;
        
        for(int j = 1; j <= input.length - 1; j++) {
            for(int i = 0; i <= input.length - 1 - j; i++) {
                if(arr[i] > arr[i + 1]){
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        return arr;
    }
    
    
}

