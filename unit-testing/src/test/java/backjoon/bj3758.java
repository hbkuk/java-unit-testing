package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class bj3758 {
    
    /**
     * 1. 입력받기
     * 2. 각 팀별 문제에 대한 정보 갱신
     *      - 최고 점수 갱신
     *      - 마지막 제출시간 갱신
     *      - 제출 횟수 갱신
     * 3. 각 팀별 문제에 대한 최고 점수 합산
     *      - 동점일 경우
     *          a) 제출 횟수 적은 순
     *          b) 마지막 제출 시간 빠른 순
     * 4. 순위 출력
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt(); // 테스트 데이터 수
        
        for(int i = 0; i < T; i++) {
            
            int N = scan.nextInt(); // 팀의 개수
            int K = scan.nextInt(); // 문제의 개수
            int t = scan.nextInt(); // 나의 팀 번호
            int m = scan.nextInt(); // 로그 엔트리 개수
            
            Map<Integer, int[][]> maxScore = new HashMap<>(); // int[][] => [문제번호][최고점수]
            
            int[][] results = new int[N + 1][4]; // [팀 번호, 점수 합계, 마지막 제출시간, 제출 횟수]
            int questionCount = 0; // 총 문제 제출 시간
            
            for(int j = 0; j < m; j++) {
                int teamId = scan.nextInt(); // 팀 ID
                int questionId = scan.nextInt(); // 문제 번호
                int score = scan.nextInt(); // 획득한 점수
                
                int[][] getTeam = maxScore.getOrDefault(teamId, new int[K + 1][1]); // [문제번호][최고점수]
                
                getTeam[questionId][0] = Math.max(getTeam[questionId][0], score); // 최고점수 갱신
                
                results[teamId][2] = questionCount ++; // 마지막 제출시간 갱신
                results[teamId][3] ++; // 제출 횟수 증가
                
                maxScore.put(teamId, getTeam);
            }
            
            // 순위 매기기...
            for(int key : maxScore.keySet()) {
                int[][] score = maxScore.get(key);
                
                for(int[] scoreArray: score) {
                    results[key][0] = key; // 팀 번호
                    results[key][1] += scoreArray[0]; // 점수 합계
                    
                }
            }
            
            Arrays.sort(results, new Comparator<int[]>() {
                
                @Override
                public int compare(int[] o1, int[] o2) {
                    int preScore = o1[1]; // 현재 점수
                    int nexScore = o2[1]; // 다음 점수
                    
                    if(preScore == nexScore) {
                        int preSubmitCount = o1[3]; // 현재 제출 횟수
                        int nexSubmitCount = o2[3]; // 다음 제출 횟수
                        
                        if(preSubmitCount == nexSubmitCount) {
                            int preLastSubmit = o1[2]; // 현재 마지막 제출 시간
                            int nexLastSubmit = o2[2]; // 다음 마지막 제출 시간
                            
                            return preLastSubmit - nexLastSubmit; // 오름차순
                        }
                        
                        return preSubmitCount - nexSubmitCount; // 오름차순
                    }
                    return nexScore - preScore; // 내림차순
                }
            });
            
            int rank = 0;
            for(int j = 0; j < N; j++) {
                if(results[j][0] == t) {
                    rank = j;
                }
            }
            
            if(rank == 0) {
                System.out.println(1);
            } else {
                System.out.println(rank + 1);
            }
            
        }
    }
}