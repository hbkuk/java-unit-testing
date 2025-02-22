package backjoon;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class b1927j {
    
    /**
     * 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램
     * 
     * x 값이 자연수 인지?
     * true) 배열에 x라는 값을 추가
     * false) 배열에서 가장 작은 값을 출력 후 값 제거
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 연산의 개수
        
        Queue<Integer> queue = new PriorityQueue<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int value = scan.nextInt();
            
            if(value == 0) {
                if(queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.offer(value);
            }
        }
        
        System.out.println(sb);
    }
    
}
