package backjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj13549_2 {
    
    /**
     * <BFS 풀기>
     * <p>
     * 수빈이 이동 가능한 경우의 수
     * - 1s 소모 -> (X - 1)
     * - 1s 소모 -> (X + 1)
     * - os 소모 -> (2 * X)
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 수빈 위치
        int K = scan.nextInt(); // 동생 위치
        
        Deque<int[]> queue = new LinkedList<>(); // [위치, 시간]
        boolean[][] visited = new boolean[2][100_001];
        
        queue.offer(new int[]{N, 0});
        visited[0][N] = true;
        
        while (!queue.isEmpty()) {
            
            int[] current = queue.poll();
            int cP = current[0];            // 현재 위치
            int cT = current[1];            // 현재 시간
            
            if(cP == K) {
                System.out.println(cT);
                return;
            }
            
            int[] dP = {1, -1};
            for(int i = 0; i < 2; i++) {
                int nP = cP + dP[i];
                int nT = cT + 1;
                
                if(nP >= 0 && nP <= 100_000 && !visited[0][nP]) {
                    visited[0][nP] = true;
                    queue.offer(new int[]{nP, nT});
                }
            }
            
            {
                int nP = cP * 2;
                int nT = cT;
                
                if(nP >= 0 && nP <= 100_000 && !visited[1][nP]) {
                    visited[1][nP] = true;
                    queue.offerFirst(new int[]{nP, nT});
                }
            }
        }
    }
    
}
