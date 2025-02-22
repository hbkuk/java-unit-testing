package backjoon;

import java.util.Scanner;

public class bj1932 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        scan.nextLine();
        
        int[][] array = new int[N][N]; // 배열
        int[][] dp = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                array[i][j] = scan.nextInt();
            }
            scan.nextLine();
        }
        
        // 초기 값 설정
        dp[0][0] = array[0][0];
        
        // DP
        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + array[i][j];
                } else if(j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + array[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + array[i][j], dp[i - 1][j] + array[i][j]);
                }
            }
        }
        
        int maxNumber = 0;
        for (int i = 0; i < N; i++) {
            maxNumber = Math.max(maxNumber, dp[N - 1][i]);
        }
        
        System.out.println(maxNumber);
    }
}
