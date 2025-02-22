package backjoon;

import java.util.Scanner;

public class bj1515_2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String line = scan.nextLine();
        
        int lastNumber = 0; // 마지막 갱신한 숫자
        int checkedIndex = 0; // 마지막 갱신한 숫자에서.. 마지막으로 체크한 인덱스
        
        for(int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            
            while(true) { // 찾을 때까지 반복..
                String str = String.valueOf(lastNumber);
                
                int index = str.indexOf(current);
                
                // 일의 숫자인 경우
                if(10 > lastNumber && index != -1) {
                    break;
                }
                else if(str.length() - 1 > checkedIndex && index != -1) {
                    checkedIndex = index;
                    break;
                } else {
                    lastNumber ++;
                }
            }
        }
        
        System.out.println(lastNumber);
    }
}
