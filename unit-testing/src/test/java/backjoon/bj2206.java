package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj2206 {
    
    
    // <BFS 풀어보기>
    // 0: 이동 가능
    // 1: 벽 있음
    // [0, 0] -> [N -1, M -1] 까지 최단 거리 찾기
    public static void main(String[] args) {
        // TODO 1. 입력 받기
        // TODO 2. [0, 0]부터 출발하기
        //  - 이동횟수 1부터 시작
        //  - 한 node라도 도착하지 못한 경우 체크 필요 -> -1 출력
        // TODO 3. Queue에 포함되는 node는 [row, col, 이동횟수, 벽 부순여부]
        
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // row
        int M = scan.nextInt(); // col
        scan.nextLine();
        
        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[2][N][M]; // 벽 부순 여부에 따른 Map
        
        for(int i = 0; i < N; i++) {
            String[] values = scan.nextLine().split("");
            for(int k = 0; k < M; k++) {
                map[i][k] = Integer.parseInt(values[k]);
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0, 1, 0}); // 벽 안부숨
        visited[0][0][0] = true; // 방문 표시
        
        // queue 가 비어있을 때 까지 반복
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cRow = current[0];      // 현재 row
            int cCol = current[1];      // 현재 col
            int cCounting = current[2]; // 현재 이동횟수
            int cBWall = current[3];    // 현재 벽 부순 여부
            
            // 도착 여부 확인
            if(cRow == N - 1 && cCol == M - 1) {
                System.out.println(cCounting);
                return;
            }
            
            int[] dRow = {-1, 1, 0, 0}; // 상 하 좌 우
            int[] dCol = {0, 0, -1, 1}; // 상 하 좌 우
            
            for(int i = 0; i < 4; i++) {
                int nRow = cRow + dRow[i];
                int nCol = cCol + dCol[i];
                
                // Map 내부 여부 && 방문하지 않았는지 확인
                if(nRow >= 0 && nRow <= N - 1 &&
                    nCol >= 0 && nCol <= M - 1
                ) {
                    // 이동 가능 여부
                    if(map[nRow][nCol] == 0 && !visited[cBWall][nRow][nCol]) {
                        queue.offer(new int[]{nRow, nCol, cCounting + 1, cBWall});
                        visited[cBWall][nRow][nCol] = true; // 방문 표시
                    }
                    // 이동 불가능 여부
                    else if(map[nRow][nCol] == 1 && cBWall == 0 && !visited[1][nRow][nCol]) {
                        queue.offer(new int[]{nRow, nCol, cCounting + 1, 1});
                        visited[1][nRow][nCol] = true; // 방문 표시
                    }
                }
            }
        }
        
        // 도착하지 못한 경우
        System.out.println(-1);
    }
}
