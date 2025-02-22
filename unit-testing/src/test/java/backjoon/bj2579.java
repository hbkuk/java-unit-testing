package backjoon;

import java.util.Scanner;

public class bj2579 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int stairCount = scan.nextInt(); // 계단 개수
        scan.nextLine();
        
        int[] dp = new int[stairCount + 1]; // dp 배열
        
        int[] score = new int[stairCount + 1]; // 계단 점수
        for(int i = 1; i < score.length; i++) {
            score[i] = Integer.parseInt(scan.nextLine());
        }
        
        for(int i = 1; i < score.length; i++) {
            if(i == 1) {
                dp[1] = score[1];
            } else if(i == 2) {
                dp[2] = score[1] + score[2];
            } else {
                dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
            }
        }
        
        System.out.println(dp[stairCount]); // 최대 값 출력
    }
    
}

