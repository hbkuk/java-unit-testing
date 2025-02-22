package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj17836 {
    
    /**
     * 용사는 [0, 0]에서 [N - 1, M - 1] 위치까지 도달해야 함.
     * T 시간 이내로 도달 해야함.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // row
        int M = scan.nextInt(); // col
        int T = scan.nextInt(); // 제한 시간
        
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        
        boolean[][][] visited = new boolean[N][M][2]; // [row][col][그람 여부]
        
        Queue<int[]> queue = new LinkedList<>();
        if (map[0][0] == 2) {
            queue.offer(new int[]{0, 0, 0, 1});
            visited[0][0][1] = true;
        } else {
            queue.offer(new int[]{0, 0, 0, 0});
            visited[0][0][0] = true;
        }
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cRow = current[0]; // 현재 row
            int cCol = current[1]; // 현재 col
            int cTime = current[2]; // 현재 시간
            int cGetG = current[3]; // 현재 그람 획득 여부
            
            // 공주가 돌로 변했는지 확인
            if(cTime > T) {
                return;
            }
            
            // 용사가 공주에게 도착했는지 확인
            if(cRow == N - 1 && cCol == M - 1) {
                System.out.println(cTime);
                return;
            }

            int[] dRow = {-1, 1, 0, 0};
            int[] dCol = {0, 0, -1, 1};
            
            for(int i = 0; i < 4; i++) {
                int nRow = cRow + dRow[i];
                int nCol = cCol + dCol[i];
                
                // Map 여부 인지, 이미 방문하지는 않았는지
                if(nRow >= 0 && nRow <= N - 1 && nCol >= 0 && nCol <= M - 1 && !visited[nRow][nCol][cGetG]) {
                    
                    // 다음 위치가 벽이 아닌 경우
                    if(map[nRow][nCol] == 0) {
                        visited[nRow][nCol][cGetG] = true;
                        queue.offer(new int[]{nRow, nCol, cTime + 1, cGetG});
                        
                    // 다음 위치가 벽인 경우
                    } else if(map[nRow][nCol] == 1) {
                        if(cGetG == 1) {
                            visited[nRow][nCol][cGetG] = true;
                            queue.offer(new int[]{nRow, nCol, cTime + 1, cGetG});
                        }
                        
                    // 다음 위치가 그람인 경우
                    } else {
                        visited[nRow][nCol][cGetG] = true;
                        queue.offer(new int[]{nRow, nCol, cTime + 1, 1});
                    }
                }
            }
        }
        
        System.out.println("Fail");
    }
    
}
