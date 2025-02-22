package backjoon;

import java.util.Scanner;

public class bj1010 {
    
    // 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 함.
    // 다리끼리는 서로 겹쳐질 수 없다고 할 때, 지을 수 있는 경우의 수
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = Integer.parseInt(scan.nextLine()); // 테스트 케이스 개수
        
        
        for(int i = 0; i < T; i++) {
            int N = scan.nextInt(); // 서쪽 사이트 개수
            int M = scan.nextInt(); // 동쪽 사이트 개수
            
            int count = 0; // 경우의 수
            
            if(N == M) { // 사이트 개수가 동일할 경우
                count = N;
            } else {
                
            }
            
            System.out.println(count);
        }
    }
    
}
