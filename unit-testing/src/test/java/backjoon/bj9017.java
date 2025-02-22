package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class bj9017 {
    
    /**
     * #기본 조건
     * 6명 팀으로 구성
     * 팀 점수는 상위 주자 4명의 점수 합산
     * 결승점을 통과한 순서대로 점수 획득
     *
     * #승리 조건
     * 가장 낮은 점수를 얻은 팀 승리
     *
     * #예외 조건
     * 여섯 명의 주자가 참가하지 못한 팀은 제외
     * 동점의 경우 다섯 번째 주자 기준(점수 합산에서 제외되므로)
     */
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken()); // 테스트 케이스
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 주자 수
            
            
            // 1. 주자 정보 저장
            int[] runners = new int[N];
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < N; j++) { // 팀 정보 주입
                runners[j] = Integer.parseInt(st.nextToken());
            }
            
            // 2. 팀 단위별로 6명인지 확인
            Map<Integer, Integer> value = new HashMap<>();
            for(int runner : runners) {
                value.put(runner, value.getOrDefault(runner, 0) + 1);
            }
            
            List<Integer> validTeamNumber = new ArrayList<>();
            for(int key : value.keySet()) {
                if(value.get(key) == 6) {
                    validTeamNumber.add(key);
                }
            }
            
            // 3. 6명이 아닐 경우, 점수를 다시 산정한다.
            int nextRank = 1;
            Map<Integer, List<Integer>> teamMap = new HashMap<>();
            for(int j = 0; j < N; j++) {
                int teamNumber = runners[j];
                
                if(validTeamNumber.contains(teamNumber)) {
                    // MateamMap에 넣기
                    if(!teamMap.containsKey(teamNumber)) { // 기존 리스트가 없는 경우
                        List<Integer> list = new ArrayList<>();
                        list.add(nextRank);
                        
                        teamMap.put(teamNumber, list);
                    } else { // 기존 리스트가 있는 경우
                        teamMap.get(teamNumber).add(nextRank);
                    }
                    
                    nextRank ++; // 다음 순위로 올리기
                }
            }
            
            int minSum = Integer.MAX_VALUE;
            int winnerTeamNumber = 0;
            // 4. 점수를 합산 후 비교한다.
            for(int key : teamMap.keySet()) {
                List<Integer> list = teamMap.get(key);
                int sum = list.get(0) + list.get(1) + list.get(2) + list.get(3);
                
                if(sum < minSum) { // 순회 중인 팀 점수가 더 낮을 경우
                    minSum = sum;
                    winnerTeamNumber = key;
                } else if (sum == minSum) { // 동일한 경우
                    // 5번째 주자 비교
                    if(list.get(4) < teamMap.get(winnerTeamNumber).get(4)) {
                        winnerTeamNumber = key;
                    }
                }
            }
            
            System.out.println(winnerTeamNumber);
        }
        
    }
}