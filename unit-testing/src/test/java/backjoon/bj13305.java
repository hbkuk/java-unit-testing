package backjoon;

import java.util.Scanner;

public class bj13305 {
    
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
        
        int requiredDistance = 0; // 필요한 총 거리
        
        int[] distance = new int[N - 1]; // 거리 정보
        for(int i = 0; i < distance.length; i++) {
            distance[i] = scan.nextInt();
            requiredDistance += distance[i];
        }
        
        int[] place = new int[N]; // 주유소 리터당 가격 정보
        for(int i = 0; i < place.length; i++) {
            place[i] = scan.nextInt();
        }
        
        int totalPrice = 0; // 총 비용
        int totalDistance = 0; // 지나온 총 거리
        
        // 여정 시작
        for(int i = 0; i < place.length; i++) {
            boolean isFind = false; // 저렴한 주유소 여부
            int currentPrice = place[i]; // 현재 주유소 가격
            
            // 현재 place보다 더 싼 주유소가 있는지?
            for(int j = i + 1; j < place.length - 1; j++) {
                int nextPrice = place[j]; // 다음 싼 주유소 가격
                
                // 더 저렴한 주유소 찾음 -> 해당 주유 후 이동  
                if(currentPrice > nextPrice) {
                    int nextDistance = 0; // 다음 주유소까지 거리
                    
                    for (int k = i; k < j; k++) {
                        nextDistance += distance[k];
                    }
                    
                    totalPrice += nextDistance * currentPrice; // 총 가격 갱신
                    totalDistance += nextDistance; // 지나온 총거리 갱신
                    
                    // 인덱스도 이동 필요
                    i = j;
                    i --;
                    isFind = true;
                    break;
                    
                }
            }
            
            if(!isFind) {
                totalPrice += (currentPrice * (requiredDistance - totalDistance));
                
                break;
            }
        }
        
        System.out.println(totalPrice);
    }
}
 