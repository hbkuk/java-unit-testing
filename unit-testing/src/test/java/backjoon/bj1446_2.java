package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj1446_2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 지름길의 개수
        int D = scan.nextInt(); // 고속도로의 길이
        scan.nextLine();
        
        int[][] 지름길_목록 = new int[N][3];
        for(int i = 0; i < N; i++) {
            int S = scan.nextInt(); // 시작 위치
            int E = scan.nextInt(); // 도착 위치
            int distance = scan.nextInt(); // 지름길의 길이
            
            지름길_목록[i][0] = S;
            지름길_목록[i][1] = E;
            지름길_목록[i][2] = distance;
        }
        scan.close();
        
        Arrays.sort(지름길_목록, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if( o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        
        int[] dp = new int[D + 1];
        for(int i = 1; i <= D; i++) {
            dp[i] = i;
        }
        
        for(int i = 0; i < N; i++) {
            int 시작_위치 = 지름길_목록[i][0];
            int 도착_위치 = 지름길_목록[i][1];
            int 지름길_거리 = 지름길_목록[i][2];
            
            // 지름길 조건 확인
            if (시작_위치 >= 도착_위치 || 도착_위치 > D) {
                continue;
            }
            
            dp[도착_위치] = Math.min(dp[도착_위치], dp[시작_위치] + 지름길_거리);
        }
        
        for(int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }
        
        System.out.println(dp[D]);
    }
    
}