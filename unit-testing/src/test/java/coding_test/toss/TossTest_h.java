package coding_test.toss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TossTest_h {
    
    @Nested
    class 토스_1번 {
        
        /**
         * 닭가슴살 찾기
         * 7: 닭가슴살
         * 0: 액상과당 음료수
         * 8: 초콜릿
         * <p>
         * 출발 지점에서 왼쪽 혹은 오른쪽 이동 가능
         * 이후에는 위 또는 아래로 이동
         * 그 다음 다시 왼쪽과 오른쪽으로 이동 가능(반복)
         * 이동 방향으로 현재 위치의 숫자만큼 이동
         * 길목에 음료수나 초콜릿이 있는 것은 상관 X
         * 이동의 도착점이 초콜릿(8) 또는 음료수(0)이면 해당 경로 포기
         * 지도를 벗어나면 해당 경로 포기
         */
        boolean 토스_1번_문제(int[][] map, int[] entrancePoint) {
            
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{entrancePoint[0], entrancePoint[1], 1}); // 큐에 넣기(상 하 => 0ㅣ, 좌 우 => 1);
            
            while (!queue.isEmpty()) {
                
                //방향 설정
                int[] dr = {-1, 1, 0, 0};
                int[] dc = {0, 0, -1, 1};
                
                int[] cPos = queue.poll(); // 현재 위치
                
                int cValue = map[cPos[0]][cPos[1]]; // 현재 지도 위치 값
                
                if (cValue == 7) {
                    return true;
                }
                
                // 상하 이동
                for (int i = 0; i < 4; i++) {
                    
                    int nextR = cPos[0] + (cValue * dr[i]);
                    int nextC = cPos[1] + (cValue * dc[i]);
                    
                    // Map 내부인지 확인
                    if (nextR >= 0 && nextR < map.length &&
                        nextC >= 0 && nextC < map[0].length) {
                        if (cPos[2] == 0) {
                            queue.offer(new int[]{nextR, nextC, 1});
                        } else {
                            queue.offer(new int[]{nextR, nextC, 0});
                        }
                    }
                }
            }
            
            return false;
        }
        
        @Test
        void 토스_1번_문제_테스트() {
            // given
            int[][] map1 = {new int[]{1, 2, 1}, new int[]{8, 2, 0}, new int[]{1, 7, 2}};
            int[] entrancePoint1 = new int[]{0, 0};
            
            int[][] map2 = {new int[]{1, 2, 3, 2, 1}, new int[]{4, 2, 0, 7, 1}, new int[]{1, 3, 2, 8, 1}, new int[]{2, 0, 1, 1, 1},
                new int[]{8, 2, 1, 2, 1}};
            int[] entrancePoint2 = new int[]{4, 3};
            
            // then
            assertTrue(토스_1번_문제(map1, entrancePoint1));
            assertTrue(토스_1번_문제(map2, entrancePoint2));
        }
        
    }
    
    @Nested
    class 토스_2번 {
        
        /**
         * AI 상담원을 사용해서 고객 상담 수요를 충족시키려고할 때, 최소 비용 구하기
         */
        int 토스_2번_문제(int[] customers, int[] modelCapacities, int[] modelCosts) {
            int maxCustomerCount = Arrays.stream(customers).max().orElse(0); // 최대 고객 수 찾기
            
            // dp[i]는 i명의 고객을 처리하는 데 드는 최소 비용을 의미
            int[] dp = new int[maxCustomerCount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE); // 초기화
            dp[0] = 0; // 고객이 없을 때 비용은 0
            
            // 각 모델에 대해, 그 모델을 사용하여 dp 테이블을 업데이트
            for (int i = 0; i < modelCapacities.length; i++) {
                int capacity = modelCapacities[i];
                int cost = modelCosts[i];
                
                // 각 모델을 여러 번 사용할 수 있으므로, 모든 수요에 대해 최적 비용을 갱신
                for (int j = capacity; j <= maxCustomerCount; j++) {
                    if (dp[j - capacity] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - capacity] + cost);
                    }
                }
            }
            
            // 최종적으로 최대 고객 수를 처리하는 데 필요한 최소 비용 반환
            return dp[maxCustomerCount];
        }
        
        @Test
        void 토스_2번_문제_테스트() {
            // given
            int[] customers1 = {0, 1, 2, 230};
            int[] modelCapacities1 = {7, 3, 9};
            int[] modelCosts1 = {9, 10, 1};
            
            // then
            assertEquals(318, 토스_2번_문제(customers1, modelCapacities1, modelCosts1));
        }
    }
}
