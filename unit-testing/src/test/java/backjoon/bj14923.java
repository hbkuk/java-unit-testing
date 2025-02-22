package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj14923 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // row
        int M = scan.nextInt(); // col
        
        int startRow = scan.nextInt() - 1; // 시작 row 위치
        int startCol = scan.nextInt() - 1; // 시작 col 위치
        
        int endRow = scan.nextInt() - 1; // 도착 row 위치
        int endCol = scan.nextInt() - 1; // 도착 col 위치
        
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        
        boolean[][][] visited = new boolean[2][N][M]; // 지팡이 사용 여부에 따른 방문 배열
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0, 0});
        
        while(!queue.isEmpty()) {
            
            int[] current = queue.poll();
            int cRow = current[0];      // 현재 row 위치
            int cCol = current[1];      // 현재 col 위치
            int cDt = current[2];       // 현재까지 거리
            int cBWall = current[3];    // 지팡이 사용 여부
            
            if(cRow == endRow && cCol == endCol) {
                System.out.println(cDt);
                return;
            }
            
            int[] dRow = {-1, 1, 0, 0}; // 상 하 좌 우
            int[] dCol = {0, 0, -1, 1};
            
            for(int i = 0; i < 4; i++) {
                int nRow = cRow + dRow[i];
                int nCol = cCol + dCol[i];
                
                // Map 범위 확인
                if(nRow >= 0 && nRow <= N - 1 && nCol >= 0 && nCol <= M - 1) {
                    
                    // 벽이 아닌 경우 && 방문하지 않았을 경우(기존 벽 부순 상태 여부에 따라 달라짐)
                    if(map[nRow][nCol] == 0 && !visited[cBWall][nRow][nCol]) {
                        visited[cBWall][nRow][nCol] = true;
                        queue.offer(new int[]{nRow, nCol, cDt + 1, cBWall});
                    }
                    // 벽인 경우
                    else if (map[nRow][nCol] == 1) {
                        
                        // 기존 벽을 부수지 않은 경우와 방문하지 않았을 경우
                        if(cBWall == 0 && !visited[0][nRow][nCol]) {
                            visited[0][nRow][nCol] = true;
                            queue.offer(new int[]{nRow, nCol, cDt + 1, 1});
                        }
                        
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
