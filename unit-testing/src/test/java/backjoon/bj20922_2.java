package backjoon;

import java.util.Scanner;

public class bj20922_2 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 정수의 길이
        int K = scan.nextInt(); // 중복 허용 개수
        scan.nextLine();
        
        int[] numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = scan.nextInt();
        }
        
        int leftPointer = 0; // 왼쪽 포인터
        int maxLength = 0; // 최장 연속 부분 수열의 길이
        int[] count = new int[100001]; // 숫자의 빈도 관리
        
        for(int rightPointer = 0; rightPointer < N; rightPointer++) {
            // 현재 숫자를 윈도우에 추가
            int currentNumber = numbers[rightPointer];
            count[currentNumber]++;
            
            // 조건 위반시, 왼쪽 포인터 이동
            while(count[currentNumber] > K) {
                int leftNumber = numbers[leftPointer];
                count[leftNumber] --;
                leftPointer ++;
            }
            
            maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
        }
        System.out.println(maxLength);
    }
}
