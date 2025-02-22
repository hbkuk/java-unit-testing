package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj2839 {
    
    /**
     * 봉지 개수를 최소화한, [N] kg 설탕 배달
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt(); // 배달해야하는 설탕의 [N] kg
        
        int[] dp = new int[N + 1]; // 0번 인덱스 제외, N + 1 만큼 공간 할당
        Arrays.fill(dp, N); // 최댓 값으로 채우기
        
        dp[0] = 0;
        for(int i = 3; i <= N; i++) {
            // 3으로 나누어질 경우
            if(i >= 3) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
            if(i >= 5) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }
        
        if(dp[N] == N) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}