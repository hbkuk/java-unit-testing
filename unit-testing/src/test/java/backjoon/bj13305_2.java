package backjoon;

import java.util.Scanner;

public class bj13305_2 {
    
    /**
     * 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산
     *
     *
     * 1) 제일 왼쪽 도시로부터 자신보다 싼 주유소 찾기
     *  a) 있음
     *      -> 해당 거리까지 이동하기 위한 비용 지출
     *           -> 가장 싼 주유소 도착 후 가장 싼 주유소 찾기 ... 반복
     *  b) 없음
     *      -> 편도 거리에 해당하는 비용 지출
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 도시의 개수
        
        long[] distance = new long[N - 1];
        long[] prices = new long[N];
        
        for (int i = 0; i < N - 1; i++) {
            distance[i] = scan.nextLong();
        }
        
        for (int i = 0; i < N; i++) {
            prices[i] = scan.nextLong();
        }
        
        long totalCost = 0; // 총 주유 비용
        long minPrice = prices[0]; // 최소 주유 비용
        
        // 가격이 더 싼 주유소 찾기
        for(int i = 0; i < N - 1; i++) {
            
            // 최소 비용보다 더 싼 주유소를 찾은 경우
            if(minPrice > prices[i]) {
                minPrice = prices[i];
            }
            
            totalCost += (minPrice * distance[i]);
        }
        
        System.out.println(totalCost);
    }
}
 