package coding_test.toss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TossTest_2 {
    
    @Nested
    class 토스_1번_문제 {
        
        @Test
        void 토스_1번_문제_테스트() {
            int[][] map1 = {new int[]{1, 2, 1}, new int[]{8, 2, 0}, new int[]{1, 7, 2}};
            int[] entrancePoint1 = new int[]{0, 0};
            assertTrue(토스_1번(map1, entrancePoint1));
            
            
            int[][] map2 = {new int[]{1, 2, 3, 2, 1}, new int[]{4, 2, 0, 7, 1}, new int[]{1, 3, 2, 8, 1}, new int[]{2, 0, 1, 1, 1},
                new int[]{8, 2, 1, 2, 1}};
            int[] entrancePoint2 = new int[]{4, 3};
            assertTrue(토스_1번(map2, entrancePoint2));
            
            int[][] map3 = {new int[]{1, 2, 1}, new int[]{8, 2, 0}, new int[]{1, 3, 2}};
            int[] entrancePoint3 = new int[]{0, 0};
            assertFalse(토스_1번(map3, entrancePoint3));
        }
        
        public static final int DIRECTION_COL = 1;
        public static final int DIRECTION_ROW = 2;
        
        /**
         * < 이동 >
         * 출발시점에서 좌/우만, 그 다음엔 상/하만 .. 반복
         * 도착 후 이동하려면, 현재 맵의 번호 만큼 이동 가능!
         *
         * < 포기 조건 >
         * 지도 벗어나면
         * 길목이 아닌, 도착점이 0 혹은 8인 경우
         */
        private boolean 토스_1번(int[][] map, int[] entrancePoint) {
            // bfs로 진행.. -> queue에서 꺼내서, 이동 가능한 곳들을 queue에 담는다..
            // 시작 지점에서 다음 방향을 설정해서 맵에 담는다.
            // 단백질을 만난 item이 있다면 그 즉시 false 반환
            
            boolean[][] visited = new boolean[map.length][map[0].length];
            
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{entrancePoint[0], entrancePoint[1], DIRECTION_COL});
            visited[entrancePoint[0]][entrancePoint[1]] = true; // 방문처리
            
            while(!queue.isEmpty()) { // 큐가 비어 있지 않을 때까지 반복..
                
                
                int[] current = queue.poll();
                
                int currentRow = current[0]; // 현재 row
                int currentCol = current[1]; // 현재 col
                int currentDirection = current[2]; // 현재 방향
                int currentPoint = map[currentRow][currentCol];
                
                if(currentPoint == 7) { // 닭가슴살을 발견한 경우
                    return true;
                }
                
                if(currentDirection == DIRECTION_COL) { // 좌/우로만 이동할 수 있는 경우
                    int nextCol_1 = currentCol - currentPoint; // 다음 좌로 col
                    int nextCol_2 = currentCol + currentPoint; // 다음 우로 col
                    
                    // 범위 안에 있거나, 액상과당 혹은 초콜릿이 아니거나 ...
                    if(nextCol_1 >= 0 && nextCol_1 <= map[0].length - 1 &&
                        map[currentRow][nextCol_1] != 0 && map[currentRow][nextCol_1] != 8 && !visited[currentRow][nextCol_1]) {
                        queue.offer(new int[]{currentRow, nextCol_1, DIRECTION_ROW});
                        visited[currentRow][nextCol_1] = true;
                    }
                    
                    if(nextCol_2 >= 0 && nextCol_2 <= map[0].length - 1 &&
                        map[currentRow][nextCol_2] != 0 && map[currentRow][nextCol_2] != 8 && !visited[currentRow][nextCol_2]) {
                        queue.offer(new int[]{currentRow, nextCol_2, DIRECTION_ROW});
                        visited[currentRow][nextCol_2] = true;
                    }
                    
                } else {
                    int nextRow_1 = currentRow + currentPoint; // 다음 상 row
                    int nextRow_2 = currentRow - currentPoint; // 다음 하 row
                    
                    if(nextRow_1 >= 0 && nextRow_1 <= map.length - 1 &&
                        map[nextRow_1][currentCol] != 0 && map[nextRow_1][currentCol] != 8 && !visited[nextRow_1][currentCol]) {
                        queue.offer(new int[]{nextRow_1, currentCol, DIRECTION_COL});
                        visited[nextRow_1][currentCol] = true;
                    }
                    
                    if(nextRow_2 >= 0 && nextRow_2 <= map.length - 1 &&
                        map[nextRow_2][currentCol] != 0 && map[nextRow_2][currentCol] != 8 && !visited[nextRow_2][currentCol]) {
                        queue.offer(new int[]{nextRow_2, currentCol, DIRECTION_COL});
                        visited[nextRow_2][currentCol] = true;
                    }
                }
            }
            return false;
        }
    }
    
    @Nested
    class 토스_2번_문제 {
        
        @Test
        void 토스_2번_문제_테스트() {
            // 테스트 케이스 1: 기본 예제
            int[] customers1 = {23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] modelCapacities1 = {12, 3, 19};
            int[] modelCosts1 = {28, 10, 35};
            assertEquals(55, RE_토스_2번(customers1, modelCapacities1, modelCosts1));
            
//            // 테스트 케이스 2: 다양한 상담 수요
//            int[] customers2 = {10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105, 110, 115, 120, 125};
//            int[] modelCapacities2 = {10, 25, 50};
//            int[] modelCosts2 = {20, 50, 80};
//            assertEquals(2280, RE_토스_2번(customers2, modelCapacities2, modelCosts2));
            
            // 테스트 케이스 3: 모델 비용과 처리량 비교
//            int[] customers3 = {50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
//            int[] modelCapacities3 = {5, 20, 30};
//            int[] modelCosts3 = {5, 15, 25};
//            assertEquals(1000, RE_토스_2번(customers3, modelCapacities3, modelCosts3));
            
//            // 테스트 케이스 4: 최대 처리량
//            int[] customers4 = {10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000};
//            int[] modelCapacities4 = {100, 500, 1000};
//            int[] modelCosts4 = {100, 400, 700};
//            assertEquals(240000, RE_토스_2번(customers4, modelCapacities4, modelCosts4));
            
            // 테스트 케이스 5: 단일 고객 수요
            int[] customers5 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] modelCapacities5 = {1, 10, 20};
            int[] modelCosts5 = {5, 20, 30};
            assertEquals(5, RE_토스_2번(customers5, modelCapacities5, modelCosts5));
        }
        
        
        /**
         * 시간당 최소 비용으로 AI 모델 운영해보기
         *
         * 1부터 10_000까지 최소 비용 갱신하자.
         */
        private int RE_토스_2번(int[] customers1, int[] modelCapacities1, int[] modelCosts1) {
            int[] dp = new int[10_000 + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            
            for(int customer = 1; customer <= 10_000; customer++) {
                
                for(int j = 0; j < modelCapacities1.length; j++) {
                    int capacity = modelCapacities1[j]; // 현재 모델의 capa
                    int cost = modelCosts1[j];  // 현재 모델의 비용
                    
                    // 현재 모델의 capa로 customer를 감당할 수 있는 경우
                    if(capacity >= customer ) {
                        dp[customer] = Math.min(dp[customer], cost);
                    }
                    
                    // 현재 모델의 capa로 customer를 감당할 수 없는 경우
                    else {
                        // 몇번 나눌 수 있는지 확인하기
                        int 전_비용 = dp[customer - capacity];
                        dp[customer] = Math.min(dp[customer], 전_비용 + cost);
                    }
                }
            }
            
            int sum = 0;
            
            for(int customer : customers1) {
                sum += dp[customer];
            }
            
            return sum;
        }
        
        
    }
    
    @Nested
    class 토스_5번_문제 {
        
        @Test
        void 토스_5번_문제_테스트() {
            Map<String, String> map1 = new HashMap<>();
            map1.put("db", "testdb://localhost:12345");
            map1.put("password", "test");
            map1.put("db-test", "{db}?test=123");
            
            assertEquals(new String[]
            {
                "db", "testdb://localhost:12345",
                "password", "test",
                "db-test", "testdb://localhost:12345?test=123"
            },
            토스_5번_문제(map1));
            
            Map<String, String> map2 = new HashMap<>();
            map2.put("key1", "{key2}");
            map2.put("key2", "{key1}");
            
            assertEquals(new String[]{}, 토스_5번_문제(map2));
            
            Map<String, String> map3 = new HashMap<>();
            map3.put("key1", "{test1}");
            map3.put("key2", "{test}");
            
            assertEquals(new String[]
            {
                "key1", "",
                "key2", "",
            },
            토스_5번_문제(map3));
            
            Map<String, String> map4 = new HashMap<>();
            map4.put("key1", "test1");
            map4.put("key2", "{{key1}}");
            
            assertEquals(new String[]
            {
                "key1", "test1",
                "key2", "test1",
            },
            토스_5번_문제(map4));
        }
        
        String[] 토스_5번_문제(Map<String, String> map) {
            return null;
        }

    }
}