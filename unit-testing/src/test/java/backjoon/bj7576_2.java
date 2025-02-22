package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj7576_2 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int M = scan.nextInt(); // 가로 칸 수
        int N = scan.nextInt(); // 세로 칸 수
        
        int[][] tomatoMap = new int[N][M]; // 격자 모양 상자(1: 익은 토마토, 0: 익지 않은, -1: 토마토 없음)
        boolean[][] visited = new boolean[N][M]; // 방문 여부
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                tomatoMap[i][j] = scan.nextInt(); // 토마토 담기
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tomatoMap[i][j] == 1) { // 익은 토마토 Queue 넣기
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true; // 방문 체크
                }
            }
        }
        
        int maxDay = 0;
        
        // Queue에서 꺼낸 후 숙성시키기
        while(!queue.isEmpty()) {
            int[] currentItem = queue.poll(); // 현재 토마토
            
            int currentRow = currentItem[0]; // 가로 위치
            int currentCol = currentItem[1]; // 세로 위치
            int currentDay = currentItem[2]; // 경과 날짜
            
            maxDay = Math.max(maxDay, currentDay); // 최대 경과 날짜 갱신
            
            // 전파 시키기
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            
            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dr[i]; // 다음 방문할 가로 위치
                int nextCol = currentCol + dc[i]; // 다음 방문할 세로 위치
                
                // 방문하지 않았으면서, 맵 범위 안에 있으면서, 익지 않은 토마토인 경우에만 전파시킨다.
                if(
                    nextRow >= 0 && nextRow < N &&
                    nextCol >= 0 && nextCol < M &&
                    tomatoMap[nextRow][nextCol] == 0 &&
                    !visited[nextRow][nextCol]
                ) {
                    tomatoMap[nextRow][nextCol] = 1; // 숙성
                    visited[nextRow][nextCol] = true; // 방문 표시
                    queue.offer(new int[]{nextRow, nextCol, currentDay + 1}); // Queue 넣기
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tomatoMap[i][j] == 0) { // 익지 않은 토타모가 있을 경우
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(maxDay);
    }
}
