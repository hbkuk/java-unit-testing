package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj19637 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 칭호의 개수
        int M = Integer.parseInt(st.nextToken());// 칭호를 출력해야 하는 캐릭터들의 개수
        
        String[] rankName = new String[N]; // 칭호명
        int[] rankRange = new int[N]; // 칭호 상한값
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            rankName[i] = st.nextToken();
            rankRange[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        
        
        int[] input = new int[M]; // 전투력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            input[i] = Integer.parseInt(st.nextToken());
            
            int left = 0;
            int right = rankRange.length - 1;
            int resultIndex = 0; // 모든 전투력에 기본 값 세팅
            
            while(left <= right) {
                int mid = (right + left) / 2;
                
                if(input[i] > rankRange[mid]) { // 전투력이 더 큰 경우
                  left = mid + 1;
                } else { // 찾은 경우
                    resultIndex = mid;
                    right = mid - 1;
                }
            }
            
            sb.append(rankName[resultIndex])
                .append("\n");
        }
        
        br.close();
        
        
        System.out.println(sb);
    }
    
}