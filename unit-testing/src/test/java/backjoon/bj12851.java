package backjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj12851 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 수빈 위치
        int K = scan.nextInt(); // 동생 위치
        
        Deque<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100_001];
        
        queue.offer(new int[]{N, 0});
        visited[N] = true;
        
        int minTime = Integer.MAX_VALUE; // 가장 빠른 시간
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cp = current[0]; // 위치
            int cT = current[1]; // 시간
            
            // 해당 노드가 동생에게 도착한 경우
            if(cp == K) {
                minTime = Math.min(minTime, cT);
                continue;
            }
            
            {
                int np = cp * 2;
                int nT = cT;
                
                if(np >= 0 && np <= 100_000 && !visited[np]) {
                    visited[np] = true;
                    queue.offerFirst(new int[]{np, nT});
                }
            }
            
            
            int[] dp = {1, -1};
            for(int i = 0; i < 2; i++) {
                int np = cp + dp[i];
                int nT = cT + 1;
                
                if(np >= 0 && np <= 100_000 && !visited[np]) {
                    visited[np] = true;
                    queue.offer(new int[]{np, nT});
                }
            }
        }
        
        System.out.println(minTime);
    }
}
