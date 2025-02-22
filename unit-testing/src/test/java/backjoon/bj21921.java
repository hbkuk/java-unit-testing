package backjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class bj21921 {
    
    /**
     * 특정 기간 동안 가장 많이 들어온 방문자 수와 기간 개수 출력하기
     * <p>
     * 1. 입력받기
     * - 첫째 줄에 지난 일수와 특정 기간 입력받기
     * - 둘째 줄에 방문자 수 목록 입력받기
     * <p>
     * 2. 변수 준비
     * - int 타입: 최대 방문자 수 갱신
     * - Map 타입: 최대 방문자 수 기간
     * <p>
     * 3. 슬라이딩 윈도우 진행
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int N = scan.nextInt(); // 지난 일수
        int X = scan.nextInt(); // 특정 기간
        
        int[] visitCounts = new int[N + 1]; // 방문자 수 목록
        for (int i = 1; i <= N; i++) {
            visitCounts[i] = scan.nextInt();
        }
        
        scan.close();
        
        
        int maxVisitCount = 0; // 최대 방문자 수
        Map<Integer, Integer> map = new HashMap<>(); // 최대 방문자 수를 가지고 있는 기간의 개수
        
        
        // 초기 슬라이딩 윈도우 진행
        int preVisitCount = 0;
        
        for(int i = 1 ; i <= X; i++) {
            preVisitCount += visitCounts[i];
        }
        maxVisitCount = preVisitCount;
        map.put(preVisitCount, 1);
        
        // 본격적인 슬라이딩 윈도우 진행
        for(int i = 2; i + X - 1 <= N; i++) {
            int visitCount = preVisitCount;
            
            // 앞에 것 뺴고
            visitCount -= visitCounts[i - 1];
            
            // 뒤에 것 추가하기
            visitCount += visitCounts[i + X - 1];
            
            // 최대 방문자 수 갱신하기
            maxVisitCount = Math.max(maxVisitCount, visitCount);
            
            // 기간 수 카운팅하기
            map.put(visitCount, map.getOrDefault(visitCount, 0 ) + 1);
            
            // 이전 값 갱신
            preVisitCount = visitCount;
        }
        
        
        
        if(maxVisitCount == 0) {
            sb.append("SAD");
        } else {
            sb.append(maxVisitCount).append("\n");
            sb.append(map.get(maxVisitCount));
        }
        System.out.println(sb); // 결과 출력
    }
    
}
