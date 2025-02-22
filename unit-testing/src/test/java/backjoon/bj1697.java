package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1697 {
    
    
    /**
     * BFS 풀기
     * x 위치에서 갈 수 이동할 수 있는 경우의 수 {-1, +1, 2};
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 수빈 위치
        int K = scan.nextInt(); // 동새 위치
        
        int[] answer = new int[2]; // 가장 빠른 시간
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100_000 * 2 + 1]; // K의 최대 값은 100,000 이며, 최대 2배 거리까지 이동 가능
        
        // 초기 수빈 설정
        queue.offer(new int[]{N, 0}); // 큐에 넣기
        visited[N] = true; // 방문 표시
        
        while(!queue.isEmpty()) {
            int[] dd = {-1, 1, 2};
            
            int[] currentPos = queue.poll(); // 현재 위치
            
            if(currentPos[0] == K) {
                answer = currentPos;
                break;
            }
            
            for(int i = 0; i < dd.length; i++) {
                int nextPos = 0;
                if (i < 2) {
                    nextPos += currentPos[0] + dd[i];
                } else {
                    nextPos += currentPos[0] * dd[i];
                }
                
                // 방문 가능 여부 확인
                if(nextPos >= 0 && nextPos <= visited.length - 1 && !visited[nextPos]) {
                    int[] nextPosArray = new int[2];
                    nextPosArray[0] = nextPos;
                    nextPosArray[1] = currentPos[1] + 1;
                    queue.offer(nextPosArray); // 값 넣기
                    visited[nextPos] = true; // 방문 표시
                }
            }
        }
        
        
        System.out.println(answer[1]);
    }
}
