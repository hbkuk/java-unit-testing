package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj1446_3 {
    
    public static void main(String[] args) {
        // TODO 1. 입력 받기
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 지름길의 개수
        int D = scan.nextInt(); // 고속도로의 길이
        
        int[][] paths = new int[N][3]; // [시작 위치, 도착 위치, 지름길의 길이]
        for (int i = 0; i < N; i++) {
            
            int start = scan.nextInt();     // 시작 위치
            int end = scan.nextInt();       // 도착 위치
            int length = scan.nextInt();    // 길이
            
            if (end <= D) { // 고속도로의 길이보다 end가 클 경우 제외
                paths[i][0] = start;
                paths[i][1] = end;
                paths[i][2] = length;
            }
        }
        
        // TODO 2. 오름차순 정렬하기
        Arrays.sort(paths, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] o1, int[] o2) {
                int s1 = o1[0];
                int s2 = o2[0];
                if (s1 != s2) {
                    return s1 - s2;
                }
                
                int e1 = o1[1];
                int e2 = o2[1];
                if (e1 != e2) {
                    return e1 - e2;
                }
                
                return o1[2] - o2[2];
            }
            
            ;
        });
        
        int[] dp = new int[D + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= D; i++) {
            dp[i] = i;
        }
        
        // TODO 3. 지름길 리스트를 순회 -> DP 갱신
        for (int[] path : paths) {
            int start = path[0];
            int end = path[1];
            int length = path[2];
            
            int existingLength = dp[end];
            int newLength = dp[start] + length;
            
            // 기존 값이 더 클 경우
            if (existingLength > newLength) {
                dp[end] = newLength;
                
                // end + 1부터 D까지 갱신
                for (int k = end + 1; k <= D; k++) {
                    dp[k] = Math.min(dp[k], dp[k - 1] + 1);
                }
            }
        }
        
        System.out.println(dp[D]); // 출력
    }
    
}
