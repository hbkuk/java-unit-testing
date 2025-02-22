package backjoon;

import java.util.Scanner;

public class bj20310 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String line = scan.nextLine(); // 0과 1로 이루어진 문자열
        
        int zeroCount = 0;
        int oneCount = 0;
        for(char c : line.toCharArray()) {
            if(c == '0') {
                zeroCount ++;
            } else {
                oneCount ++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("0".repeat(Math.max(0, zeroCount / 2)));
        sb.append("1".repeat(Math.max(0, oneCount / 2)));
        
        System.out.println(sb);
    }
    
}
