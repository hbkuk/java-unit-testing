package backjoon;

import java.util.Scanner;

public class bj14501 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = Integer.parseInt(scan.nextLine());
        
        int[][] dp = new int[N + 1][N + 1];
        
        int[][] consulting = new int[N + 1][2];
        for(int i = 1; i <= N; i++) {
            consulting[i][0] = scan.nextInt();
            consulting[i][1]= scan.nextInt();
            
            scan.nextLine();
        }

        for(int i = 1; i <= N; i++) {
            int cDay = i;
            while(N >= cDay) {
                int requiredDays = consulting[cDay][0]; // 상담 일수
                int pay = consulting[cDay][1]; // 상담 보수
                
                for(int j = cDay; j <= N; j++) {
                    dp[i][j] += pay;
                }
                
                cDay += requiredDays;
            }
        }
        
        
        int maxPay = 0;
        for(int i = 1; i <= N; i++) {
            maxPay = Math.max(maxPay, dp[i][N]);
        }
        
        System.out.println(maxPay); // 최대 이익 출력
    }
    
}
