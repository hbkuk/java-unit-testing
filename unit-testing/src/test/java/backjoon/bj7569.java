package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj7569 {
    
    
    /**
     * 1 : 익은 토마토
     * 0 : 익지 않은 토마토
     * -1: 토마토가 없음.
     * 
     * 최소 몇일 걸리는지 일수 출력
     *  - 단, 모두 익지 않은 경우 -1을 출력
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt(); // 가로 칸     수
        int N = scan.nextInt(); // 세로 칸     수
        int H = scan.nextInt(); // 쌓아올려지는 수
        
        // 토마토 Map
        int[][][] map = new int[H][N][M];
        
        // 방문 여부 배열(이미 익은 토마토는 다른 ele에서 방문할 필요가 없으므로)
        boolean[][][] visited = new boolean[H][N][M];
        
        // bfs용 queue
        Queue<int[]> queue = new LinkedList<>(); // [height, row, col, day]
        
        // 토마토가 다 익은 최소 일자
        int day = 0;
        
        // 입력 받기 + 익은 토마토 queue에 넣기
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    int value = scan.nextInt();
                    map[i][j][k] = value;
                    
                    if(value == 1) {
                        queue.offer(new int[]{i, j, k, day});
                        visited[i][j][k] = true;
                    }
                    
                }
            }
        }
        
        while(!queue.isEmpty()) {
            
            int[] current = queue.poll();
            int cH = current[0]; // 현재 높이
            int cR = current[1]; // 현재 세로 
            int cC = current[2]; // 현재 가로
            int cD = current[3]; // 현재 날짜
            
            // day 갱신
            day = cD;
            
            int[] dH = {-1, 1}; // 위 칸, 아래 칸
            int[] dR = {-1, 1, 0, 0}; // 앞, 뒤, 좌, 우
            int[] dC = {0, 0, -1, 1}; // 앞, 뒤, 좌, 우
            
            // 위, 아래 칸으로 전파
            for(int i = 0; i < 2; i++) {
                int nH = cH + dH[i];
                int nR = cR;
                int nC = cC;
                
                // nH이 map 범위 && 방문하지 않은 곳 && 다음 위치가 익지 않은 토마토
                if(nH >= 0 && nH <= H - 1
                    && !visited[nH][nR][nC]
                    && map[nH][nR][nC] == 0) {
                    queue.offer(new int[]{nH, nR, nC, cD + 1});
                    visited[nH][nR][nC] = true; // 방문 표시
                    map[nH][nR][nC] = 1; // 익은 토마토 표시
                }
            }
            
            // 앞, 뒤, 좌, 우 칸으로 전파
            for(int i = 0; i < 4; i++) {
                int nH = cH;
                int nR = cR + dR[i];
                int nC = cC + dC[i];
                
                // nR이 map 범위 && nC가 map 범위 && 방문하지 않은 곳 && 다음 위치가 익지 않은 토마토
                if(nR >= 0 && nR <= N - 1 &&
                    nC >= 0 && nC <= M - 1 &&
                    !visited[nH][nR][nC] &&
                    map[nH][nR][nC] == 0) {
                    queue.offer(new int[]{nH, nR, nC, cD + 1});
                    visited[nH][nR][nC] = true; // 방무 ㄴ표시
                    map[nH][nR][nC] = 1; // 익은 토마토 표시
                }
            }
        }
        
        // 다익었는지 확인.. ->
        boolean isAll = true;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(map[i][j][k] == 0) {
                        isAll = false;
                        break;
                    }
                    
                }
            }
        }
        
        if(isAll) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
        
    }
    
}
