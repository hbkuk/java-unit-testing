package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj17484 {
    
    static int LEFT = 0;
    static int STREET = 1;
    static int RIGHT = 2;
    static int UNKNOWN = 4;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 세로
        int M = scan.nextInt(); // 가로
        
        int[][] map = new int[N][M]; // 우주선 2차원 경로
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < M; i++) { // 첫라인 큐에 넣기
            queue.offer(new int[]{0, i, UNKNOWN, map[0][i]}); // r, c, 이전위치, 현재 점수
        }
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 정보
            
            int currentRow = current[0];
            int currentCol = current[1];
            int currentDirection = current[2];
            int currentCost = current[3];
            
            // 만약 달에 도착한 경우 minCost 갱신
            if(currentRow == N - 1) {
                minCost = Math.min(minCost, currentCost);
                continue;
            }
            
            // left, street, right
            int[] dc = {-1, 0, 1};
            
            for(int k = 0; k < 3; k++) {
                
                int nr = currentRow + 1;
                int nc = currentCol + dc[k]; // 다음 col 위치
                int nextDirection = k;
                
                // 맵 내부 안에서 돌아다니는지?, 연속된 번호는 아닌지?
                if(nr >= 0 && nr <= N - 1 &&
                    nc >= 0 && nc <= M - 1 && currentDirection != nextDirection) {
                    queue.offer(new int[]{nr, nc, nextDirection, currentCost + map[nr][nc]});
                }
            }
        }
        
        System.out.println(minCost);
    }
    
}
