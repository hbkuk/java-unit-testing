package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj16234 {
    
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] associated;
    
    static int N;
    static int L;
    static int R;
    
    public static void main(String[] args) {
        
        // < 구성 요소 >
        // 1. Map 구성       int[][] map = new int[N][N];
        // 2. 방문 여부       boolean[][] visited = new boolean[][]
        // 3. 국경선이 열린 날 int count
        
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt(); // Map 크기
        L = scan.nextInt(); // 특정 인구수 이상
        R = scan.nextInt(); // 특정 인구수 이하
        
        map = new int[N][N]; // Map
        visited = new boolean[N][N]; // 방문 여부
        
        int days = 0; // 국경선이 열린 날짜
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        
        // < 진행 방식 >
        // 1. map[i][j] 에서 국경선이 열려있는 곳을 확인한다.
        //  - 방문하지 않았던 곳
        //  - 상,하,좌,우를 확인해서 L 이상 R 미만 인곳
        // 2. 국가를 방문했다는 의미는 => 연합이라는 뜻이다.
        //  - dfs로 진행한다.
        //  - 다음 위치를 재귀로 진행할 때, 지금까지 걸어온 길을.. 추가해야한다.
        //      - (연합의 인구수 / 연합을 이루고 있는 칸의 개수)로 계산할 수 있음.
        
        while(true) {
            
            int 총_연합_개수 = 0;
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    
                    // 방문하지 않았거나 연합되어 있지 않은 경우 DFS 진행..
                    if(!visited[i][j] && !associated[i][j]) {
                        List<int[]> 국경선_열린_목록 = new ArrayList<>();
                        dfs(i, j, 국경선_열린_목록);
                        
                        // 2개 이상인 경우 -> 연합 가능
                        if(국경선_열린_목록.size() >= 2) {
                            총_연합_개수 ++;
                            
                            int 총_인구수 = 0;
                            int 총_칸의_수 = 국경선_열린_목록.size();
                            for(int[] 국경선 : 국경선_열린_목록) {
                                총_인구수 += map[국경선[0]][국경선[1]];
                            }
                            
                            int 연합_인구수 = 총_인구수 / 총_칸의_수;
                            
                            for(int[] 국경선 : 국경선_열린_목록) {
                                map[국경선[0]][국경선[1]] = 연합_인구수;
                            }
                            
                        }
                    }
                }
            }
            
            if(총_연합_개수 == 0) {
                break;
            }
            
        }
        
        
        
        System.out.println(days);
    }
    
    private static void dfs(int i, int j, List<int[]> 연합_리스트) {
        visited[i][j] = true; // 방문 체크
        연합_리스트.add(new int[]{i, j}); // 연합 리스트 추가
        
        int[] dr = {-1, 1, 0, 0}; // 상, 하 , 좌, 우
        int[] dc = {0, 0, -1, 1}; // 상, 하 , 좌, 우
        
        for(int idx = 0; idx < 4; idx++) {
            
            int nextRow = i + dr[idx];
            int nextCol = j + dc[idx];
            
            
            // Map 범위 안에 있는지 + 방문하지 않았는지 + 특정 인구수 안에 들어오는지
            if(nextRow >= 0 && nextRow <= N-1 &&
                nextCol >= 0 && nextCol <= N-1 &&
                !visited[nextRow][nextCol] &&
                Math.abs(map[i][j] - map[nextRow][nextCol]) >= L && Math.abs(map[i][j] - map[nextRow][nextCol]) <= R) {
                
                dfs(nextRow, nextCol, 연합_리스트);
            
            }
        }
    }
    
}
