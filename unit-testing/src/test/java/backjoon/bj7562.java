package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj7562 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = Integer.parseInt(scan.nextLine()); // 테스트 케이스 개수
        
        for (int i = 0; i < T; i++) {
            int l = scan.nextInt(); // 한변의 길이
            
            int sr = scan.nextInt(); // 나이트 현재 row 위치
            int sc = scan.nextInt(); // 나이트 현재 col 위치
            
            int fr = scan.nextInt(); // 나이트 이동 row 위치
            int fc = scan.nextInt(); // 나이트 이동 col 위치
            
            boolean[][] visited = new boolean[l][l];
            
            // 1. 큐에 넣기
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{sr, sc, 0});
            visited[sr][sc] = true; // 시작점 방문 체크
            
            // 2. 큐에 하나씩 꺼내서 이동할 수 있는 곳을 Queue에 좌표 넣기
            //  - 이동하는 row, col 위치인지?
            while (!queue.isEmpty()) {
                int[] polled = queue.poll();
                
                int currentRow = polled[0];
                int currentCol = polled[1];
                int count = polled[2];
                
                if (currentRow == fr && currentCol == fc) {
                    System.out.println(polled[2]);
                    break;
                }
                
                // 순차적으로 큐에 넣기
                int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
                int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
                
                for(int j = 0; j < dr.length; j++) {
                    
                    int nr = currentRow + dr[j];
                    int nc = currentCol + dc[j];
                    
                    if(nr >= 0 && nr < l &&
                        nc >= 0 && nc < l &&
                        !visited[nr][nc]) {
                        visited[nr][nc] = true; // 방문 표시
                        queue.offer(new int[]{nr, nc, count + 1});
                    }
                }
            }
            
            scan.nextLine();
        }
    }
    
}
