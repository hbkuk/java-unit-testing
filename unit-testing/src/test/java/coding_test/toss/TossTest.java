package coding_test.toss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TossTest {
    
    @Nested
    class 토스_1번_문제 {
        
        @Test
        void 토스_1번_문제_테스트() {
            // given
            int[][] map1 = {new int[]{1, 2, 1}, new int[]{8, 2, 0}, new int[]{1, 7, 2}};
            int[] entrancePoint1 = new int[]{0, 0};
            
            int[][] map2 = {new int[]{1, 2, 3, 2, 1}, new int[]{4, 2, 0, 7, 1}, new int[]{1, 3, 2, 8, 1}, new int[]{2, 0, 1, 1, 1},
                new int[]{8, 2, 1, 2, 1}};
            int[] entrancePoint2 = new int[]{4, 3};
            
            // then
            assertTrue(토스_1번(map1, entrancePoint1));
            assertTrue(토스_1번(map2, entrancePoint2));
        }
        
        private boolean 토스_1번(int[][] map, int[] entrancePoint) {
            int rowCount = map.length;
            int colCount = map[0].length;
            boolean[][] visited = new boolean[rowCount][colCount];
            
            int startRow = entrancePoint[0];
            int startCol = entrancePoint[1];
            
            // BFS 시작
            return bfs(startRow, startCol, map, visited);
        }
        
        private boolean bfs(int startRow, int startCol, int[][] map, boolean[][] visited) {
            Queue<int[]> queue = new LinkedList<>();
            
            // 자신 Queue에 넣기
            queue.offer(new int[]{startRow, startCol, 0}); // 0: 왼/오 | 1: 위/아래
            // 방문 체크
            visited[startRow][startCol] = true;
            
            // 큐가 비어있을 때까지
            while (!queue.isEmpty()) {
                
                // 좌 우
                int[] dr0 = {0, 0};
                int[] dc0 = {-1, 1};
                
                // 상 하
                int[] dr1 = {-1, 1};
                int[] dc1 = {0, 0};
                
                int[] current = queue.poll();
                
                int currentRow = current[0]; // 현재 세로 위치
                int currentCol = current[1]; // 현재 가로 위치
                int moveNumber = current[2]; // 0: 왼/오 | 1: 위/아래
                
                if (map[currentRow][currentCol] == 7) {
                    return true;
                }
                
                if (moveNumber == 0) {
                    
                    for (int i = 0; i < 2; i++) {
                        int nextCol = currentCol + (dc0[i] * map[currentRow][currentCol]);
                        
                        // 맵 범위 && 방문하지 않았음 && 음료수/초콜릿이 아닌 경우
                        if (nextCol >= 0 && nextCol < map[0].length &&
                            !visited[currentRow][nextCol] &&
                            (map[currentRow][nextCol] != 0 || map[currentRow][nextCol] != 8)) {
                            
                            visited[currentRow][nextCol] = true;
                            queue.offer(new int[]{currentRow, nextCol, 1});
                        }
                    }
                    
                } else {
                    
                    for (int i = 0; i < 2; i++) {
                        int nextRow = currentRow + (dr1[i] * map[currentRow][currentCol]);
                        
                        // 맵 범위 && 방문하지 않았음 && 음료수/초콜릿이 아닌 경우
                        if (nextRow >= 0 && nextRow < map.length &&
                            !visited[nextRow][currentCol] &&
                            (map[nextRow][currentCol] != 0 || map[nextRow][currentCol] != 8)) {
                            
                            visited[nextRow][currentCol] = true;
                            queue.offer(new int[]{nextRow, currentCol, 0});
                        }
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
            
            // given
            int[] customers0 = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230};
            int[] modelCapacities0 = {7, 3, 9};
            int[] modelCosts0 = {9, 10, 1};
            
            // then
            //assertEquals(318, RE_토스_2번(customers0, modelCapacities0, modelCosts0));
            
            // given
            int[] customers1 = {23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] modelCapacities1 = {12, 3, 19};
            int[] modelCosts1 = {28, 10, 35};
            
            // then
            assertEquals(55, RE_토스_2번(customers1, modelCapacities1, modelCosts1));
            
            // given
            int[] customers2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] modelCapacities2 = {5, 10, 20};
            int[] modelCosts2 = {1, 2, 3};
            
            // then
            //assertEquals(0, RE_토스_2번(customers2, modelCapacities2, modelCosts2));
        }
        
        private int 토스_2번(int[] customers, int[] modelCapacities, int[] modelCosts) {
            int totalCost = 0;
            
            for (int customerCount : customers) {
                int[] dp = new int[customerCount + 1];
                
                for (int i = 1; i <= customerCount; i++) {
                    dp[i] = Integer.MAX_VALUE;
                    
                    for (int j = 0; j < modelCapacities.length; j++) {
                        if (i - modelCapacities[j] >= 0) {
                            dp[i] = Math.min(dp[i], dp[i - modelCapacities[j]] + modelCosts[j]);
                        } else {
                            dp[i] = Math.min(dp[i], modelCosts[j]);
                        }
                    }
                }
                totalCost += dp[customerCount];
            }
            
            return totalCost;
        }
        
        private int RE_토스_2번(int[] customers, int[] modelCapacities, int[] modelCosts) {
            int totalCost = 0;
            
            for (int customer : customers) {
                int[] dp = new int[customer + 1]; // DP 배열 생성
                
                for (int i = 1; i <= customer; i++) {
                    // 초기 설정
                    dp[i] = Integer.MAX_VALUE;
                    
                    // DP 갱신
                    for (int j = 0; j < modelCapacities.length; j++) {
                        
                        if (i - modelCapacities[j] > 0) {
                            dp[i] = Math.min(dp[i], dp[i - modelCapacities[j]] + modelCosts[j]);
                        } else {
                            dp[i] = Math.min(dp[i], modelCosts[j]);
                        }
                    }
                }
                
                // 최적 비용 추가
                totalCost += dp[customer];
            }
            
            return totalCost;
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
            Map<String, String> resolvedMap = new HashMap<>();
            
            for (String key : map.keySet()) {
                Set<String> visited = new HashSet<>();
                String resolvedValue = resolveValue(map, key, visited);
                
                // 순환 참조가 있는 경우 빈 배열 반환
                if (resolvedValue == null) return new String[]{};
                resolvedMap.put(key, resolvedValue);
            }
            
            // 결과를 사전순으로 정렬하여 반환
            return resolvedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .flatMap(entry -> Stream.of(entry.getKey(), entry.getValue()))
                .toArray(String[]::new);
        }
        
        private String resolveValue(Map<String, String> map, String key, Set<String> visited) {
            // 이미 방문한 키가 있으면 순환 참조로 판단
            if (visited.contains(key)) return null;
            
            // 이미 해결된 값이 있으면 반환
            if (map.get(key) == null || !map.get(key).contains("{")) return map.getOrDefault(key, "");
            
            visited.add(key);
            
            String value = map.get(key);
            StringBuilder resolved = new StringBuilder();
            int startIdx = 0;
            while ((startIdx = value.indexOf("{", startIdx)) != -1) {
                int endIdx = value.indexOf("}", startIdx);
                if (endIdx == -1) break; // 닫는 중괄호가 없으면 잘못된 입력
                
                String innerKey = value.substring(startIdx + 1, endIdx);
                String innerValue = resolveValue(map, innerKey, visited);
                
                if (innerValue == null) return null; // 순환 참조 발생 시
                resolved.append(value, 0, startIdx).append(innerValue);
                startIdx = endIdx + 1;
            }
            resolved.append(value.substring(startIdx));
            visited.remove(key); // 방문 해제
            
            return resolved.toString();
        }

    }
}