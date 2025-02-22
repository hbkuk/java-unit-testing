package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj14501_2 {
    
    // TODO 1: 입력 받기
    // TODO 2: 1일부터 N일까지 순회 ( 2중 for문 ) => 시간 복잡도 O(N^2)
    //  - 1일 선택 -> 다음 선택지 선택
    //      - 1일 시작 4일 종료 -> 4일 or 5일 선택. => 최대 값 갱신
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 남은 상담 일수
        int[][] consulting = new int[N + 1][2]; // [소요 기간, 수익]
        for(int i = 1; i <= N; i++) {
            consulting[i][0] = scan.nextInt();
            consulting[i][1] = scan.nextInt();
            scan.nextLine();
        }
        
        scan.close();
        
        int maxValue = 0;
        
        // 큐에 넣어서.. 반복하기..?
        Queue<int[]> queue = new LinkedList<>(); // [시작 날짜, 현재까지 수익]
        
        for(int i = 1; i <= N; i++) {
            int[] current = consulting[i];
            
            int 소요_기간 = current[0];
            int 수익 = current[1];
            
            int endDay = i + 소요_기간 - 1;
            if(N >= endDay) {
                queue.offer(new int[]{endDay + 1, 수익});
            }
        }
        
        while(!queue.isEmpty()) {
            int[] polled = queue.poll();
            int cDay = polled[0];
            int cValue = polled[1];
            
            maxValue = Math.max(maxValue, cValue);
            
            // 선택할 상담이 있어?
            for(int i = cDay; i <= N; i++) {
                int[] cCs = consulting[i];
                int 소요_기간 = cCs[0];
                int 수익 = cCs[1];
                
                //  -> 있을 경우, 다음 상담 선택 후 queue에 넣기
                int endDay = 소요_기간 + i - 1;
                if(N >= endDay) {
                    queue.offer(new int[]{endDay + 1, cValue + 수익});
                }
            }
        }
        System.out.println(maxValue);
    }
    
}
