package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1446 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 지름길의 개수
        int D = Integer.parseInt(st.nextToken()); // 고속도로의 길이
        
        int[][] 지름길 = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            지름길[i][0] = Integer.parseInt(st.nextToken()); // 시작 지점
            지름길[i][1] = Integer.parseInt(st.nextToken()); // 도착 지점
            지름길[i][2] = Integer.parseInt(st.nextToken()); // 지름길 거리
        }
        
        // 지름길 정렬: 시작 지점을 기준으로 정렬
        Arrays.sort(지름길, (a, b) -> a[0] - b[0]);
        
        // DP 배열 초기화
        int[] dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i; // 초기값: 순수 직선 거리
        }
        
        // DP 갱신
        int 지름길_인덱스 = 0;
        for (int i = 0; i <= D; i++) {
            // 이전 지점에서 현재 지점으로의 직선 거리 갱신
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            
            // 지름길 반영
            while (지름길_인덱스 < N && 지름길[지름길_인덱스][0] == i) {
                int 시작 = 지름길[지름길_인덱스][0];
                int 끝 = 지름길[지름길_인덱스][1];
                int 거리 = 지름길[지름길_인덱스][2];
                
                if (끝 <= D) {
                    dp[끝] = Math.min(dp[끝], dp[시작] + 거리);
                }
                
                지름길_인덱스++;
            }
        }
        
        // 결과 출력
        System.out.println(dp[D]);
    }
}
