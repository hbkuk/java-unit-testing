package coding_test.hyundai_autoever;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.*;

public class HyundaiAutoeverTest {
    
    @Nested
    @DisplayName("최단 도착시간 구하기")
    class 오토에버_1번_문제 {
        @Test
        @DisplayName("출발지(1)에서 목적지(N)까지 최단 시간을 구한다")
        void 오토에버_1번_문제_테스트() {
            //assertEquals(3, 오토에버_1번(9, 2));
            assertEquals(5, 오토에버_1번(10, 1));
        }
        
        private int 오토에버_1번(int N, int K) {
            int minTime = Integer.MAX_VALUE;
            
            // 위치, 속도, 시간
            Set<String> visited = new HashSet<>();
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{1, 0, 0}); // (위치, 속도, 시간)
            visited.add("1_0");
            
            // Queue가 비어있을 때까지 반복
            while(!queue.isEmpty()) {
                
                int[] current = queue.poll();
                
                int currentDistance = current[0];
                int currentSpeed = current[1];
                int currentTime = current[2];
                
                // 도착한 경우, 최소 시간 갱신
                if(currentDistance == N && K >= currentSpeed ) {
                    minTime = Math.min(minTime, currentTime);
                    continue;
                }
                
                // 이동 방법 적용
                for(int i = -K; i <= K; i++) {
                   int nextSpeed = currentSpeed + i;
                   int nextDistance = currentDistance + nextSpeed;
                   
                   // 스피드가 0 이상 && N을 넘지 않으면서
                   if(nextSpeed >= 0 && N >= nextDistance && !visited.contains(nextDistance + "_" + nextSpeed)) {
                       visited.add(nextDistance + "_" + nextSpeed);
                       queue.offer(new int[]{nextDistance, nextSpeed, currentTime + 1}); // (위치, 속도, 시간)
                   }
                }
            }
            
            
            
            return minTime;
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
