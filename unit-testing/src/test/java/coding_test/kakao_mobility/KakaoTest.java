package coding_test.kakao_mobility;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class KakaoTest {
    
    @Nested
    class 카카오_모빌리티_1번_문제 {
        
        @Test
        void 카카오_모빌리티_1번_테스트() {
            assertEquals(15, 카카오_모빌리티_1번(new int[]{2, 4, 0, 5, 2, 3, 0, 0, 1}));
            assertEquals(12, 카카오_모빌리티_1번(new int[]{1, 0, 1, 2, 1, 3}));
        }
        
        int 카카오_모빌리티_1번(int[] potHole) {
            boolean[] visited = new boolean[potHole.length];
            
            int result = 0;
            for (int i = 0; i < potHole.length; i++) {
                
                // 포트홀이 있으면서 && 방문하지 않은 경우
                if (potHole[i] > 0 && !visited[i]) {
                    result = Math.max(result, bfs(potHole, visited, i));
                }
            }
            
            return result;
        }
        
        private int bfs(int[] potHole, boolean[] visited, int i) {
            Queue<Integer> queue = new LinkedList<>();
            
            // 방문 췌크
            visited[i] = true;
            queue.offer(i);
            
            // 최대 깊이(갱신 필요)
            int maxDepth = potHole[i];
            
            // 연속된 포트홀 개수
            int count = 1;
            
            while (!queue.isEmpty()) {
                int currentIndex = queue.poll();
                
                // 전체 순회
                for (int j = currentIndex + 1; j < potHole.length; j++) {
                    
                    // 방문하지 않았으면서 && 포트홀이 있을 경우
                    if (!visited[j] && potHole[j] > 0) {
                        queue.offer(j);
                        visited[j] = true;
                        maxDepth = Math.max(maxDepth, potHole[j]);
                        count++;
                    } else {
                        break;
                    }
                }
            }
            
            return maxDepth * count;
        }
        
    }
    
    @Nested
    class 카카오_모빌리티_2번_문제 {
        
        @Test
        void 카카오_2번_테스트() throws ParseException {
            assertArrayEquals(new String[]{"11:11:00", "11:11:01", "11:11:10"}, 카카오_모빌리티_2번("11:11:00", "11:11:10"));
            assertArrayEquals(new String[]{"00:00:01", "00:00:02", "00:00:03"}, 카카오_모빌리티_2번("00:00:00", "00:00:03"));
        }
        
        String[] 카카오_모빌리티_2번(String start, String end) throws ParseException {
            // TODO 1) String 타입을 Date 타입으로 변환한다
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            
            Date startDate = dateFormat.parse(start);
            Date endDate = dateFormat.parse(end);
            
            List<String> result = new ArrayList<>();
            
            // TODO 2) Start -> End를 1초씩 증가시키면서, 총 2자리인지 확인한다.
            for (long i = startDate.getTime(); i <= endDate.getTime(); i += 1000) {
                
                String current = dateFormat.format(new Date(i));
                
                Set<Character> set = new HashSet<>();
                for (char c : current.toCharArray()) {
                    if (c != ':') {
                        set.add(c);
                    }
                }
                
                // 2개로 이루어졌는지?
                if (set.size() == 2) {
                    result.add(current);
                }
                
            }
            
            String[] resultArray = new String[result.size()];
            for (int i = 0; i < result.size(); i++) {
                resultArray[i] = result.get(i);
            }
            
            return resultArray;
        }
    }
    
    @Nested
    class 카카오_모빌리티_3번_문제 {
        
        @Test
        void 카카오_모빌리티_3번_테스트() {
            assertEquals(15, 카카오_모빌리티_3번(new int[]{2, 5}, new String[]{"PGP", "M"}));
            assertEquals(19, 카카오_모빌리티_3번(new int[]{3, 2, 4}, new String[]{"MPM", "", "G"}));
            assertEquals(12, 카카오_모빌리티_3번(new int[]{2, 1, 1, 1, 2}, new String[]{"", "PP", "PP", "GM", ""}));
        }
        
        int 카카오_모빌리티_3번(int[] distance, String[] str) {
            int pCount = 0;
            int gCount = 0;
            int mCount = 0;
            
            int pLastIndex = 0;
            int gLastIndex = 0;
            int mLastIndex = 0;
            
            // TODO 1) 최종적으로 가야하는 위치를 확인한다.
            // TODO 2) 쓰레기의 총 개수를 카운트한다.
            for (int i = 0; i < str.length; i++) {
                for (char c : str[i].toCharArray()) {
                    if(c == 'P') {
                        pCount ++;
                        pLastIndex = i;
                    } else if(c == 'G') {
                        gCount ++;
                        gLastIndex = i;
                    } else if(c == 'M') {
                        mCount ++;
                        mLastIndex = i;
                    }
                    
                }
            }
            
            int[] totalDistance = new int[distance.length];
            totalDistance[0] = distance[0];
            for(int i = 1; i < totalDistance.length; i++) {
                totalDistance[i] += totalDistance[ i -1 ] + distance[i];
            }
            
            int pTime = pCount + (totalDistance[pLastIndex] * 2);
            int gTime = gCount + (totalDistance[gLastIndex] * 2);
            int mTime = mCount + (totalDistance[mLastIndex] * 2);
            
            return Math.max(Math.max(pTime, gTime), mTime);
        }
    }
    
}
