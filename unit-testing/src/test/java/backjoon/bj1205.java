package backjoon;

import java.util.Scanner;

public class bj1205 {
    
    /**
     * 주어진 랭킹 리스트에서 새로운 점수는 몇등인가?
     * 예) [100, 90, 90, 80] => [1, 2, 2, 4]
     * <p>
     * N: 리스트에 존재하는 점수( N >= 0 || P >= N)
     * NewPoint : 새 점수
     * P: 랭킹 리스트에 올라갈 수 있는 점수의 개수(50 >= P >= 10) => 배열 사이즈?
     * <p>
     * 예외 케이스
     * 1) 리스트가 FULL 인 경우 마지막 점수보다 높은 경우 교체 O
     * 2) 새 점수가 리스트 목록 최소 점수 최저 점수보다 낮은 경우 교체 X
     * 3) N > 0 => 랭킹 리스트 제공
     */
    public static void main(String[] args) {
        // 전체 입력 받기
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 현재 리스트에 존재하는 점수 개수
        int newPoint = scan.nextInt(); // 새로운 점수
        int P = scan.nextInt(); // 랭킹 리스트에 올라갈 수 있는 점수의 개수
        
        int[] points = new int[N]; // 포인트 목록
        for (int count = 0; count < N; count++) {
            points[count] = scan.nextInt();
        }
        
        // 랭킹
        int ranking;
        
        // 리스트에 존재하지 않는 경우
        if(N == 0) {
            ranking = 1;
        }
        
        // 랭킹 리스트가 FULL && 최저 점수보다 크지 않은 경우
        else if(P == points.length && points[points.length - 1] >= newPoint) {
            ranking = -1;
        }
        
        // 그 외 케이스
        else {
            int tempRanking = 1;
            // 순위 계산
            for(int i = 0; i < N; i++) {
                if(points[i] > newPoint) {
                    tempRanking++;
                }
            }
            ranking = tempRanking;
        }
        
        
        System.out.println(ranking);
    }
}
