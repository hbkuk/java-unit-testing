package backjoon;

import java.util.Scanner;

public class bj1003 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt(); // 테스트 케이스 개수
        
        int[][] dp = new int[40 + 1][2]; // 0: 0이 호출되는 횟수, 1: 1이 호출되는 횟수
        dp[0][0] = 1;
        dp[0][1] = 0;
        
        dp[1][0] = 0;
        dp[1][1] = 1;
        
        for(int i = 2; i <= 40; i++) {
            int zeroCount = 0;
            int oneCount = 0;
            
            for(int j = i; j >= i - 2; j--) {
                zeroCount += dp[j][0];
                oneCount += dp[j][1];
            }
            
            dp[i][0] = zeroCount;
            dp[i][1] = oneCount;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int number = scan.nextInt();
            
            sb.append(dp[number][0])
                .append(" ")
                .append(dp[number][1])
                .append("\n");
        
            scan.nextLine();
        }
        
        scan.close();
        System.out.println(sb);
    }
    
}
