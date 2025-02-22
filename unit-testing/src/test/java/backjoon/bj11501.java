package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11501 {
    
    /**
     *  뒤에서부터 최고 값을 갱신하면서... 이익 확인하기
     *
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken()); // 테스트케이스 수
        
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken()); // 날짜
            int[] 주가 = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                주가[j] = Integer.parseInt(st.nextToken());
            }
            
            // 주가를 뒤에서부터 순회하면서... 이익 계산해보기
            long 총_이익 = 0;
            int 최고점 = 0;
            for(int j = N - 1; j >= 0; j--) {
                if(주가[j] > 최고점) { // 최고점 갱신
                    최고점 = 주가[j];
                } else {
                    총_이익 += (최고점 - 주가[j]);
                }
            }
            
            System.out.println(총_이익);
        }
    }
    
}
