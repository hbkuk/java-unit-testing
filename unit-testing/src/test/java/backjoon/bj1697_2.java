package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1697_2 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 수빈 위치
        int K = scan.nextInt(); // 동생 위치
        
        int time = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100_001];
        
        // 수빈과 동생이 같이 있는 경우
        if(N == K) {
            System.out.println(time);
            return;
        }
        // 동생 ---- 수빈
        else {
            queue.offer(new int[]{N + 1, time + 1});
            visited[N + 1] = true;
            
            queue.offer(new int[]{N * 2, time + 1});
            visited[N * 2] = true;
            
            queue.offer(new int[]{N - 1, time + 1});
            visited[N - 1] = true;
        }
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            int cp = current[0]; // 현재 위치
            int cT = current[1]; // 현재 시간
            
            if(cp == K) {
                System.out.println(cT);
                return;
            }
            else {
                if(!visited[cp + 1] && cp + 1 <= 100_000) {
                    queue.offer(new int[]{cp + 1, cT + 1});
                }
                if(!visited[cp * 2] && cp * 2 <= 100_000) {
                    queue.offer(new int[]{cp * 2, cT + 1});
                }
                if(!visited[cp - 1] && cp - 1 <= 100_000) {
                    queue.offer(new int[]{cp - 1, cT + 1});
                }
            }
        }
    }
    
}
