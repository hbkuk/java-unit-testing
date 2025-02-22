package backjoon;

import java.util.Scanner;

public class bj1463 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int X = scan.nextInt();
        
        int[] dp = new int[X + 1];
        dp[0] = 0;
        dp[1] = 0;
        
        // 1부터 X까지 dp 배열을 활용해서 수를 만든다.
        for(int i = 2; i <= X; i++) {
            // 1 빼기
            dp[i] = dp[i - 1] + 1;
            
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        
        
        System.out.println(dp[X]);
    }
}
