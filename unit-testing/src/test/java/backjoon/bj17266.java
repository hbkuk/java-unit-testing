package backjoon;

import java.util.Scanner;

public class bj17266 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 굴다리 길이
        int M = scan.nextInt(); // 가로등 개수
        
        int[] positions = new int[M]; // M개의 가로등 위치
        for(int i = 0; i < M; i++) {
            positions[i] = scan.nextInt();
        }
        
        // 이분 탐색으로 적절한 가로등 높이 찾기
        int left = 1;
    }
    
}
