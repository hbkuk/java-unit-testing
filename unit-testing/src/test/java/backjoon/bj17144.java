package backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj17144 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int R = scan.nextInt(); // ROW 수
        int C = scan.nextInt(); // COL 수
        int T = scan.nextInt(); // T초 후 결과는?
        
        int mR1 = -1; // 공기청정기 row-1 위치
        int mR2 = -1; // 공기청정기 row-2 위치
        
        int[][] map = new int[R][C]; // Map
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int value = scan.nextInt();
                map[i][j] = value;
                
                if (value == -1) {
                    if (mR1 == -1) {
                        mR1 = i;
                    } else {
                        mR2 = i;
                    }
                }
            }
        }
        
        int time = 0;
        while (true) {
            time++;
            
            Queue<int[]> queue = new LinkedList<>(); // 미세먼지 확산
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    
                    // 공기청정기 위치 아님 && 빈 칸 아님
                    if (map[i][j] > 0) {
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            
            int[][] newMap = new int[R][C]; // 확산 후의 새로운 맵
            
            while(!queue.isEmpty()) {
                
                
                int[] current = queue.poll();
                int cR = current[0];
                int cC = current[1];
                int cValue = map[cR][cC]; // 현재 미세먼지 량
                
                int[] dr = {-1, 1, 0, 0};
                int[] dc = {0, 0, -1, 1};
                
                List<int[]> list = new ArrayList<>();
                for(int i = 0; i < 4; i++) {
                    int nr = cR + dr[i];
                    int nc = cC + dc[i];
                    
                    // Map 범위 안 && 공기 청정기 위치 아님
                    if(nr >= 0 && nr <= R - 1 &&
                        nc >= 0 && nc <= C - 1 &&
                        map[nr][nc] != -1) {
                        
                        list.add(new int[]{nr, nc});
                    }
                }
                
                int eachValue = cValue / 5; // 각 확산될 미세먼지 량
                int remainValue = cValue - (eachValue * list.size()); // 확산 후 남은 미세먼지 량
                
                // 각 방에 미세먼지 확산
                for(int[] ele : list) {
                    int eR = ele[0];
                    int eC = ele[1];
                    
                    newMap[eR][eC] += eachValue;
                }
                
                // 확산 후 값 갱신
                newMap[cR][cC] += remainValue;
                
            }
            
            map = newMap;
            
            
            
            // TODO 2: 공기청정기가 동작한다.
            // 상단 -> 반 시계 방향
            
            // 0부터 -> 좌측면까지
            for(int i = 2; i <= C - 1; i++) {
                map[mR1][i] += map[mR1][i - 1];
            }
            
            // mR1 -> 윗면까지
            for(int i = mR1 - 1; i >= 0; i--) {
                map[i][C - 1] += map[i + 1][C - 1];
            }
            
            // 첫번째 줄 0까지..
            for(int i = C - 1 - 1; i >= 0; i--) {
                map[0][i] += map[0][i + 1];
            }
            
            // 공기청정기 까지..
            for(int i = 1; i <= mR1 -1; i++) {
                map[i][0] += map[i - 1][0];
            }
            
            // 상단 공기청정기가 미세먼지를 다 빨아들임.
            map[mR1 - 1][0] = 0;
            
            // 하단 -> 시계 방향
            for(int i = 2; i <= C - 1; i++) {
                map[mR2][i] += map[mR2][i - 1];
            }
            
            for(int i = mR2 + 1; i <= R - 1; i++) {
                map[i][C - 1] += map[i - 1][C - 1];
            }
            
            for(int i = C - 1 - 1; i >= 0; i--) {
                map[R - 1][i] += map[R - 1][i + 1];
            }
            
            for(int i = R - 1 - 1; i >= mR2 + 1; i--) {
                map[i][0] += map[i - 1][0];
            }
            
            // 하단 공기청정기가 미세먼지를 다 빨아들임.
            map[mR2 + 1][0] = 0;
            
            
            if (time == T) {
                break;
            }
        }
        
        // TODO 3: 방에 남아있는 미세먼지 출력 => for문으로... 돌아서 계산하기
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                
                // 공기청정기 위치 아님 && 빈 칸 아님
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }
        
        System.out.println(sum);
    }
}
