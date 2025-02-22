package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj14940 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        int M = scan.nextInt();
        
        int[] finishPoint = new int[2]; // 목표 지점
        int[][] map = new int[N][M]; // 지도
        int[][] result = new int[N][M]; // 결과
        boolean[][] visited = new boolean[N][M]; // 방문 여부
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int value = scan.nextInt();
                map[i][j] = value;
                
                if(value == 2) {
                    finishPoint[0] = i;
                    finishPoint[1] = j;
                } else if(value == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = -1;
                }
            }
            scan.nextLine();
        }
        
        bfs(finishPoint, map, visited, result, 0);
        
        // TODO: 지도 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(result[i][j]).append(" ");
            }
            
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    private static void bfs(int[] startPoint, int[][] map, boolean[][] visited, int[][] result, int depth) {
        // 4방향 설정
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        int cr = startPoint[0]; // 현재 row 좌표
        int cc = startPoint[1]; // 현재 col 좌표
        
        // 자신 결과 반영
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(startPoint); // 큐에 넣기
        
        result[cr][cc] = depth; // 결과 반영
        visited[cr][cc] = true; // 방문 표시
        
        // 큐가 비어있을 때까지 반복
        while(!queue.isEmpty()) {
            
            int[] current = queue.poll(); // 큐에서 좌표 꺼내기
            cr = current[0];
            cc = current[1];
            
            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i]; // 다음 방문 좌표
                int nc = cc + dc[i]; // 다음 방문 좌표
                
                // 다음 방문을 위한 사전 확인
                if(nr >= 0 && nr < map.length &&
                    nc >= 0 && nc < map[0].length &&
                    map[nr][nc] != 0 &&
                    !visited[nr][nc]
                ) {
                    queue.offer(new int[]{nr, nc}); // 큐에 새 좌표 추가
                    visited[nr][nc] = true; // 방문 표시
                    result[nr][nc] = result[cr][cc] + 1; // 거리를 1 증가시킴
                }
            }
        }
    }
    
}
