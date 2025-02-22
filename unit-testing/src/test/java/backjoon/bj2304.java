package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj2304 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 기둥의 개수
        int[][] posts = new int[N][2]; // [왼쪽면 위치, 정수 높이)
        for(int i = 0; i < N; i++) {
            posts[i][0] = Integer.parseInt(st.nextToken()); // 왼쪽면 위치
            posts[i][1] = Integer.parseInt(st.nextToken()); // 기둥 높이
        }
        
        Arrays.sort(posts, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; // 왼쪽면 위치 오름 차순 정렬
            }
        });
        
        int area = 0;
        
        for(int i = 0; i < N; i++) {
            int currentHeight = posts[i][1]; // 현재 높이
            int nextHeight = posts[i + 1][1]; // 다음 높이
            
            if(currentHeight > nextHeight) { // 현재 높이가 더 큰 경우..
                // TODO: 그 다음 위치까지 확인 필요
            } else if(currentHeight < nextHeight) { // 다음 높이가 더 큰 경우
                // TODO: 다음 왼쪽면 위치까지 계산
            }
        }
        
        System.out.println(area);
    }
}
