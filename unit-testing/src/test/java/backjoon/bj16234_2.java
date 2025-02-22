package backjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj16234_2 {
    
    static int days = 0;
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 크기
        int L = scan.nextInt(); // 인구수 이상 기준
        int R = scan.nextInt(); // 인구수 이하 기준
        
        int[][] map = new int[N][N]; // Map
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        
        
        // 매일 국경선이 열리고, 닫힌다.
        // 매일 연합이 이루어지고, 인구 이동이 된다.
        while(true) {
            boolean isAssociated = false; // 연합 여부
            
            boolean[][] visited = new boolean[N][N]; // 방문 여부
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    
                    // 방문하지 않은 경우
                    if(!visited[i][j]) {
                        if(bfs(i, j, map, visited, L, R)) {
                            isAssociated = true;
                        }
                    }
                }
            }
            
            
            // 연합이 없을 경우
            if(!isAssociated) {
                break;
            } else {
                days++;
            }
        }
        
        
        System.out.println(days);
    }
    
    private static boolean bfs(int i, int j, int[][] map, boolean[][] visited, int l, int r) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{i, j});
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        
        while(!queue.isEmpty()) {
            int[] dr = {-1, 1, 0, 0}; // 상하 좌우
            int[] dc = {0, 0, -1, 1};
            
            // <반복>
            // 큐에서 꺼내기
            // 4 방향으로 탐색하기
            //   Map 내부 범위 && 방문 X && l 이상 && r 이하 => 연합 가능
            
            int[] c = queue.poll();
            int cr = c[0];
            int cc = c[1];
            
            for(int k = 0; k < 4; k++) {
                
                int nr = cr - dr[k];
                int nc = cc - dc[k];
                
                if(nr >= 0 && nr <= map.length -1 &&
                    nc >= 0 && nc <= map[0].length -1 &&
                    !visited[nr][nc] &&
                    Math.abs(map[cr][cc] - map[nr][nc]) >= l && Math.abs(map[cr][cc] - map[nr][nc]) <= r) {
                    
                    visited[nr][nc] = true; // 방문 체크
                    queue.offer(new int[]{nr, nc}); // queue에 넣기
                    list.add(new int[]{nr, nc}); // list에 추가
                    
                }
            }
            
        }
        
        // 인구 이동하기 ->
        int totalCount = 0;
        for(int[] ele : list) {
            totalCount += map[ele[0]][ele[1]];
        }
        
        int eachCount = totalCount / list.size();
        for(int[] ele : list) {
            map[ele[0]][ele[1]] = eachCount;
        }
        
        
        // 연합이 된 경우
        if(list.size() >= 2) {
            return true;
        }
        
        return false;
    }
}
