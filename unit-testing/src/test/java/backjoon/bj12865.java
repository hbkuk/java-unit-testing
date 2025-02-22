package backjoon;

import java.util.Scanner;

public class bj12865 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 물품의 수
        int K = scan.nextInt(); // 배낭이 버틸 수 있는 최대 무게
        
        int[] weights = new int[N + 1]; // 각 물품의 무게
        int[] values = new int[N + 1]; // 각 물품의 가치
        
        // 물품 정보 입력
        for(int i = 1; i <= N; i++) {
            weights[i] = scan.nextInt();
            values[i] = scan.nextInt();
        }
        
        // DP 배열: dp[i][w] i번째 물품까지 고려했을 때 무게 w이하에서의 최대 가치
        int[][] dp = new int[N + 1][K + 1];
        
        // DP 진행
        for(int i = 1; i <= N; i++) { // i번째 물품을 살펴보면서
            for(int w = 1; w <= K; w++) { // 배낭의 무게 W에 대해
                if(weights[i] <= w) { // 현재 물품을 넣을 수 있는 경우
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + values[i]);
                    
                } else { // 현재 물품을 넣을 수 없을 경우
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        // 결과 출력: 배낭에 넣을 수 있는 최대 가치
        System.out.println(dp[N][K]);
    }
    
    public static void main1(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 물품의 수
        int K = scan.nextInt(); // 버틸 수 있는 무게
        scan.nextLine();
        
        int[] dp = new int[K + 1]; // DP 배열
        
        for (int i = 0; i < N; i++) {
            int W = scan.nextInt(); // 무게
            int V = scan.nextInt(); // 가치
            
            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }
        
        System.out.println(dp[K]);
    }
    
}