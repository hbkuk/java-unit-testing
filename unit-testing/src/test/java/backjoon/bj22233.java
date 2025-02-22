package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj22233 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 메모장에 적은 키워드 개수
        int M = Integer.parseInt(st.nextToken()); // 블로그 포스팅 개수
        
        Set<String> 메모장 = new HashSet<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            메모장.add(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            
            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                메모장.remove(word);
            }
            
            sb.append(메모장.size())
                .append("\n");
            
        }
        br.close();
        
        System.out.println(sb);
    }
    
}
