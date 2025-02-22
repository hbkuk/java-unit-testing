package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    
    public int 이분탐색(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (arr[mid] == target) { // 찾은 경우
                return mid;
            } else if (arr[mid] < target) { // 찾는 숫자가 더 큰경우
                left = mid + 1;
            } else { // 찾는 숫자가 더 작은 경우
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    @Test
    void 이분탐색_테스트() {
        // given
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 7;
        
        // when
        int result = 이분탐색(arr, target);
        
        // then
        assertEquals(3, result);
    }
    
}
