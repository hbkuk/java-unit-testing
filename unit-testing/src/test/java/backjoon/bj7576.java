package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj7576 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int M = scanner.nextInt(); // 가로 칸 수
        int N = scanner.nextInt(); // 세로 칸 수
        
        int[][] map = new int[N][M]; // 토마토 농장
        boolean[][] visited = new boolean[N][M]; // 방문 여부
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
                
                // 익은 토마토일 경우, 큐에 넣기
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0}); // 날짜 0부터 시작
                    visited[i][j] = true; // 방문 처리
                }
            }
        }
        
        int day = 0; // 최소 날짜 저장 변수
        
        // BFS 실행
        while (!queue.isEmpty()) {
            int[] dr = {-1, 1, 0, 0}; // 상하좌우 이동
            int[] dc = {0, 0, -1, 1};
            
            int[] current = queue.poll(); // 큐에서 현재 좌표와 날짜 꺼내기
            int cr = current[0]; // 현재 행
            int cc = current[1]; // 현재 열
            int cDay = current[2]; // 현재 날짜
            
            day = Math.max(day, cDay); // 최대 날짜 갱신
            
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i]; // 다음 행
                int nc = cc + dc[i]; // 다음 열
                
                // 유효한 범위 내에서 아직 익지 않은 토마토일 경우
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0 && !visited[nr][nc]) {
                    map[nr][nc] = 1; // 토마토를 익힘
                    visited[nr][nc] = true; // 방문 처리
                    queue.offer(new int[]{nr, nc, cDay + 1}); // 다음 날짜로 큐에 추가
                }
            }
        }
        
        // 익지 않은 토마토가 남아 있는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { // 익지 않은 토마토가 있으면
                    System.out.println(-1); // -1 출력
                    return;
                }
            }
        }
        
        // 모든 토마토가 익었으면 최대 날짜 출력
        System.out.println(day);
    }
}
