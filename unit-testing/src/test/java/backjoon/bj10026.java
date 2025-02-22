package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj10026 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int N = Integer.parseInt(scan.nextLine()); // 줄 수
        
        int[][] map1 = new int[N][N]; // 정상인 기준 (0: R, 1: G, 2: B)
        boolean[][] visited1 = new boolean[N][N];
        
        int[][] map2 = new int[N][N]; // 적록색약 기준 (0: R-G, 1: B)
        boolean[][] visited2 = new boolean[N][N];
        
        
        for (int i = 0; i < N; i++) {
            char[] chars = scan.nextLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (chars[j] == 'R') {
                    map1[i][j] = 0;
                    map2[i][j] = 0;
                } else if (chars[j] == 'G') {
                    map1[i][j] = 1;
                    map2[i][j] = 0;
                } else {
                    map1[i][j] = 2;
                    map2[i][j] = 1;
                }
            }
        }
        
        // 정상인 기준
        int 정상인_기준_구역_수 = 0;
        
        // map 전체를 순회하면서 하나씩 bfs를 진행한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    bfs(map1, visited1, i, j);
                    정상인_기준_구역_수++;
                }
            }
        }
        
        // 적록색약 기준으로
        int 적록색약_기준_구역_수 = 0;
        // map 전체를 순회하면서 하나씩 bfs를 진행한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited2[i][j]) {
                    bfs(map2, visited2, i, j);
                    적록색약_기준_구역_수++;
                }
            }
        }
        
        System.out.println(정상인_기준_구역_수 + " " + 적록색약_기준_구역_수);
    }
    
    public static void bfs(int[][] map, boolean[][] visited, int row, int col) {
        // 현재 위치를 꺼내서, 상,하,좌,우 로 이동하면서 같은 색상을 모두 체크한다.
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        
        // 방문 체크
        visited[row][col] = true;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        // Queue가 비어있을 때까지 반복
        while(!queue.isEmpty()) {
            // 현재 위치
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            
            // 다음 위치
            for(int i = 0; i < 4; i++) {
                
                int nextRow = currentRow + dr[i];
                int nextCol = currentCol + dc[i];
                
                // 맵 범위 안에 있는지, 방문하지 않았는지, RGB 값이 동일한 값인지
                if(
                    nextRow >= 0 && nextRow < map.length &&
                    nextCol >= 0 && nextCol < map[0].length &&
                    !visited[nextRow][nextCol] && map[currentRow][currentCol] == map[nextRow][nextCol]
                ) {
                    // 방문 체크
                    visited[nextRow][nextCol] = true;
                    // 큐에 넣기
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
            
        }
    }
}
