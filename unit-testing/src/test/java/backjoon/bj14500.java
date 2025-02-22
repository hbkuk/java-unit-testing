package backjoon;

import java.util.*;

public class bj14500 {
    
    static int N;
    static int M;
    
    static int[][] map;
    static boolean[][] visited;
    
    static int maxValue = 0;
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt(); // row
        M = scan.nextInt(); // col
        
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        
        visited = new boolean[N][M];
        
        // DFS + 백트래킹
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                
                visited[i][j] = true;
                
                dfs(i, j, map[i][j], 1);
                
                visited[i][j] = false;
            }
        }
        
        System.out.println(maxValue);
    }
    
    public static void dfs(int cr, int cc, int value, int depth) {
        
        // 테트로미노가 완성된 경우 종료
        if(depth == 4) {
            maxValue = Math.max(maxValue, value);
            return;
        }
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        
        // TODO: 테트로미노 만들기
        for(int i = 0; i < 4; i++) {
            int nr = cr + dr[i];
            int nc = cc + dc[i];
            
            if(nr >= 0 && nr <= N - 1 && nc >= 0 && nc <= M - 1 && !visited[nr][nc]) {
                
                visited[nr][nc] = true;
                
                dfs(nr, nc, value + map[nr][nc], depth + 1);
                
                visited[nr][nc] = false; // 백트래킹
                
                // 뻐큐 만들기
                if(depth == 2) {
                    visited[nr][nc] = true;
                    
                    dfs(cr, cc, value + map[nr][nc], depth + 1);
                    
                    visited[nr][nc] = false; // 백트래킹
                }
            }
        }
    }
    
}
