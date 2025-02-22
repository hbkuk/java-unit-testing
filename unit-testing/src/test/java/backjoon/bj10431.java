package backjoon;

import java.util.Scanner;
import java.util.Arrays;

public class bj10431 {
    
    // 1. 크기 20 배열을 만든다.
    // 2. 줄을 세운다.
    // 3. 바로 앞 숫자를 비교한다.
    //  - 나보다 크다 =>
    //      1. 가장 앞부터 나보다 큰 수를 찾는다.
    //      2. 가장 큰 수 앞에 배치한다.
    //      3. 다른 숫자들을 +1 하며, 다른 숫자를 카운팅한다.
    //  - 나보다 작다
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        
        int[] answer = new int[T];
        
        for(int i = 0; i < answer.length; i++) {
            String[] splitStr = sc.nextLine().split(" ");
            splitStr = Arrays.copyOfRange(splitStr, 1, splitStr.length); // 첫 항목 제거
            
            int count = 0; // 밀어낸 숫자
            
            int[] heights = new int[20]; // 키 저장
            
            for(int j = 0; j < 20; j++) {
                int currentValue = Integer.parseInt(splitStr[j]);
                
                int tempIndx = j;
                
                while(tempIndx > 0 && heights[tempIndx - 1] > currentValue) {
                    heights[tempIndx] = heights[tempIndx - 1];
                    
                    tempIndx --;
                    
                    count++;
                }
                
                heights[tempIndx] = currentValue;
            }
            
            answer[i] = count;
        }
        
        for(int c = 0; c < answer.length; c++) {
            System.out.println(c + 1 + " " + answer[c]);
        }
    }

}
