package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1600 {
    
    /**
     * 0 : 평지
     * 1 : 장애물
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int K = scan.nextInt(); // 말처럼 움직일 수 있는 횟수
        int W = scan.nextInt(); // col
        int H = scan.nextInt(); // row
        
        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        
        boolean[][][][] visited = new boolean[H][W][2][K + 1]; // 말처럼 움직인 횟수에 따른 방문
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, K}); // [row, col, distance, remain k]
        visited[0][0][0][K] = true;
        
        int minDistance = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cRow = current[0];      // 현재 row
            int cCol = current[1];      // 현재 col
            int cDistance = current[2]; // 현재 거리
            int cRemainK = current[3];  // 현재 남은 K 수
            
            if (cRow == H - 1 && cCol == W - 1) {
                minDistance = Math.min(minDistance, cDistance);
                continue;
            }
            
            int[] dRow = {-1, 1, 0, 0};
            int[] dCol = {0, 0, -1, 1};
            for(int i = 0; i < 4; i++) {
                int nRow = cRow + dRow[i];
                int nCol = cCol + dCol[i];
                
                // Map 범위 && 방문하지 않았는지 && 장애물이 아닌지
                if(nRow >= 0 && nRow <= H - 1 && nCol >= 0 && nCol <= W - 1 &&
                    !visited[nRow][nCol][0][cRemainK] && map[nRow][nCol] == 0) {
                    visited[nRow][nCol][0][cRemainK] = true;
                    queue.offer(new int[]{nRow, nCol, cDistance + 1, cRemainK});
                }
            }
            
            int[] dJRow = {-1, -2, -1, -2, 1, 2, 1, 2};
            int[] dJCol = {-2, -1, 2, 1, 2, 1, -2, -1};
            for(int i = 0; i < 8; i++) {
                int nRow = cRow + dJRow[i];
                int nCol = cCol + dJCol[i];
                
                // Map 범위 && 방문하지 않았는지 && 장애물이 아닌지 && 점프 여부가 0보다 큰지
                if(nRow >= 0 && nRow <= H - 1 && nCol >= 0 && nCol <= W - 1 &&
                    !visited[nRow][nCol][1][cRemainK] && map[nRow][nCol] == 0 && cRemainK > 0) {
                    visited[nRow][nCol][1][cRemainK] = true;
                    queue.offer(new int[]{nRow, nCol, cDistance + 1, cRemainK - 1});
                }
            }
        }
        
        if (minDistance == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDistance);
        }
    }
}
