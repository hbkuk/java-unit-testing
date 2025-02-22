package backjoon;

import java.util.Scanner;

public class bj2775 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = Integer.parseInt(scan.nextLine()); // 테스트 케이스 수
        
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(scan.nextLine()); // 층 수
            int n = Integer.parseInt(scan.nextLine()); // 호 수
            
            int[][] dp = new int[k][n + 1];
            
            // 0층 거주민 수 넣기
            for(int v = 1; v <= 14; v++) {
                dp[0][v] = dp[0][v - 1];
            }
         
            // 1층 부터 ~
            for(int v = 1; v <= k; v++) {
                // 1호부터 14호 까지 살고 있는 인원 수 체크하기
                for(int j = 1; j <= 14; j++) {
                
                }
            }
            
            System.out.println(dp[k][n]);
        }
    }
}
