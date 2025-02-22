package backjoon;

import java.util.Scanner;

public class bj1515_3 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine(); // 입력 받은 문자열
        
        int N = 1; // 현재 찾고 있는 숫자
        int index = 0; // 입력 문자열에서 비교 중인 위치
        
        while(line.length() > index) {
        
            String value = String.valueOf(N); // 현재 숫자를 문자랑 비교
            
            for(int i = 0; i < value.length(); i++) {
                if(line.length() <= index) {
                    break;
                }
                
                if(value.charAt(i) == line.charAt(index)) {
                    index ++;
                }
            }
            
            N++;
        }
        
        System.out.println(N - 1);
    }
}
