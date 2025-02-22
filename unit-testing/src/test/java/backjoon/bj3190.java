package backjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class bj3190 {
    
    /**
     * <풀이 계획>
     * 1. 입력받기
     *  - boolean[][] Map : 이동할 맵
     *    -> true : 사과 있음
     *    -> false : 사과 없음
     * 2. 지렁이 이동
     *  - [0, 0] 에서 오른쪽으로 이동
     *
     * <이동 규칙>
     *  - 다음 칸이 사과인 경우: 이전 칸이 내 몸이 됨.
     *  - 다음 칸이 사과가 아닌 경우: 이전 칸이 내 몸이 아님.
     *
     *  <종료 규칙>
     *  - 머리가 벽에 부딪힘.
     *  - 머리가 내 몸에 부딪힘.
     *
     *  <고민이 되는 포인트>
     *  - 연체 동물을 코드로 어떻게 표현하지...?
     *    - 가령, [1, 3]에서 머리가 오른쪽으로 돌아간 경우 라면?
     *      - 머리쪽은 다음 행선지가 [2, 3] 인데,
     *      - 그 외에는 다음 행선지가 아직은 오른쪽인데?
     */
//    static int[] dr = {-1, 1, 0, 0}; // 상(0), 하(1), 좌(2), 우(3)
//    static int[] dc = {0, 0, -1, 1};
    
    static int[] dr = {-1, 0, 1, 0}; // 상(0), 우(1), 하(2), 좌(3)
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 보드의 크기
        boolean[][] map = new boolean[N][N]; // Map
        
        int K = scan.nextInt(); // 전체 사과의 개수
        for(int i = 0; i < K; i++) {
            int r = scan.nextInt();
            int c = scan.nextInt();
            
            map[r - 1][c - 1] = true; // 사과 표시
        }
        
        int L = scan.nextInt(); // 뱀의 방향 정보 개수
        
        Map<Integer, String> directionInfo = new HashMap<>(); // 뱀 방향 정보
        for(int i = 0; i < L; i++) {
            int time = scan.nextInt();
            String direction = scan.nextLine().trim();
            
            directionInfo.put(time, direction);
        }
        
        // 뱀 이동 시작
        int time = 0;
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1}); // [row, col, 방향]
        
        while(true) {
            time ++; // 시간 증가
            
            // 머리 부분이 벽을 만났는지? or 자신을 만났는지?
            //  - true -> 게임 종료
            int[] current = queue.pollFirst();
            int cRow = current[0];
            int cCol = current[1];
            int cDirection = current[2];
            
            if(cRow < 0 || cCol < 0 || cRow > N - 1 || cCol > N - 1) {
                break;
            }
            for(int[] ele: queue) {
                if(ele[0] == cRow && ele[1] == cCol) {
                    break;
                }
            }
            
            // 머리 확인한 것 다시 넣기
            queue.offerFirst(new int[]{cRow, cCol, cDirection});
            
            
            // 혹시 사과를 먹었는지?
            //  - true -> 꼬리 부분 유지
            //  - false -> 꼬리 부분 자름
            if(!map[cRow][cCol]) {
                queue.pollLast();
            }
            
            // 다음 위치 이동
            //  - 방향 전환을 해야하는지?
            String s = directionInfo.get(time);
            if(s != null && !s.isBlank()) {
                int nextDirection;
                
                // 좌로 90도 이동
                if(s.equals("L")) {
                    // 현재 위치에서 ... -1방향으로..
                    // 만약 cDirection이 0일 경우.. 첫번쨰 인덱스인데? -> -1할 경우 3으로 가야함..
                    nextDirection = ((cDirection + 3) % 4);
                    
                    queue.offerFirst(new int[]{cRow + dr[nextDirection], cCol + dc[nextDirection], nextDirection});
                // 우로 90도 이동
                } else {
                    // 현재 위치에서 ... +1방향으로..
                    nextDirection = ((cDirection + 1) % 4);
                    queue.offerFirst(new int[]{cRow + dr[nextDirection], cCol + dc[nextDirection], nextDirection});
                    
                }
            } else {
                queue.offerFirst(new int[]{cRow + dr[cDirection], cCol + dc[cDirection], cDirection});
            }
            
            
        }
        
        System.out.println(time);
    }

}
