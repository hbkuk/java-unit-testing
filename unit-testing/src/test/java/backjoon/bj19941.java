package backjoon;

import java.util.Scanner;

public class bj19941 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String[] line = scan.nextLine().split(" ");
        int N = Integer.parseInt(line[0]); // 식탁의 길이
        int K = Integer.parseInt(line[1]); // 햄버거를 선택할 수 있는 거리(좌, 우 동일)
        
        String[] section = scan.nextLine().split(""); // P(사람)와 H(햄버거)
        
        boolean[] isPeopleAte = new boolean[N]; // 사람인 먹은 여부
        boolean[] isHambugerAte = new boolean[N]; // 햄버거 먹은 여부
        
        for (int i = 0; i < N; i++) {
            
            if (section[i].equals("P")) { // 해당 위치에 사람인 경우
                int leftPointer = i - K; // 왼쪽 포인터
                if (leftPointer < 0) { // 0보다 작은 경우 0으로 초기화
                    leftPointer = 0;
                }
                
                int rightPointer = i + K; // 오른쪽 포인터
                if (rightPointer > N - 1) { // N보다 큰 경우 최대 인덱스로 초기화
                    rightPointer = N - 1;
                }
                
                for (int j = leftPointer; j <= rightPointer; j++) {
                    
                    // 현재 포인터가 햄버거인 경우와, 아직 먹지 않은 햄버거인 경우
                    if (section[j].equals("H") && !isHambugerAte[j]) {
                        // 먹은 처리
                        isPeopleAte[i] = true;
                        isHambugerAte[j] = true;
                        
                        break;
                    }
                }
                
            }
        }
        
        // TODO isPeopleAte 에서.. 먹은 수량 출력
        int isPeopleCount = 0;
        for (int i = 0; i < N; i++) {
            if (isPeopleAte[i]) {
                isPeopleCount++;
            }
        }
        
        System.out.println(isPeopleCount);
    }
}
