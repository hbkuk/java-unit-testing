package backjoon;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj2075 {
    
    /**
     * N번째 큰 수를 찾는 프로그램
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        scan.nextLine();
        
        Queue<Integer> queue = new PriorityQueue<>(); // 최소 힙
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int value = scan.nextInt();
                
                // queue가 꽉찼을 경우
                if(queue.size() >= N) {
                    
                    // 입력값이 마지막 숫자보다 클 경우에만
                    if(value > queue.peek()) {
                        queue.poll();
                        queue.offer(value);
                    }
                } else {
                    queue.offer(value);
                }
            }
        }
        
        System.out.println(queue.poll());
    }
}
