package gpt.permutation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PermutationTest {
    
    /**
     * "abc" 문자열의 순열을 테스트합니다.
     */
    @Test
    void testPermutations1() {
        Solution solution = new Solution();
        
        List<String> result = solution.getPermutations1("abc");
        List<String> expected = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");
        
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }
    
    /**
     * "aab" 중복 문자가 포함된 문자열의 순열을 테스트합니다.
     */
    @Test
    void testPermutations2() {
        Solution solution = new Solution();
        
        List<String> result = solution.getPermutations2("aab");
        List<String> expected = Arrays.asList("aab", "aba", "baa");
        
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }
    
    /**
     * 입력: [1, 2, 3]
     * 출력: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
     */
    @Test
    void testPermutations3() {
        Solution solution = new Solution();
        
        int[] arr1 = {1, 2, 3};
        List<int[]> result = solution.getPermutations3(arr1);
        System.out.println("모든 순열 결과: ");
        for (int[] perm : result) {
            System.out.println(Arrays.toString(perm));
        }
        
        assertEquals(6, result.size());  // 3! = 6
        assertArrayEquals(new int[]{1, 2, 3}, result.get(0));
        assertArrayEquals(new int[]{3, 2, 1}, result.get(5));
    }
    
    /**
     * 입력: [1, 1, 2]
     * 출력: [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
     */
    @Test
    void testPermutations4() {
        Solution solution = new Solution();
        
        int[] arr2 = {1, 1, 2};
        List<int[]> result = solution.getPermutations4(arr2);
        System.out.println("모든 순열 결과: ");
        for (int[] perm : result) {
            System.out.println(Arrays.toString(perm));
        }
        
        assertEquals(3, result.size());  // 중복을 제거한 순열의 수
        assertArrayEquals(new int[]{1, 1, 2}, result.get(0));
        assertArrayEquals(new int[]{2, 1, 1}, result.get(2));
    }
}
