package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj13549 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 수빈 위치
        int K = scan.nextInt(); // 동생 위치
        
        // <상황>
        // - 초기 수빈이가 100,000인 위치를 고려해서 200,001
        int[] dp = new int[200_001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[N] = 0; // 초기 설정
        dp[N - 1] = 1;
        dp[N + 1] = 1;
        dp[N * 2] = 0;
        
        // <상황>
        
        // 동생 ----- 수빈 -> dp 좌측으로 갱신..
        if(K < N) {
            
            for(int start = N - 1; start >= K; start--) {
                dp[start] = Math.min(dp[start], dp[start + 1] + 1); // 전 시간보다 1초 증가.
                
                int 이전_순간이동_거리 = start * 2; // 이전 두배인 거리
                dp[start] = Math.min(dp[start], dp[이전_순간이동_거리]); // 순간이동 전보다 1초 증가
                
                int 현재보다_2배_거리 = start * 2;
                dp[현재보다_2배_거리] = dp[start] + 1;
            }
            
        // 수빈 ----- 동생 -> dp 우측으로 갱신..
        } else if (K > N) {
            
            for(int start = N + 1; start <= K; start++) {
                dp[start] = Math.min(dp[start], dp[start - 1] + 1); // 전 시간보다 1초 증가.
                
                boolean 이전_순간이동_가능_여부 = start % 2 == 0;
                int 이전_순간이동_거리 = start / 2;
                if(이전_순간이동_가능_여부) {
                    dp[start] = Math.min(dp[start], dp[이전_순간이동_거리]); // 순간이동 전보다 1초 증가
                }
                
                int 현재보다_2배_거리 = start * 2;
                dp[현재보다_2배_거리] = dp[start] + 1;
            }
            
        }
        
        int 가장_작은_거리 = dp[K];
        가장_작은_거리 = Math.min(가장_작은_거리, dp[K - 1] + 1);
        가장_작은_거리 = Math.min(가장_작은_거리, dp[K + 1] + 1);
        가장_작은_거리 = Math.min(가장_작은_거리, dp[2 * K]);
        
        System.out.println(가장_작은_거리);
        
    }
    
}
