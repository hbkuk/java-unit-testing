package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj2512 {
    
    /**
     * 예산 배정
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 지방 수
        
        int totalCostRequests = 0; // 모든 지방의 예산
        
        int maxCost = 0; // 가장 큰 요청 예산요청 금액
        int[] costRequests = new int[N]; // 예산요청 수
        for(int i = 0; i < N; i++) {
            int cost = scan.nextInt();
            costRequests[i] = cost;
            totalCostRequests += cost;
            
            maxCost = Math.max(maxCost, cost); // 가장 큰 예산 갱신
        }
        
        int totalNationalCost = scan.nextInt(); // 국가예샨
        
        // 국가예산 내에서 배정할 수 있는 경우
        if(totalNationalCost >= totalCostRequests) {
            System.out.println(maxCost);
        } 
        // 국가예산 내에서 배정할 수 없는 경우
        else {
            // 이분 탐색을 위한 초기 범위 설정
            int left = 0;
            int right = Arrays.stream(costRequests).max().getAsInt();
            
            while(left <= right) {
                int mid = (left + right) / 2; // 중간 상한선 설정
                int allocatedBudget = 0; // 상한선 기준 예산
                
                // 각 지방 예산 배정
                for(int i = 0; i < N; i++) {
                    if(costRequests[i] > mid) {
                        allocatedBudget += mid;
                    } else {
                        allocatedBudget += costRequests[i];
                    }
                }
                
                // 국가 예산 내 해결할 수 있는 경우
                if(totalNationalCost >= allocatedBudget) {
                    maxCost = mid;
                    left = mid + 1;
                }
                // 국가 예산이 부족하다면
                else {
                    right = mid - 1;
                }
            }
            
            System.out.println(maxCost);
        }
    }
}
