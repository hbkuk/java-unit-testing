package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj2468 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 2차원 배열의 행과 열 개수
        
        int[][] map = new int[N][N]; // Map
        int maxHeight = 0; // 지도의 최고 높이
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int height = scan.nextInt();
                map[i][j] = height;
                maxHeight = Math.max(maxHeight, height);
            }
        }
        
        int maxSafeZones = 0; // 안전한 영역의 최대 개수
        
        for(int h = 0; h <= maxHeight; h++) {
            boolean[][] visited = new boolean[N][N];
            int sectionCount = 0;
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    // 방문하지 않았으면서, 물에 잠기지 않는 높이인 경우
                    if(!visited[i][j] && map[i][j] > h) {
                        bfs(map, visited, i, j, h);
                        sectionCount++;
                    }
                }
            }
            
            maxSafeZones = Math.max(maxSafeZones, sectionCount);
        }
        

        
        System.out.println(maxSafeZones);
    }
    
    private static void bfs(int[][] map, boolean[][] visited, int i, int j, int n) {
        // Queue에 담기
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        
        while(!queue.isEmpty()) {
            
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            
            for(int k = 0; k < 4; k++) {
                
                int nextRow = currentRow + dr[k];
                int nextCol = currentCol + dc[k];
                
                // 방문하지 않았으면서, 맵 범위 안에 있으면서, 물에 잠기지 않는 높이인 경우
                if(
                    nextRow >= 0 && nextRow < map.length &&
                    nextCol >= 0 && nextCol < map[0].length &&
                    !visited[nextRow][nextCol] && map[nextRow][nextCol] > n
                ) {
                    queue.offer(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
                
            }
            
        }
    }
}
