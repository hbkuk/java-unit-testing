package coding_test.nhn_commerce;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NHNTest {
    
    @Nested
    class NHN_1번_문제 {
        
        @Test
        void NHN_1번_문제_테스트() {
            assertEquals(5, NHN_1번(new int[][]{{1, 4}, {2, 5}, {4, 6}}));
            assertEquals(4, NHN_1번(new int[][]{{1, 3}, {2, 4}, {3, 5}}));
            assertEquals(19, NHN_1번(new int[][]{{1, 10}, {5, 15}, {12, 20}}));
        }
        
        private int NHN_1번(int[][] ints) {
            // TODO 1) 크기 365인 배열을 만든다.
            int[] days = new int[365 + 1];
            
            // TODO 2) 전체 2차원 배열을 순회하면서, 피는날 ~ 지는날 - 1 까지 365 배열에 1씩 증가한다.
            for (int[] flower : ints) {
                int open = flower[0]; // 피는날 -> 포함 O
                int closed = flower[1]; // 지는날 -> 포함 X
                
                // 피는날 ~ 지는날 -1 까지 순회
                for (int i = open; i < closed; i++) {
                    days[i]++;
                }
            }
            
            // TODO 3) 365 배열을 순회하면서, 1보다 큰? 요소 개수를 카운팅 후 출력한다.
            int count = 0;
            for (int day : days) {
                if (day != 0) {
                    count++;
                }
            }
            
            return count;
        }
    }
    
    @Nested
    class NHN_2번_문제 {
        
        @Test
        void testDescendingSort() {
            assertEquals("eacdb", NHN_2번("caedb", 1));
            assertEquals("edcab", NHN_2번("caedb", 2));
            assertEquals("eedcba", NHN_2번("eedcab", 3));
            assertEquals("cba", NHN_2번("cba", 1));
            assertEquals("ddcba", NHN_2번("bacdd", 2));
        }
        
        private String NHN_2번(String s, int k) {
            
            char[] chars = s.toCharArray();
            
            // char 배열의 크기 && 교환 횟수만큼 반복
            for (int i = 0; i < chars.length && k > 0; i++) {
                
                // 가장 큰 문자 찾기
                int maxIndex = i; // i
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] > chars[maxIndex]) {
                        maxIndex = j;
                    }
                }
                
                // 정렬이 보장된 인덱스와 위치 교환
                if (i != maxIndex) {
                    char tempChar = chars[i];
                    chars[i] = chars[maxIndex];
                    chars[maxIndex] = tempChar;
                    k--;
                }
            }
            
            return new String(chars);
        }
    }
    
    @Nested
    class NHN_3번_문제 {
        
        @Test
        void NHN_3번_테스트() {
            assertArrayEquals(new int[]{3, 1, 5, 5, 5, 5, 3, 5, 0}, NHN_3번(new int[]{1, 10, 5, 4, 5, 2, 8, 3, 15}, 3));
            assertArrayEquals(new int[]{2, 1, 0, 1, 1, 2, 1, 2, 2, 2}, NHN_3번(new int[]{4, 20, 7, 11, 14, 16, 10, 18, 3, 4}, 2));
        }
        
        private int[] NHN_3번(int[] appetites, int k) {
            
            // TODO 1) 원본 배열은 보존
            int[] copyAppetites = appetites.clone();
            Arrays.sort(copyAppetites);
            
            // TODO 2) 가장 큰 값을 기준으로 boolean[] 배열 생성
            int[] appetiteCount = new int[copyAppetites[copyAppetites.length - 1] + 1];
            
            
            // TODO 3) 취향 수치가 있는 elem 만 true 표시
            for(int i = 0; i < copyAppetites.length; i++) {
                appetiteCount[copyAppetites[i]] ++;
            }
            
            // TODO 4) 취향 수치 카운팅 => 여기서 뭔가 문제가 있음..
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < copyAppetites.length; i++) {
                int minRange = copyAppetites[i] - k;
                int maxRange = copyAppetites[i] + k;
                
                int count = 0;
                for(int j = minRange; j <= maxRange; j++) {
                    
                    // 범위 안에 있는 것들만 확인
                    if(j >= 0 && j <= copyAppetites[copyAppetites.length - 1]) {
                        count += appetiteCount[j];
                    }
                }
                
                // 기존에 map에 있는지 확인
                if(!map.containsKey(copyAppetites[i])) {
                    if(count != 0) {
                        count --;
                        map.put(copyAppetites[i], count);
                    }
                }
            }
            
            
            // TODO 5) 원본 배열 전체 순회 -> 값 구성
            int[] result = new int[appetites.length];
            for(int i = 0; i < appetites.length; i++) {
                result[i] = map.get(appetites[i]);
                
            }
            return result;
        }
    }
    
    @Nested
    class NHN_4번_문제 {
        @Test
        void NHN_4번_테스트() {
            assertEquals(8, NHN_4번(new int[]{2, 4, 5, 2}, 9));
            assertEquals(2, NHN_4번(new int[]{1, 2}, 3));
            assertEquals(4, NHN_4번(new int[]{1, 2}, 5));
        }
        
        private int NHN_4번(int[] cards, int k) {
            int dob = ((k - 1) / cards.length); // 몇 배수인지
            return cards[k % cards.length] * dob;
        }
    }
}
