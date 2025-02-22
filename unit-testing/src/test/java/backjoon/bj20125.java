package backjoon;

import java.util.Scanner;

public class bj20125 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // 판의 한변의 길이, 정사각형
        int N = scan.nextInt();
        
        // true -> 쿠키임, false -> 쿠키 아님
        boolean[][] plate = new boolean[N][N];
        
        // plate 입력받기
        for (int i = 0; i < N; i++) {
            String line = scan.nextLine();
            char[] chars = line.toCharArray();
            
            for (int j = 0; j < N; j++) {
                if (chars[j] == '*') {
                    plate[i][j] = true; // 쿠키 표시
                }
            }
        }
        
        // 방향 설정(상, 하, 좌, 우)
        int[] dr = {-1, 1, 0, 0}; // 가로 번호 => row
        int[] dc = {0, 0, -1, 1}; // 세로 번호 => colum
        
        // 심장 좌표
        int[] heart = new int[2];
        boolean isHeartFind = false;
        
        // TODO 1) 심장 찾기 => 4방향으로 연결되어 있는 좌표(x, y) 찾기 => 완전 탐색으로 O(N^2)
        for (int i = 0; i < plate.length; i++) {
            for (int j = 0; j < plate.length; j++) {
                // 현재 좌표
                int[] cur = new int[]{i, j};
                
                // 모든 방향 쿠키를 찾았는지?
                boolean isAllFind = true;
                
                // 현재 좌표에 쿠키가 있을 경우
                if (plate[i][j]) {
                    
                    // 4방향에 모두 쿠키가 있는지
                    for (int k = 0; k < 4; k++) {
                        if (!plate[cur[0] + dr[k]][cur[1] + dc[k]]) {
                            isAllFind = false;
                            break;
                        }
                    }
                    
                    if (isAllFind) {
                        isHeartFind = true;
                        
                        heart[0] = i;
                        heart[1] = j;
                        
                        break;
                    }
                }
            }
            
            // 쿠키를 찾은경우 종료
            if (isHeartFind) {
                break;
            }
        }
        
        // TODO 2) 각 부위별 길이 계산하기
        //  1) 각 방향? 직선으로 얼마나 연결되어 있는지 찾기 => O(1)
        int[] lengths = new int[5];
        int[] directions = new int[]{2, 3, 1, 1, 1}; // TODO idx => 3, 4인 경우 좌, 우 대각선으로 한번 이동 필요
        for (int i = 0; i < lengths.length; i++) {
            
            if (i < 3) {
                while (true) {
                    int nr = heart[0] + dr[directions[i]];
                    int nc = heart[1] + dc[directions[i]];
                    
                    // TODO next가 범위 안에 있는지?
                    if (nr > -1 && nc > -1 && nr < N && nc < N) {
                        int[] next = new int[]{nr, nc};
                        
                        // 다음이 쿠키인 경우
                        if (plate[next[0]][next[1]]) {
                            lengths[i]++;
                            
                            // 아닌 경우 종료
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else if (i == 3) {
                
                // 대각선 한번 이동..
                
            } else if (i == 4) {
                
            }
        }
        // TODO 3) 출력하기
    }
}
