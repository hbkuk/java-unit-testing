package backjoon;

import java.util.Scanner;

public class bj11053 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int A = Integer.parseInt(scan.nextLine()); // 수열의 크기
        
        int[] dp = new int[A]; // DP
        
        int[] array = new int[A]; // 수열
        for(int i = 0; i < A; i++) {
            array[i] = scan.nextInt();
            dp[i] = 1; // 수열 길이 초기 값 설정
        }
        
        for(int i = 1; i < A; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        scan.close();
        // dp 배열에서 최댓값 찾기
        int max = 0;
        for (int i = 0; i < A; i++) {
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(max); // 가장 긴 증가하는 부분 수열의 길이 출력
    }
    
}
