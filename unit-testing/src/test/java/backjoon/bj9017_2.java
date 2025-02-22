package backjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class bj9017_2 {
    
    /**
     * 팀 단위: 여섯 명의 선수로 구성
     *
     * 팀 점수: 상위 네명의 주자의 점수 합산
     *  - 단, 자격을 갖춘 팀들만 계산
     *  - 결승점을 통과한 순서대로 점수
     *  - 동점의 경우에는 다섯 번째 주자 기준
     *
     * 팀 우승: 가장 낮은 점수를 얻은 팀
     */
    
    /**
     * 1. 입력 받기
     * - 각 팀 번호 저장
     * - 순위별 주자 목록 저장
     * 2. 각 팀별로 6명인지 확인
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt(); // 테스트 케이스 수
        
        for (int i = 1; i <= T; i++) {
            int N = scan.nextInt(); // 주자 수
            
            Map<Integer, Integer> runnerCountOfTeam = new HashMap<>(); // 팀 별 주자 수량
            int[] runners = new int[N]; // 주자 정보 목록(팀 숫자)
            
            for (int j = 0; j < N; j++) {
                int teamNumber = scan.nextInt();
                
                runners[j] = teamNumber;
                runnerCountOfTeam.put(teamNumber, runnerCountOfTeam.getOrDefault(teamNumber, 0) + 1);
            }
            
            // validTeamNumbers 에 포함되있지 않을 경우 계산 제외(contains(Object o))
            List<Integer> validTeamNumbers = new ArrayList<>();
            for (int teamNumber : runnerCountOfTeam.keySet()) {
                if (runnerCountOfTeam.get(teamNumber) == 6) {
                    validTeamNumbers.add(teamNumber);
                }
            }
            
            //  - 각 팀별로 점수 합산 (+= 연산자)
            int lastRank = 1; // 마지막 등수
            
            Map<Integer, List<Integer>> runnersScoreOfTeam = new HashMap<>(); // 팀별 주자 목록
            
            for (int j = 0; j < N; j++) {
                int teamNumber = runners[j]; // 현재 주자의 팀 숫자
                
                if (validTeamNumbers.contains(teamNumber)) { // 해당 팀은 합산 대상인 경우
                    
                    if (runnersScoreOfTeam.get(teamNumber) == null) { // 주자 목록이 없는 경우
                        List<Integer> list = new ArrayList<>();
                        list.add(lastRank);
                        
                        runnersScoreOfTeam.put(teamNumber, list);
                    } else { // 주자 목록이 기존에 있는 경우
                        runnersScoreOfTeam.get(teamNumber).add(lastRank);
                    }
                    lastRank++;
                }
            }
            
            // 가장 낮은 팀 출력
            int minScore = Integer.MAX_VALUE;
            int teamNumberOfMinScore = 0;
            
            for (int teamNumber : runnersScoreOfTeam.keySet()) {
                List<Integer> list = runnersScoreOfTeam.get(teamNumber);
                
                int score = list.get(0) + list.get(1) + list.get(2) + list.get(3);
                
                if (minScore > score) { // 점수 갱신이 가능한 경우
                    // TODO minScore 갱신, teamNumber 갱신
                    minScore = score;
                    teamNumberOfMinScore = teamNumber;
                    
                } else if (minScore == score) { // 점수가 동일한 경우
                    if (runnersScoreOfTeam.get(teamNumberOfMinScore).get(4) > list.get(4)) {
                        teamNumberOfMinScore = teamNumber;
                    }
                }
            }
            
            System.out.println(teamNumberOfMinScore);
        }
        
        
    }
    
}
