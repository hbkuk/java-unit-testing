package coding_test.hyundai_autoever;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class HyundaiAutoeverTest_2 {
    
    @Nested
    @DisplayName("최단 도착시간 구하기")
    class 오토에버_1번_문제 {
        @Test
        @DisplayName("출발지(1)에서 목적지(N)까지 최단 시간을 구한다")
        void 오토에버_1번_문제_테스트() {
            // 출발지와 목적지가 가까운 경우
            assertEquals(3, 오토에버_1번(9, 2));
            assertEquals(5, 오토에버_1번(10, 1));
            
            // 목적지가 1인 경우
            assertEquals(0, 오토에버_1번(1, 1)); // 이미 도착지에 있음
            assertEquals(0, 오토에버_1번(1, 2)); // K의 크기와 무관
            
            // 속도 조정 범위가 작은 경우
            assertEquals(4, 오토에버_1번(6, 1));  // 짧은 거리
            assertEquals(10, 오토에버_1번(20, 1)); // 중간 거리
            
            // 속도 조정 범위가 큰 경우
            assertEquals(3, 오토에버_1번(9, 2));  // 짧은 거리
            assertEquals(7, 오토에버_1번(50, 2)); // 중간 거리
        }
        
        private int 오토에버_1번(int N, int K) {
            return 0;
        }
    }
    
//    @Nested
//    @DisplayName("인공위성으로 탐색하기")
//    class 오토에버_2번_문제 {
//        @Test
//        @DisplayName("3차원 맵에서 최대 보상을 획득하여 도착지점까지 이동한다")
//        void findMaxRewardPath() {
//            // given
//            Solution2 solution = new Solution2();
//            int N = 3, M = 3, L = 3, T = 1;  // 맵 크기와 벽 부수기 횟수
//            int[][][] map = {
//                {
//                    {1, 0, 1},
//                    {0, -1, 0},
//                    {1, 0, 1}
//                },
//                {
//                    {0, -1, 0},
//                    {1, 0, 1},
//                    {0, -1, 0}
//                },
//                {
//                    {1, 0, 1},
//                    {0, -1, 0},
//                    {1, 0, 1}
//                }
//            };
//
//            // when
//            int result = solution.solution(N, M, L, T, map);
//
//            // then
//            assertThat(result).isEqualTo(5);  // 예상되는 최대 보상값
//        }
//    }
}
