package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj2164 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        
        while(queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        
        System.out.println(queue.poll());
    }

}
