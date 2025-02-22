package backjoon;

import java.util.Scanner;

public class bj2156 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = Integer.parseInt(scan.nextLine()); // 포도주 잔
        
        int[] dp = new int[N + 1];
        
        int[] glasses = new int[N + 1]; // 포도주 양
        for (int i = 1; i <= N; i++) {
            glasses[i] = Integer.parseInt(scan.nextLine());
        }
        
        if (N == 1) {
            System.out.println(glasses[1]);
            return;
        }
        
        dp[1] = glasses[1]; // 첫 번째 잔은 그냥 마시기
        if (N >= 2) {
            dp[2] = glasses[1] + glasses[2];
        }
        
        // DP 점화식
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + glasses[i], dp[i - 3] + glasses[i - 1] + glasses[i]));
        }
        
        System.out.println(dp[N]);
    }
    
}
