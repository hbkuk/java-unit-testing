package backjoon;

import java.util.Scanner;

public class bj1149 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = Integer.parseInt(scan.nextLine()); // 집의 수
        
        int[][] dp = new int[N + 1][3];
        
        int[][] cost = new int[N + 1][3]; // 빨, 초, 파
        
        for(int i = 1; i < cost.length; i++) {
            cost[i][0] = scan.nextInt(); // 빨
            cost[i][1] = scan.nextInt(); // 초
            cost[i][2] = scan.nextInt(); // 파
            
            scan.nextLine();
        }
        
        for(int i = 1; i < cost.length; i++) {
            if(i == 1) {
                dp[i][0] = cost[i][0];
                dp[i][1] = cost[i][1];
                dp[i][2] = cost[i][2];
            } else {
                dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        
        int minCost = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
        System.out.println(minCost);
    }
    
}
