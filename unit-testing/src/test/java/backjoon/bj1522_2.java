package backjoon;

import java.util.Scanner;

public class bj1522_2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String line = scan.nextLine();
        
        int windowSize = 0;
        for(char c : line.toCharArray()) {
            if(c == 'a') {
                windowSize ++;
            }
        }
        
        // 초기 사이즈 선정
        int changeCount = 0;
        for(int i = 0; i < windowSize; i++) {
            if(line.charAt(i) == 'b') {
                changeCount ++;
            }
        }
        
        int minCount = changeCount;
        int length = line.length();
        
        // window 이동
        for(int i = 1; i < length; i++) {
            int leftIndex = i - 1;
            if(line.charAt(leftIndex) == 'b') {
                changeCount --;
            }
            
            int rightIndex = (i + windowSize - 1) % length;
            if(line.charAt(rightIndex) == 'b') {
                changeCount ++;
            }
            
            minCount = Math.min(changeCount, minCount);
            
            if (minCount == 0) {
                break;
            }
        }
        
        System.out.println(minCount);
    }
    
}
