package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1012 {
    
    /**
     * 최소의 배추흰지렁이 마리 수를 출력
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = Integer.parseInt(scan.nextLine()); // 테스트 케이스
        
        for(int i = 0; i < T; i++) {
            
            int answer = 0;
            
            int M = scan.nextInt(); // 배추밭 가로 길이
            int N = scan.nextInt(); // 배추밭 세로 길이
            int K = scan.nextInt(); // 배추 개수
            scan.nextLine();
            
            boolean[][] map = new boolean[M][N]; // 배추밭
            boolean[][] visited = new boolean[M][N]; // 방문 여부
            
            for(int j = 0; j < K; j++) {
                int rPos = scan.nextInt();
                int cPos = scan.nextInt();
                scan.nextLine();
                
                map[rPos][cPos] = true;
            }
            
            // dfs(깊이 우선 탐색으로)
            for(int k = 0; k < M; k++) {
                for(int v = 0; v < N; v++) {
                    // 배추이거나 && 방문하지 않았을 경우 => 지렁이 출발
                    if(map[k][v] && !visited[k][v]) {
                        answer ++;
                        dfs(k, v, map, visited); // 방문할 수 있는 부분까지 다 방문하고 오기
                    }
                }
            }
            
            System.out.println(answer);
        }
        
    }
    
    private static void dfs(int rPos, int cPos, boolean[][] map, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{rPos, cPos}); // 자신 큐에 추가
        visited[rPos][cPos] = true; // 자신 방문 처리
        
        // 방향 설정(상 하 좌 우)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        // 큐가 비어있을 때까지 방문
        while(!queue.isEmpty()) {
            int[] c = queue.poll(); // 큐에서 꺼냄
            
            // 4 방향 탐색
            for(int i = 0; i < 4; i++) {
                int nr = c[0] + dr[i];
                int nc = c[1] + dc[i];
                
                // map 내부이거나, 배추거나, 방문하지 않았거나
                if(nr >= 0 && nr < map.length &&
                    nc >= 0 && nc < map[0].length &&
                    map[nr][nc] && 
                    !visited[nr][nc])  {
                    
                    queue.offer(new int[]{nr, nc}); // 큐에 넣기
                    visited[nr][nc] = true; // 자신 방문 처리
                }
            }
        }
    }
    
}
