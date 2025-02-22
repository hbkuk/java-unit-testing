package backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj16236 {
    
    
    // <이동>
    // 상/하/좌/우 이동 가능
    // 자신보다 큰 물고기가 있는 칸 이동 O
    
    // <먹기>
    // 자신보다 크기가 작은 물고기 먹음
    // 먹을 수 있는 물고기가 여러마리 일 경우
    //   - 위
    //   - 왼
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 공간의 크기
        
        int[][] map = new int[N][N]; // 공간
        
        int cRow = 0; // 현재 아기 상어 행 위치
        int cCol = 0; // 현재 아기 상어 열 위치
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int value = scan.nextInt();
                map[i][j] = value;
                
                if(value == 9) {
                    cRow = i;
                    cCol = j;
                }
            }
        }
        scan.close();
        
        int time = 0; // 이동 시간
        int level = 2; // 현재 아기 상어 레벨
        int ateCount = 0; // 물고기 먹은 횟수
        
        while(true) {
            
            // 1. 먹을 수 있는 물고기 찾기
            List<int[]> eatList = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    int value = map[i][j];
                    
                    // 먹을 수 있는 물고기인 경우
                    if(value != 0 && level > value) {
                        eatList.add(new int[]{i, j});
                    }
                }
            }
            
            if(eatList.isEmpty()) {
                break;
            }
            
            // 2. 현재 위치에서 해당 위치까지 거리 찾기
            boolean[][] visited = new boolean[N][N];
            int[][] distance = new int[N][N];
            for (int[] row : distance) {
                Arrays.fill(row, -1); // 방문하지 않은 곳은 -1로 설정
            }
            
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{cRow, cCol, 0});
            visited[cRow][cCol] = true;
            
            while(!queue.isEmpty()) {
                
                int[] current = queue.poll();
                int cR = current[0];
                int cC = current[1];
                int cD = current[2];
                
                int[] dR = {-1, 1, 0, 0};
                int[] dC = {0, 0, -1, 1};
                
                for(int i = 0; i < 4; i++) {
                    
                    int nR = cR + dR[i];
                    int nC = cC + dC[i];
                    
                    // Map 내부 && 미방문 && 현재 level 이하인지
                    if(nR >= 0 && nR <= N - 1 &&
                        nC >= 0 && nC <= N - 1 &&
                        !visited[nR][nC] &&
                        level >= map[nR][nC]) {
                        visited[nR][nC] = true; // 방문 체크
                        distance[nR][nC] = cD + 1; // 거리 갱신
                        queue.offer(new int[]{nR, nC, cD + 1}); // 큐에 넣기
                    }
                }
                
            }
            
            
            // TODO 찾은 최소 거리를 조건에 맞춰서 정렬하기
            // [행, 열, 거리] .. -> Arrays.sort()
            //  - 1) 거리 오름차순
            //  - 2) 행 오름차순
            //  - 3) 열 오름차순
            List<int[]> list = new ArrayList<>();
            for(int[] ele : eatList) {
                int row = ele[0];
                int col = ele[1];
                
                // 해당 위치까지 갈 수 있는 경우에만..
                if(distance[row][col] > 0) {
                    list.add(new int[]{row, col, distance[row][col]});
                }
            }
            
            Collections.sort(list, new Comparator<int[]>() {
                
                @Override
                public int compare(int[] o1, int[] o2) {
                    int od1 = o1[2];
                    int od2 = o2[2];
                    
                    if(od1 != od2) {
                        return od1 - od2;
                    }
                  
                    int oR1 = o1[0];
                    int oR2 = o2[0];
                    if(oR1 != oR2) {
                        return oR1 - oR2;
                    }
                    
                    return o1[1] - o2[1];
                };
            });
            
            if (list.isEmpty()) {
                break; // 더 이상 먹을 물고기가 없으므로 종료
            }
            
            
            int[] eat = list.get(0);
            int willR = eat[0];
            int willC = eat[1];
            int willD = eat[2];
            // TODO 가장 처음꺼 먹기
            //  - 현재 위치 갱신
            //  - time 증가
            //  - 물고기 여부 횟수 확인
            //      - 레벨업 확인
            map[cRow][cCol] = 0;
            
            cRow = willR;
            cCol = willC;
            time += willD;
            ateCount += 1;
            if(ateCount == level) {
                level ++;
                ateCount = 0;
            }
            
            map[cRow][cCol] = 0;
  
        }
        
        System.out.println(time);
    }
}